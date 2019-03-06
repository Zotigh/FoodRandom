package edu.cnm.deepdive.foodrandom.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import edu.cnm.deepdive.foodrandom.R;

public class RandomizeFragment extends Fragment{

  Spinner spinnerVegitable;
  Spinner spinnerMeat;
  Button ranButton;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_randomize, container, false);

    spinnerVegitable = view.findViewById(R.id.spinnerVegetable);
    spinnerMeat =  view.findViewById(R.id.spinnerMeat);

    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity(),
        R.array.meat_selection, android.R.layout.simple_spinner_item);
    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerMeat.setAdapter(adapter1);

    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
        R.array.vegetables_selection, android.R.layout.simple_spinner_item);
    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinnerVegitable.setAdapter(adapter2);

//    ranButton.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View view) {
//        spinnerMeat.getSelectedItem().toString();
//        spinnerVegitable.getSelectedItem().toString();
//      }
//    });
    spinnerMeat.getSelectedItem();

    return view;

  }
}
