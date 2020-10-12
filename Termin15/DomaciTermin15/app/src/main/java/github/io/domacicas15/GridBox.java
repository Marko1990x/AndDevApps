package github.io.domacicas15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridBox extends AppCompatActivity {

    // pre onCreate metode

    private GridView gridView;
    private final List<String> data = getData();
    //Method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridbox);
        fillGrid();
    }


    private void fillGrid() {
        //gridView promenjiva koju sam definisao
        gridView = findViewById(R.id.gridFromXML4);  // veza sa elementom koji se puni

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        // genericni kod za adapter
        gridView.setAdapter(adapter); // postavljeno ovde
        // listener
        // ako se buni ili automatski ne puni ima greska negde ja sam stavion on click umesto on item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        GridBox.this,
                        data.get(i),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }

    private List<String> getData() {   // puni elemente za grid

        List<String> dataX = new ArrayList<String>();

        int i;
        for ( i = 0; i < 30; i++) {
            dataX.add("Element: " + i);
        }

        return dataX;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Pozdrav iz GridBox", Toast.LENGTH_SHORT).show();
    }
}