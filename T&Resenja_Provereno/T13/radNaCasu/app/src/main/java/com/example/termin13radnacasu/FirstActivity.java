package com.example.termin13radnacasu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }
// visibility je na primer basic advanced view koji mogu da sakrivam od korisnika . kao prozori.
    // gradle moze da pravi i verzije applikacije

    // R klasa je veza izmedju koda i resursa pa se mora koristiti R.neki resusrs
    // monkey za xml je r za java kod

    // kod prevoda ako nema vrednost onda ce se koristiti default vrednost

    // prevodi nemogu da se menjaju u samoj applikaciji vec samo preko podesavanja u samom uredjaju


    // boje mogu da se biraju posebno ili za prevode ili genericno za sve

    // pogledaj ikonice koje mozes da stavis na dugmad
    // layout gravity za centriranje

    // ikonica ce biti u meniju gde su i ostale izlistane
    // pogledaj permisije za kontakt


    // ako odem u other u layout xml mogu praviti custom layoute koji ce se pokazivati pod odredjenim uslovima

    public void onClick(View view){
        // moras importovati klasu onda moras proslediti preko R klase ovoj metodi
        TextView tv = findViewById(R.id.txt1);
        tv.setText("ovo je izmenjen text");
        tv.setTextColor(getResources().getColor(R.color.colorPrimaryDark, null));
        tv.setTypeface(null, Typeface.BOLD_ITALIC);
        tv.setBackgroundResource(R.color.tamno_plava);


        Intent i = new Intent(this, SecondActivity.class);
        String url = "https://www.google.com";
        i.putExtra("url", url);
        startActivity(i);

    }






}