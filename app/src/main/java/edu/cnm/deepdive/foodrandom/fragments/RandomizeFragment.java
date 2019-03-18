package edu.cnm.deepdive.foodrandom.fragments;

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
import android.widget.ListView;
import edu.cnm.deepdive.foodrandom.R;
import edu.cnm.deepdive.foodrandom.service.RecipeService;

public class RandomizeFragment extends Fragment {

  private Button ranButton;
  private EditText textInputIngredient;
  private RecipeService service;
  private ListView recipesListView;
  private Editable edit = null;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_randomize, container, false);

    textInputIngredient = view.findViewById(R.id.text_input_ingredient);
    ranButton = view.findViewById(R.id.randomize_button);
    recipesListView = view.findViewById(R.id.random_recipe_result);
    ranButton.setOnClickListener((v) -> new RecipeService.RecipesTask()
        .setSuccessListener((result) -> {
          // TODO Use result.matches to display and/or write to database.
          ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, result.getIngredients());
          recipesListView.setAdapter(adapter);
          Log.d(getClass().getSimpleName(), result.toString());
        })
        .execute(textInputIngredient.getText().toString()));
    return view;
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
