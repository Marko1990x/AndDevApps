package github.io.domacicas15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListView extends AppCompatActivity {


    private android.widget.ListView lvList; // za samu listu
    // za podatke
    private final List<String>data = data();

    private List<String> data(){

        int i;
        List<String> falseData = new ArrayList<String>();
        for (i = 0; i < 30 ; i++) {
            falseData.add("Element: " + i);

        }


        return falseData;
    }

    private void fillList(){
        lvList = findViewById(R.id.lvList);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        lvList.setAdapter(adapter);
        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView.this,data.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        fillList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Pozdrav iz List View-a", Toast.LENGTH_SHORT).show();
    }
}