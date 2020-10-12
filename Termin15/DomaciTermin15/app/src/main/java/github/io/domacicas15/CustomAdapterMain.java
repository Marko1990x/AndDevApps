package github.io.domacicas15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapterMain extends AppCompatActivity {

    // ovaj sto extenduje activity tu puni podatke za adapter

    private ListView listView;
    private final List<String> stringList = fillList();

    private List<String> fillList() {
        int i;
        ArrayList<String> strings = new ArrayList<>();
        for (i = 0; i < 30; i++) {
            strings.add("Element: " + i);
        }
        return strings;

    }

    private void setUpList(){

        listView = findViewById(R.id.lvListAdapterMain);
        CustomAdapterModel adapterModel = new CustomAdapterModel(this, stringList); // salje se konstruktoru
        listView.setAdapter(adapterModel);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomAdapterMain.this, stringList.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adaptermain);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Pozdrav iz Custom  Adaptera", Toast.LENGTH_SHORT).show();
        setUpList();
    }
}