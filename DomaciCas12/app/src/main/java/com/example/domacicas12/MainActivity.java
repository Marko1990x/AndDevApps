package com.example.domacicas12;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   // metode po redosledu


    @Override
    protected void onStart() {
        Log.i("MainActivity","pozdrav iz onstart metode"); // koristi klasu kao tag za log
       // Toast.makeText(this, "pozdrav iz on start metode", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i("MainActivity","pozdrav iz onResume metode");
        //Toast.makeText(this, "pozdrav iz onResume metode", Toast.LENGTH_SHORT).show();
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("MainActivity","pozdrav iz onPause metode");
      //  Toast.makeText(this, "Pozdrav iz onPause metode", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("MainActivity","pozdrav iz onStop metode");
      //  Toast.makeText(this, "pozdrav iz onStop metode", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i("MainActivity","pozdrav iz onDestroy metode");
        //Toast.makeText(this, "pozdrav iz onDestroy Metode", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }


    // METODE ZA CUVANJE PODATAKA

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // na pocetku promene
        outState.putInt("brojac", brojac);
        // kljuc nema veze sa nazivom promenjive on je kao par preko koga znam koja vrednost se pamti i vraca on je veza



    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // ova metoda za vracanje vrednosti ili on create metoda obe rade istu stvar
        if (savedInstanceState != null){
            brojac = savedInstanceState.getInt("brojac");  // ok je provereno
        }
    }

    public int brojac = 1;
    public void click(View view){ // view mora kao parametar
        // brojac prosledjujemo toastu pa ce ga odma i uvecavati preko toga
        Toast.makeText(this, "Klik Na Dugme" +brojac++, Toast.LENGTH_SHORT).show();
        // ne zaboravi da dodas ++ da bi se uvecavala vrednost
    }



    // u emulatoru moras klinuti automatsku promenu u landscape i obrnuto da bi on brisao vrednosti kao normalan uredjaj


    public void secondActivity(View view){   // ? sto je ovo odvojeno od metode
        // ovo samo pokrece novi prozor ali neradi nista // za kontakte je posebni prozor nije ovaj
        Intent i = new Intent(this, SecondActivity.class); // ovo je implicitni intent kada kazem direktno sta hocu
        startActivity(i); // start dugme za drugi prozor
    }


    // greska kod kontakata je bila u api verziji api verzija 30 ne radi sa ovim kodom kako treba
    static final int REQUEST_SELECT_CONTACT = 0; // ovo je kljuc za nameru
    // ovo je sifra za intent pa se mora slati request koda za svaku metodu nase applikacije koju hocemo da uradimo

    public void izaberiKontact(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            // Do something with the selected contact at contactUri
            Toast.makeText(this, ""+ contactUri, Toast.LENGTH_SHORT).show();
        }

    }
}