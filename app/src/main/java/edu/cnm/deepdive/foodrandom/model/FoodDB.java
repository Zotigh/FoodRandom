/*
 *  Copyright 2019 Lance Zotigh & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.foodrandom.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import edu.cnm.deepdive.foodrandom.FoodApplication;
import edu.cnm.deepdive.foodrandom.model.FoodDB.Converters;
import edu.cnm.deepdive.foodrandom.model.dao.AccessDao;
import edu.cnm.deepdive.foodrandom.model.dao.RecipeDao;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;


/**
 * Defines the local database as a collection of its entities and converters, with the singleton
 * pattern implemented for app-wide use of a single connection, and declares methods to retrieve a
 * data access object (DAO) for the database entities.
 */
@Database(
    entities = {Recipe.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class FoodDB extends RoomDatabase {

  private static final String DB_NAME = "food_db";

  /**
   *Returns the single instance of {@link FoodDB} for the current application context.
   *
   *@return single {@link FoodDB} instance reference.
   */
  public synchronized static FoodDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   *Returns an instance of a Room-generated implementation of {@link RecipeDao}.
   *
   *@return data access object for CRUD operations involving {@link Recipe} instances.
   */
  public abstract RecipeDao getRecipeDao();

  /**
   *Returns an instance of a Room-generated implementation of {@link AccessDao}.
   *
   *@return data access object for CRUD operations involving {@link Recipe} instances.
   */
  public abstract AccessDao getAccessDao();

  private static class InstanceHolder {

    private static final FoodDB INSTANCE = Room.databaseBuilder(
        FoodApplication.getInstance().getApplicationContext(), FoodDB.class, DB_NAME)
        .build();
  }

  /**
   * Supports conversion operations for persistence of relevant types not natively supported by
   * Room/SQLite.
   */
  public static class Converters {

    private static final String JOIN_DELIMITER = "|";
    private static final String SPLIT_DELIMITER = "\\|";

    /**
     * Converts a {@link String[]} to an {@link String} and returns the {@link String}.
     *
     * @param values as a string.
     * @return a {@link String} instance.
     */
    @TypeConverter
    public static String stringArrayToString(String[] values) {
      if (values == null){
        return null;
      }
      StringBuilder builder = new StringBuilder();
      for (String value : values) {
        builder.append(value);
        builder.append(JOIN_DELIMITER);
      }
      builder.deleteCharAt(builder.length() - 1);
      return builder.toString();
    }

    /**
     * Converts a {@link String} to a {@link String[]} and returns the {@link String[]}.
     *
     * @param value as a string array
     * @return a {@link String[]} instance.
     */
    @TypeConverter
    public static String[] stringToStringArray(String value) {
      if (value == null){
        return null;
      }
      return value.split(SPLIT_DELIMITER);
    }
  }
}
