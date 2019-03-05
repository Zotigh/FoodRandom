package edu.cnm.deepdive.foodrandom.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.Expose;

@Entity(
    foreignKeys = @ForeignKey(
        entity = edu.cnm.deepdive.foodrandom.model.entity.Nutrition.class,
        parentColumns = "access_id", childColumns = "recipe_id",
        onDelete = ForeignKey.CASCADE
    ),
    indices = @Index("recipe_id")
)
public class Nutrition {

  @ColumnInfo(name = "access_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "recipe_id")
  @Expose
  private String recipeId;

  @Expose
  private String attribute;

  @Expose
  private double value;


  public String getAttribute() {
    return attribute;
  }

  public void setAttribute(String attribute) {
    this.attribute = attribute;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(String recipeId) {
    this.recipeId = recipeId;
  }
}
