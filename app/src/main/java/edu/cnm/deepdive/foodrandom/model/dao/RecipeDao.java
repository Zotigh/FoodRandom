package edu.cnm.deepdive.foodrandom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.List;

@Dao
public interface RecipeDao {

  @Query("SELECT * FROM Recipe ORDER BY recipe_name DESC")
  List<Recipe> findAll();

  @Query("SELECT * FROM Recipe WHERE recipe_id = :recipeId")
  Recipe findById(long recipeId);

  @Insert
  List<Long> insert(Recipe... recipes);

  @Delete
  int delete(Recipe... recipes);
}
