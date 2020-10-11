package com.example.radnacasu15;

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

    ListView list;
    List<String> data;

    // pogledaj ovo https://stackoverflow.com/questions/3674951/whats-the-role-of-adapters-in-android

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list);
        data = getnames();
        // zakomentarisano zbog drugoga
      /* final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,data);  // pogledaj ovo
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {   // ovo je za event listener
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, (String) adapter.getItem(position), Toast.LENGTH_SHORT).show();
                // string je kastovan mora se dodati kod custom obavezno
            }
        });*/


        final SongAdapter songAdapter = new SongAdapter(getSongs(),this);
        list.setAdapter(songAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {   // ovo je za event listener
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, (String) songAdapter.getItem(position).getName(), Toast.LENGTH_SHORT).show();
                // string je kastovan mora se dodati kod custom obavezno
                // mora se object promeniti u song
            }
        });
    }

    private List<String> getnames(){
        List<String> names = new ArrayList<>();
        for (int i = 0; i < 15 ; i++) {
            names.add("element " + i);
        }
        return names; // mora da vraca to je bila greska

    }
    private List<Song> getSongs(){
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < 15 ; i++) {
            songs.add(new Song("Author "+i, "Name "+i)); // konkantenacija i pretvara integer u string

        }
        return songs; // mora da vraca to je bila greska

    }


}