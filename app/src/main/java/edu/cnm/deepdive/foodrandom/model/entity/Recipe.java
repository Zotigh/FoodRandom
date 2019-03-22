package edu.cnm.deepdive.foodrandom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Recipe {

  @ColumnInfo(name = "recipe_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull
  @Expose
  private String[] ingredients;

  @Expose
  @ColumnInfo(name = "recipe_name")
  private String recipeName;

  @ColumnInfo(name = "nutrition_estimates")
  @Expose
  private String nutritionEstimates;

  @Expose
  private int totalTimeInSeconds;

  @Expose
  private String[] smallImageUrls;

  @Expose
  @SerializedName("id")
  private String recipeKey;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String[] getIngredients() {
    return ingredients;
  }

  public void setIngredients(@NonNull String[] ingredients) {
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

  public int getTotalTimeInSeconds() {
    return totalTimeInSeconds;
  }

  public void setTotalTimeInSeconds(int totalTimeInSeconds) {
    this.totalTimeInSeconds = totalTimeInSeconds;
  }

  public String[] getSmallImageUrls() {
    return smallImageUrls;
  }

  public void setSmallImageUrls(String[] smallImageUrls) {
    this.smallImageUrls = smallImageUrls;
  }

  public String getRecipeKey() {
    return recipeKey;
  }

  public void setRecipeKey(String recipeKey) {
    this.recipeKey = recipeKey;
  }

  @Override
  public String toString() {
    return recipeName;
  }

}
