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
package edu.cnm.deepdive.foodrandom.service;

import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.foodrandom.BuildConfig;
import edu.cnm.deepdive.foodrandom.FoodApplication;
import edu.cnm.deepdive.foodrandom.R;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import edu.cnm.deepdive.foodrandom.model.pojo.RecipeResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeService {

  @GET("api/recipes")
  Call<RecipeResponse> getRecipes(@Query("_app_id") String appId, @Query("_app_key") String apiKey, @Query("q") String searchTerm);

  /**
   * uses retro fit and converts to a gson
   */
  class InstanceHolder {

    private static final RecipeService INSTANCE;
    private static final String API_KEY;
    private static final String APP_ID;

    static {
      FoodApplication application = FoodApplication.getInstance();
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .create();
      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(application.getApplicationContext().getString(R.string.base_url))
          .addConverterFactory(GsonConverterFactory.create(gson))
          .build();
      INSTANCE = retrofit.create(RecipeService.class);
      API_KEY = BuildConfig.API_KEY;
      APP_ID = BuildConfig.APP_ID;
    }

  }

  /**
   * Creates a base fluent Async Task to get a response from the api
   */
  class RecipesTask extends BaseFluentAsyncTask<String, Void, Recipe, Recipe> {

    @Nullable
    @Override
    protected Recipe perform(String... strings) throws TaskException {
      try {
        Response<RecipeResponse> response = InstanceHolder.INSTANCE.getRecipes(InstanceHolder.APP_ID,
            InstanceHolder.API_KEY, strings[0]).execute();
        if (!response.isSuccessful()) {
          throw new TaskException();
        }
        assert response.body() != null;
        return response.body().getRandomMatch();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

  }

}
