package com.nikoladj.termin15_spinner_arrayadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private Spinner spnSpinner;
    private final List<String> data = getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupSpinner();
    }

    private void setupSpinner(){
        spnSpinner = findViewById(R.id.spnSpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                data
        );
        spnSpinner.setAdapter(adapter);
        spnSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        data.get(i),
                        Toast.LENGTH_SHORT
                ).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(
                        MainActivity.this,
                        "Nothing selected",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    private List<String> getData(){
        List<String> dummyData = new ArrayList<>();
        for (int i = 1; i <= 20; i++){
            dummyData.add("Element " + i);
        }
        return dummyData;
    }
}

