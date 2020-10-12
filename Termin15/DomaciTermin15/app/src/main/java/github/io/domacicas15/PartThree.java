package github.io.domacicas15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class PartThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_three);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Pozdrav iz Part Three", Toast.LENGTH_SHORT).show();
    }
}