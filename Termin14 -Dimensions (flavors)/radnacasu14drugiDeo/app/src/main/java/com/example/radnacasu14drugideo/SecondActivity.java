package com.example.radnacasu14drugideo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // koji se tip settuje mora i da se gettuje isti tip
        int id = getIntent().getIntExtra("id", -1); // -1 je najbolje resenje jer ce doci do exceptiona

        Fruit fruit = null;
        for(Fruit f:Fruit.fruits){
            if (f.getId()==id){
                fruit = f;
            }
        }
        TextView tw_name =  findViewById(R.id.textView_name);
        tw_name.setText(fruit.getName());
        TextView tw_description = findViewById(R.id.textView_description);
        tw_description.setText(fruit.getDescription()); // ovo mora da se setuje

        // slika mora da se ucita kao string
        // slika mora iz stream u drawable objekat

        // input stream za sliku ili  ulazni izlazni saobracaj
        try {
            InputStream is = getAssets().open(fruit.getImageFileName()); // ulazni tok podataka
            Drawable drawable = Drawable.createFromStream(is,"");
            ImageView slika = findViewById(R.id.imageView); // image view na koji treba da se gurne slika
            slika.setImageDrawable(drawable); // ovo ga postavlja

        } catch (IOException e) {
            Toast.makeText(this, "ne postoji izabran fajl", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        RatingBar rb = findViewById(R.id.ratingBar);
        rb.setRating(fruit.getRating());
        rb.setIsIndicator(true); // ako sluzi samo kao indikator a ne ulazni podatak ne moze mu se menjati vrednost


    }




}