package com.example.radnacasu14drugideo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MwainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mwain);

// dinamicko  kreiranje elemenata na osnovu koliko ih ima u bazi podataka
        for(final Fruit fruit: Fruit.fruits){  // sa final mora da se sacuva je ce referenca biti brisana drugacije posle izvrsenja for petlje
            Button button = new Button(this); // ko instancira objekat
            button.setText(fruit.getName());
            button.setOnClickListener(new View.OnClickListener() {   // listener
                @Override
                public void onClick(View v) {

                  //  Toast.makeText(MwainActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                    // mora klasa.this jer bi samo this bio onclicklistener pogledaj malo this gde moze da se koristi

                    Intent intent = new Intent(MwainActivity.this, SecondActivity.class); // ovo mora sa mwain.this zato sto je unutar metode
                    intent.putExtra("id", fruit.getId());
                    startActivity(intent);
                }
            });
            LinearLayout ll = findViewById(R.id.linearlayout); // nadjeno dugme
            ll.addView(button); // ako se stavi index onda ce doci na odgovarajuce mesto na osnovu indexa moze se mesati layout.xml i java kod za generisanje dugmadi
        }

    }

}
