package com.nikoladj.termin15_listview_customadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lvList;
    private final List<String> data = getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupList();
    }

    private void setupList(){
        lvList = findViewById(R.id.lvList);
        MyAdapter adapter = new MyAdapter(this, data);
        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        MainActivity.this,
                        data.get(i),
                        Toast.LENGTH_SHORT).show();
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

