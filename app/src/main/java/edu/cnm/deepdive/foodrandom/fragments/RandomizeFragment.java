package edu.cnm.deepdive.foodrandom.fragments;

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
import edu.cnm.deepdive.foodrandom.model.pojo.RecipeResponse;
import edu.cnm.deepdive.foodrandom.service.RecipeService;
import java.util.Objects;

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

    ranButton.setOnClickListener((v) -> new RecipeService.RecipesTask()
        .setSuccessListener((result) -> {
          ArrayAdapter<String> adapter = new ArrayAdapter<>(
              Objects.requireNonNull(this.getContext()), android.R.layout.simple_list_item_1, result.getIngredients());
          textView.setText(result.getRecipeName());
          Glide.with(imageView).load(result.getSmallImageUrls()[0]).into(imageView);
          recipesListView.setAdapter(adapter);
          Log.d(getClass().getSimpleName(), result.toString());
          saveButton.setOnClickListener((b) -> new SaveRecipeTask().execute(result));
        })
        .execute(textInputIngredient.getText().toString()));
    return view;
  }


  private static class SaveRecipeTask extends AsyncTask<Recipe, Void, Void> {

    @Override
    protected Void doInBackground(Recipe... recipes) {
      FoodDB.getInstance().getRecipeDao().insert(recipes);
      return null;
    }
  }
//  private boolean validateIngredient() {
//    String ingredientInput = textInputIngredient.getEditText().getText().toString().trim();
//
//    if (ingredientInput.isEmpty()) {
//      textInputIngredient.setError("Field can't be left empty");
//      return false;
//    } else {
//      textInputIngredient.setError(null);
//      return true;
//    }
//  }

}
