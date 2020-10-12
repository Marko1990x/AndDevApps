package github.io.domacicas15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.button);
        Button b2 = findViewById(R.id.button2);
        Button b3 = findViewById(R.id.button3);
        Button b4 = findViewById(R.id.button4);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstActivity(v);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondActivity(v);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdActivity(v);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fourthActivity(v);
            }
        });
    }

    public void firstActivity(View view){
        Intent intent = new Intent(this, GridBox.class);
        startActivity(intent);
    }

    public void secondActivity(View view){
        Intent intent = new Intent(this, PartTwo.class);
        startActivity(intent);
    }

    public void thirdActivity(View view){
        Intent intent = new Intent(this, PartThree.class);
        startActivity(intent);

    }

    public void fourthActivity(View view){

        Intent intent = new Intent(this, PartFour.class);
        startActivity(intent);

    }

}