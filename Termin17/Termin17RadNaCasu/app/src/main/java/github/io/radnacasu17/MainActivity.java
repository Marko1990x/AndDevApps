package github.io.radnacasu17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MasterFragment.onNameClickListener {

    private boolean landscape = false;
    private DetailsFragment detailsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        showList();
        if(findViewById(R.id.flDetail) != null){
            landscape = true;
            detailsFragment = new DetailsFragment();
            detailsFragment.setId(0);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flDetail, detailsFragment) // backstack pravi problem ovde
                    .commit();
        }




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

    private void showName(int id){

        if (landscape){
            detailsFragment.udpateId(id);
        } else{
            DetailsFragment fragment = new DetailsFragment();
            //fragment.setId(id);
            fragment.setId(id);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFrame, fragment)
                    .addToBackStack(null)
                    .commit();
        }


    }



    @Override
    public void onNameClicked(int id) {
        showName(id);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}