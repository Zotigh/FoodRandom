package edu.cnm.deepdive.foodrandom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.List;

@Dao
public interface AccessDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<String> insert(Recipe... ingredients);

@Query("SELECT * FROM Recipe ORDER BY ingredients DESC")
  List<Recipe> findAll();

}
