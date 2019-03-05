package edu.cnm.deepdive.foodrandom.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import edu.cnm.deepdive.foodrandom.FoodApplication;
import edu.cnm.deepdive.foodrandom.model.dao.AccessDao;
import edu.cnm.deepdive.foodrandom.model.entity.Nutrition;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;

@Database(
    entities = {Recipe.class, Nutrition.class},
    version = 1,
    exportSchema = true
)

public abstract class FoodDB extends RoomDatabase {

  public static final String DB_NAME = "food_db";

  public synchronized static FoodDB getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract AccessDao getAccessDao();

  private static class InstanceHolder {

    private static final FoodDB INSTANCE = Room.databaseBuilder(
        FoodApplication.getInstance().getApplicationContext(), FoodDB.class, DB_NAME)
        .build();

  }
}
