package edu.cnm.deepdive.foodrandom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;

@Dao
public interface AccessDao {

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(Recipe... recipes);

  @Delete
  int delete(Recipe... recipeName);
}
