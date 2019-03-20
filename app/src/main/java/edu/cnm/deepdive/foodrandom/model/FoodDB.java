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
import edu.cnm.deepdive.foodrandom.model.entity.Nutrition;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;

@Database(
    entities = {Recipe.class, Nutrition.class},
    version = 1,
    exportSchema = true
)
@TypeConverters(Converters.class)
public abstract class FoodDB extends RoomDatabase {

  public static final String DB_NAME = "food_db";

  public synchronized static FoodDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract RecipeDao getRecipeDao();

  public abstract AccessDao getAccessDao();

  private static class InstanceHolder {

    private static final FoodDB INSTANCE = Room.databaseBuilder(
        FoodApplication.getInstance().getApplicationContext(), FoodDB.class, DB_NAME)
        .build();
  }

  public static class Converters {

    private static final String JOIN_DELIMITER = "|";
    private static final String SPLIT_DELIMITER = "\\|";

    @TypeConverter
    public static String stringArrayToString(String[] values) {
      StringBuilder builder = new StringBuilder();
      for (String value: values) {
        builder.append(value);
        builder.append(JOIN_DELIMITER);
      }
      builder.deleteCharAt(builder.length() - 1);
      return builder.toString();
    }

    @TypeConverter
    public static String[] stringToStringArray(String value) {
      return value.split(SPLIT_DELIMITER);
    }
  }
}
