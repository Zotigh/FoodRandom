package edu.cnm.deepdive.foodrandom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;

@Entity
public class Recipe {

  @ColumnInfo(name = "id")
  @NonNull
  @PrimaryKey
  private String id;

  @NonNull
  @Expose
  private String ingredients;

  @ColumnInfo(name = "recipe_name")
  @Expose
  private String recipeName;

  @ColumnInfo(name = "nutrition_Estimates")
  @Expose
  private String nutritionEstimates;

  @ColumnInfo(name = "total_time_in_seconds")
  @Expose
  private long totalTimeInSeconds;

  private class Images {
    @ColumnInfo(name = "hosted_large_url")
    @Expose
    private String hostedLargeUrl;

    @ColumnInfo(name = "hosted_small_url")
    @Expose
    private String hostedSmallUrl;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @NonNull
  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(@NonNull String ingredients) {
    this.ingredients = ingredients;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }

  public String getNutritionEstimates() {
    return nutritionEstimates;
  }

  public void setNutritionEstimates(String nutritionEstimates) {
    this.nutritionEstimates = nutritionEstimates;
  }

  public long getTotalTimeInSeconds() {
    return totalTimeInSeconds;
  }

  public void setTotalTimeInSeconds(long totalTimeInSeconds) {
    this.totalTimeInSeconds = totalTimeInSeconds;
  }
}
