package edu.cnm.deepdive.foodrandom.model.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import com.google.gson.annotations.Expose;

@Entity
public class Recipe {

  @PrimaryKey
  @Expose
  private String id;

  @NonNull
  @Expose
  private String ingredients; // [] does this need these?

  @Expose
  private String recipeName;

  @Expose
  private String nutritionEstimates;

  @Expose
  private long totalTimeInSeconds;

  private class Images {
    @Expose
    private String hostedLargeUrl;

    @Expose
    private String hostedSmallUrl;
  }

}
