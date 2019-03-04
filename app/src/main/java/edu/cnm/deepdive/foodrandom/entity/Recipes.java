package edu.cnm.deepdive.foodrandom.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

@Entity
public class Recipes {

  @ColumnInfo(name = "user_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "recipe_id", index = true)
  private long recipeId;

  private String Recipe_directions;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }

  public String getRecipe_directions() {
    return Recipe_directions;
  }

  public void setRecipe_directions(String recipe_directions) {
    Recipe_directions = recipe_directions;
  }
}
