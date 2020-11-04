package firebaseapp.com.termin23;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //aktivnost ima activity.this
    //fragmenti koriste context get context
    //servisi se mogu pristupiti samo preko activity context
    // namena servisa je da nema korisnicki interface // nemoze da se prikazuje

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



}