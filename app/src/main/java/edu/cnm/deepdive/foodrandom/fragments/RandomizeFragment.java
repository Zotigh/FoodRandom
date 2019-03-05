package edu.cnm.deepdive.foodrandom.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import edu.cnm.deepdive.foodrandom.R;

public class RandomizeFragment extends Fragment{

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_randomize, container, false);
//
//    Spinner spinner = findViewById(R.id.spinnerMeat);
//    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
//    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//    spinner.setAdapter(adapter);
//    spinner.setOnItemSelectedListener(this);
     return view;


  }
}
