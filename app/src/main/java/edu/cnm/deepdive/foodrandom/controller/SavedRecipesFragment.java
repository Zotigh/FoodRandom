package edu.cnm.deepdive.foodrandom.controller;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import edu.cnm.deepdive.foodrandom.R;
import edu.cnm.deepdive.foodrandom.fragments.DisplaySavedRecipesFragment;
import edu.cnm.deepdive.foodrandom.model.FoodDB;
import edu.cnm.deepdive.foodrandom.model.entity.Recipe;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SavedRecipesFragment extends Fragment implements OnItemClickListener {

  private List<Recipe> recipes;
  private ArrayAdapter<Recipe> adapter;

  @SuppressLint("StaticFieldLeak")
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_saved_recipes, container, false);



    ListView listView = view.findViewById(R.id.recipe_list);
    listView.setOnItemClickListener(this);
    recipes = new LinkedList<>();
    ArrayAdapter<Recipe> adapter = new ArrayAdapter<>(
        Objects.requireNonNull(SavedRecipesFragment.this.getContext()),
        android.R.layout.simple_list_item_1, recipes);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener((adapterView, view1, i, l) -> {
      DisplaySavedRecipesFragment details = DisplaySavedRecipesFragment.newInstance(recipes.get(i).getId());
      assert getFragmentManager() != null;
      FragmentTransaction ft = getFragmentManager().beginTransaction().replace(R.id.fragment_container, details);
      ft.addToBackStack(null);
      ft.commit();
    });

    new AsyncTask<Void, Void, List<Recipe>>() {

      @Override
      protected List<Recipe> doInBackground(Void... voids) {
        return FoodDB.getInstance().getRecipeDao().findAll();
      }

      @Override
      protected void onPostExecute(List<Recipe> recipes) {
        SavedRecipesFragment.this.recipes.clear();
        SavedRecipesFragment.this.recipes.addAll(recipes);
        adapter.notifyDataSetChanged();
      }
    }.execute();

    return view;
  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    Recipe selectedRecipe = recipes.get(i);
    long selectedRecipeId = selectedRecipe.getId();
  }
}
