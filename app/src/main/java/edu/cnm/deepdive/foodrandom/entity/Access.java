package edu.cnm.deepdive.foodrandom.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;
import java.io.Serializable;

@Entity(tableName = "Recipes_table")
public class Access {

  @ColumnInfo(name = "recipe_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull
  @Expose
  private String ingredients;

  @Expose
  private double flavors;

  @Expose
  private String recipeName;

  @Expose
  private double rating;

}
