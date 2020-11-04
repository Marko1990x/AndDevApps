package firebaseapp.com.myadapterstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // treba mi promenjiva za lsitu prvo
    private ListView lstView;
    //treba mi metoda za popunavanje liste
    private final List<String> data = eatMyData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpList();





    }

    // metoda za popunavanje liste

    private void setUpList(){
        lstView = findViewById(R.id.listView); // ovo je element u designu xml
        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        // kontext je metoda ili klasa / ispis / data iz globalne promenjive
        lstView.setAdapter(adapter); // postavljanje adaptera na xml element
        // pogrsan listener sam stavio pazi koji koristis pogledaj logcat
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+id, Toast.LENGTH_SHORT).show();
            }
        });

    }

    // nije void nego je list string
    private List<String> eatMyData(){

        List<String> strings = new ArrayList<>(); // ne zaboravi da kazes da je nova lista
        for (int i = 0; i < 30 ; i++) {
            strings.add("element: " +i);
        }

        return  strings;
    }



}