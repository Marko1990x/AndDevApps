package github.io.domacicas15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Spinner extends AppCompatActivity {

    private android.widget.Spinner spinner;
    private final List<String> data = getData();

    private List<String> getData() {
        int i;
        ArrayList<String> strings = new ArrayList<>();
        for (i = 0; i < 30; i++) {

            strings.add("Element: " + i);

        }
        return strings;
    }

    private void fillSpinner() {
        // prvo poverzi za hml fajlnom objekat
        spinner = findViewById(R.id.spinnerfromxml3);
        // data parametar prosledjue vrednosti nemoj da ga zaboravis
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, data);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Spinner.this, data.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(Spinner.this, "Nothing Selected", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        fillSpinner();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Pozdrav iz Spinner-a", Toast.LENGTH_SHORT).show();
    }
}