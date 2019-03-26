package edu.cnm.deepdive.foodrandom.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.List;

/**
 * Declares basic CRUD operations for {@link Recipe} instances in the local database, using Room
 * annotations.
 */
@Dao
public interface RecipeDao {

  /**
   * Selects and returns all {@link Recipe} instances in the local database, sorting the result in
   * descending recipe_name order.
   *
   * @return all {@link Recipe} instances in local database.
   */
  @Query("SELECT * FROM Recipe ORDER BY recipe_name DESC")
  List<Recipe> findAll();

  /**
   * Selects and returns the single {@link Recipe} instance (or null) for the specified {@link Recipe}.
   *
   * @param recipeId desired {@link Recipe}.
   * @return {@link Recipe} instance if found in database; <code>null</code> otherwise.
   */
  @Query("SELECT * FROM Recipe WHERE recipe_id = :recipeId")
  Recipe findById(long recipeId);

  /**
   *Inserts one{@link Recipe} instances into the local database. Any primary or unique key
   *constraint violations will result in the existing records being retained.
   *
   * @param recipes {@link Recipe} instance to be inserted.
   * @return inserted record ID(s).
   */
  @Insert
  List<Long> insert(Recipe... recipes);

  /**
   * Will Delete one or more {@link Recipe} instances from local database once implemented.
   *
   * @param recipes  instances of {@link Recipe} to be deleted from database.
   * @return number of records deleted.
   */
  @Delete
  int delete(Recipe... recipes);
}
