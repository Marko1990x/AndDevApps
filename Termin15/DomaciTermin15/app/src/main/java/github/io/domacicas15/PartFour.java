package github.io.domacicas15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class PartFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_four);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Pozdrav iz Part Four", Toast.LENGTH_SHORT).show();
    }
}