/*
 *  Copyright 2019 Lance Zotigh & Deep Dive Coding
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.foodrandom.model.pojo;

import com.google.gson.annotations.Expose;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.Random;

/**
 * Saves {@link Recipe} instances in a plain old java object, gets matches for the desired returned fields and randomizes.
 */
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
