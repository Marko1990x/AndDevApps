package firebaseapp.com.domaci15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Provider.JeloProvider;

public class FirstActivity extends AppCompatActivity {

    // model pravi objekat (kostur)
    // provider puni podatke (kostur)
    // adapter povezuje podatke sa xml-fajlom
    // ovaj domaci nema adapter podaci su povezani preko providera sto su samo metode koje instanciraju objekte
    // ima jedan adapter za spinner
    //Loads fruits from array resource

    final List<String> jeloNames = JeloProvider.getJeloNames();
    ListView listaJela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
       // Toast.makeText(this, "Hey pokrenuto je"+JeloProvider.getJeloNames(), Toast.LENGTH_SHORT).show();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,jeloNames);
        listaJela = findViewById(R.id.lstJela); // mora posle adaptera da ide ovo nemoze gore
        listaJela.setAdapter(arrayAdapter);
        listaJela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("kljuc",position);
                Toast.makeText(FirstActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });



    }
}