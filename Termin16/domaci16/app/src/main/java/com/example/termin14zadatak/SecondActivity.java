package com.example.termin14zadatak;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int id = -1;
        try {
            id = getIntent().getIntExtra("id", -1);  // ovo je mozda brojac sam u sebi
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }
        Vocke vocke = null;
        for (Vocke v1 : Vocke.vocke) {
            if (v1.getId() == id) {
                vocke = v1;
            }
        }

        // punjenje dugmad

        TextView textView = findViewById(R.id.txt1);
        textView.setText(vocke.getName());
        TextView textView1 = findViewById(R.id.txt2);
        textView1.setText(vocke.getOpis());


        //slika

        try {

            InputStream is = getAssets().open(vocke.getImagefilename()); // trazi sliku po kljucu koji mora da se podudara sa imenom same slike i extenzije
            Drawable drawable = Drawable.createFromStream(is, ""); // drugi parametar je prazan nisam siguran sta je
            ImageView imageView = findViewById(R.id.slika);
            imageView.setImageDrawable(drawable);


        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show();
        }

        RatingBar rb = findViewById(R.id.rbr);
        rb.setRating(vocke.getRating());
        rb.setIsIndicator(true); // zabrana menjanja vrednosti


    }

}