package edu.cnm.deepdive.foodrandom.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.cnm.deepdive.foodrandom.R;
import edu.cnm.deepdive.foodrandom.model.FoodDB;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.List;

public class SavedRecipesFragment extends Fragment implements View.OnClickListener {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      //ask about @Nullable
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_saved_recipes, container, false);

    ListView listView = view.findViewById(R.id.recipe_list);

    new AsyncTask<Void, Void, List<Recipe>>() {

      @Override
      protected List<Recipe> doInBackground(Void... voids) {
        return FoodDB.getInstance().getRecipeDao().findAll();
      }

      @Override
      protected void onPostExecute(List<Recipe> recipes) {
        ArrayAdapter<Recipe> adapter = new ArrayAdapter<Recipe>(SavedRecipesFragment.this.getContext(),
            android.R.layout.simple_list_item_1, recipes);
        listView.setAdapter(adapter);
      }
    }.execute();

    return view;
  }

  @Override
  public void onClick(View view) {

  }

}
