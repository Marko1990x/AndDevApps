package firebaseapp.com.customadapter;

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

    private ListView listView;
    private final List<String> strings = strings();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpList();
    }


    private void setUpList(){
        listView = findViewById(R.id.lstView);
        // nemoj da pogressi ovde nije ArrayAddapter nego je prokeleti custom adapter

        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, strings);
        mojAdapter mojAdapter = new mojAdapter(this, strings);
        // ovo treba da zadovolji konstruktor
        listView.setAdapter(mojAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Kliknuli ste element sa id: "+position, Toast.LENGTH_SHORT).show();
            }
        });
    }



    private List<String>strings(){
        List<String> list = new ArrayList();
        for (int i = 0; i < 30 ; i++) {
            list.add("Element" +i);
        }
        return list;
    }
}