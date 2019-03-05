package edu.cnm.deepdive.foodrandom.model.entity;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import edu.cnm.deepdive.foodrandom.model.entity.FoodDB.Converters;
import edu.cnm.deepdive.foodrandom.model.entity.entity.Nutrition;
import edu.cnm.deepdive.foodrandom.model.entity.entity.Recipe;

@Database(
    entities = {Recipe.class, Nutrition.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class FoodDB extends RoomDatabase {

  public static final String DB_NAME = "food_db";

  private static class InstanceHolder {

  }

  public static class Converters{

  }

}
