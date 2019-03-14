package edu.cnm.deepdive.foodrandom.model.pojo;

import com.google.gson.annotations.Expose;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.Random;

public class RecipeResponse {

  private Random rng;

  @Expose
  private Recipe[] matches;

  public Recipe[] getMatches() {
    return matches;
  }

  public void setMatches(Recipe[] matches) {
    this.matches = matches;
  }

  public Recipe getRandomMatch() {
    rng = new Random();
    int newIndex = rng.nextInt(matches.length);
    return matches[newIndex];
  }
}
