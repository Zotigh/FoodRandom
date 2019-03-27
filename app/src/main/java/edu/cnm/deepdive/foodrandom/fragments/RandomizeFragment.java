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
package edu.cnm.deepdive.foodrandom.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import edu.cnm.deepdive.foodrandom.R;
import edu.cnm.deepdive.foodrandom.model.FoodDB;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import edu.cnm.deepdive.foodrandom.service.RecipeService;
import java.util.Objects;

/***
 *Acts as the main fragment retreaving Recipes from the api and populating the {@link ListView}.
 */
public class RandomizeFragment extends Fragment {

  private Button ranButton;
  private EditText textInputIngredient;
  private RecipeService service;
  private ListView recipesListView;
  private Editable edit = null;
  private ImageView imageView;
  private TextView textView;
  private Button saveButton;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_randomize, container, false);

    textInputIngredient = view.findViewById(R.id.text_input_ingredient);
    ranButton = view.findViewById(R.id.randomize_button);
    recipesListView = view.findViewById(R.id.random_recipe_result);
    imageView = view.findViewById(R.id.recipe_image);
    textView = view.findViewById(R.id.recipe_name);
    saveButton = view.findViewById(R.id.save_button);

    ranButton.setOnClickListener((v) -> {
      new RecipeService.RecipesTask()
        .setSuccessListener((result) -> {
          ArrayAdapter<String> adapter = new ArrayAdapter<>(
              Objects.requireNonNull(this.getContext()), android.R.layout.simple_list_item_1, result.getIngredients());
          textView.setText(result.getRecipeName());
          Glide.with(imageView).load(result.getSmallImageUrls()[0]).into(imageView);
          recipesListView.setAdapter(adapter);
          Log.d(getClass().getSimpleName(), result.toString());
          saveButton.setOnClickListener((b) -> new SaveRecipeTask().execute(result));
        })
        .execute(textInputIngredient.getText().toString());
      SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
      SharedPreferences.Editor editor = sharedPref.edit();
      editor.putString(getString(R.string.saved_text), textInputIngredient.getText().toString());
      editor.apply();
    });
    SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
    String savedInput = sharedPref.getString(getString(R.string.saved_text), "");
    textInputIngredient.setText(savedInput);
    return view;
  }


  private static class SaveRecipeTask extends AsyncTask<Recipe, Void, Void> {

    @Override
    protected Void doInBackground(Recipe... recipes) {
      FoodDB.getInstance().getRecipeDao().insert(recipes);
      return null;
    }

  }

}
