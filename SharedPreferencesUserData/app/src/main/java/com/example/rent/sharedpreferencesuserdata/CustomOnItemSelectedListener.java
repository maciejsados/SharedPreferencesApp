package com.example.rent.sharedpreferencesuserdata;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Maciej on 2017-01-13.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(parent.getContext(),
//                "Language : " + parent.getItemAtPosition(position).toString(),
//                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
