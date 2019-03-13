package edu.cnm.deepdive.foodrandom.model.pojo;

import com.google.gson.annotations.Expose;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;

public class RecipeResponse {

  @Expose
  private Recipe[] matches;

  public Recipe[] getMatches() {
    return matches;
  }

  public void setMatches(Recipe[] matches) {
    this.matches = matches;
  }

}
