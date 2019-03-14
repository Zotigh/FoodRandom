package edu.cnm.deepdive.foodrandom.service;

import android.support.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.foodrandom.BuildConfig;
import edu.cnm.deepdive.foodrandom.FoodApplication;
import edu.cnm.deepdive.foodrandom.R;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import edu.cnm.deepdive.foodrandom.model.pojo.RecipeResponse;
import java.io.IOException;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeService {

  @GET("api/recipes")
  Call<RecipeResponse> getRecipes(@Query("_app_id") String appId, @Query("_app_key") String apiKey, @Query("q") String searchTerm);


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
        return response.body().getRandomMatch();
      } catch (Exception e) {
        throw  new RuntimeException(e);
      }
    }

  }

}
