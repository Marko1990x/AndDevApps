package com.example.cas_15_spiner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getNames());
        spinner.setAdapter(adapter);

        // ovde ima spinner.setonitemselectedlistener

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int x = position+1;
                Toast.makeText(MainActivity.this, "Selectovana pozicija: " + x, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // ovo je kada se nista ne izabere ali kada ce se ovo izvrsiti nezna se verovatno nikada
                // jer je po defaultu izabrana prva opcija
            }
        });
    }


    private List<String> getNames(){  // za popunavanje liste
        List<String> names = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            names.add("Element " +i);
        }
        return  names;
    }

}