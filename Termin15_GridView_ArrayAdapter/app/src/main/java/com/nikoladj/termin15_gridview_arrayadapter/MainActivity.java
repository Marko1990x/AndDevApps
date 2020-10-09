package com.nikoladj.termin15_gridview_arrayadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private GridView gvGrid;
    private final List<String> data = getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupGrid();
    }

    private void setupGrid(){
        gvGrid = findViewById(R.id.gvGrid);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                data
        );
        gvGrid.setAdapter(adapter);
        gvGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        data.get(i),
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

