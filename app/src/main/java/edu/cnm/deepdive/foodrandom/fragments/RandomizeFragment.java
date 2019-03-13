package edu.cnm.deepdive.foodrandom.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import edu.cnm.deepdive.foodrandom.R;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import edu.cnm.deepdive.foodrandom.service.RecipeService;
import java.util.Random;

public class RandomizeFragment extends Fragment {

  private Button ranButton;
  private EditText textInputIngredient;
  private RecipeService service;
  private Random rng;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_randomize, container, false);
    textInputIngredient = view.findViewById(R.id.text_input_ingredient);
    ranButton = view.findViewById(R.id.randomize_button);
    ranButton.setOnClickListener((v) -> new RecipeService.RecipesTask()
        .setSuccessListener((result) -> {
          // TODO Use result.matches to display and/or write to database.
          result.getMatches();
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
