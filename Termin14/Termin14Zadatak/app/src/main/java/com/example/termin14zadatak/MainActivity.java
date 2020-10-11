package com.example.termin14zadatak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // u okviru on create metode
        for(final Vocke x: Vocke.vocke){  // da pravi dugmad na osnovu niza
            Button button = new Button(this);
            button.setText(x.getName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override  // mora da ide main activity.this zato sto je uvucen listener pa moram da kazem klasa this a ne metoda this
                public void onClick(View v) {  // za svako dugme da otvara novi prozor preko listenera je vezan sa metodom
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("id", x.getId());
                        startActivity(intent);


                }
            });

            LinearLayout linearLayout = findViewById(R.id.linear1); // id od xml-a
            linearLayout.addView(button); // dugme koje je pravljeno
        }
    }

    /*public void bwutton(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);

    }*/
}