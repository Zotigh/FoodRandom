package edu.cnm.deepdive.foodrandom;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import edu.cnm.deepdive.foodrandom.fragments.RandomizeFragment;
import edu.cnm.deepdive.foodrandom.controller.SavedRecipesFragment;

/**
 * sets the nav activity to there perspective fragments. Primary controller for switching between fragments
 */
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
    bottomNav.setOnNavigationItemSelectedListener(navListener);
  }

  private BottomNavigationView.OnNavigationItemSelectedListener navListener =
      item -> {
        Fragment selectedFragment = null;

        switch (item.getItemId()) {
          case R.id.navigation_randomize:
            selectedFragment = new RandomizeFragment();
            break;
          case R.id.navigation_recipes:
            selectedFragment = new SavedRecipesFragment();
            break;
        }

        assert selectedFragment != null;
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
            selectedFragment).commit();

        return true;
      };
}