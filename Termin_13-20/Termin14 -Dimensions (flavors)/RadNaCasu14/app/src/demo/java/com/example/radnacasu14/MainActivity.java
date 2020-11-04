package com.example.radnacasu14;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
// ako hocu da delim aplikaciju po verzijama full free , onda dodajem nove "dimenzije applikacije"
    // pogledaj u build variants
    // kroz gradle skriptu ili build 2 variante
    // gradle za nas projekat build.gradle app - build.gradle nije onaj koji je u root-u za sve applikacije jer mogu da ih imam vise


    /*

-- add flavor dimension -- prva opcija pravi dimenziju - druga opcija je opcija u okviru verzije

new - folder - java folder - new - res folder (resource) folder
-- active build variant - pokazuje ono sto je u fokusu menja boljenje (sta je u fokusu) na levoj strani prozora
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void drugaAktivnost(View view){
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
    
    public void klikniMe(View view){
        Toast.makeText(this, "ovo je demo verzija", Toast.LENGTH_SHORT).show();
    }



}