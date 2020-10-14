package github.io.radnacasu17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showList();


    }

    private void showList() {

        // get fragment support manager se koristi za AppCompatActivity
        // za aktivity se koristi getFragmentManager ali se mora zamenti i import u master fragmentu ne androidx fragment nego stara varianta
        MasterFragment masterFragment = new MasterFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFrame, masterFragment)
                .addToBackStack(null)
                .commit();


    }

}