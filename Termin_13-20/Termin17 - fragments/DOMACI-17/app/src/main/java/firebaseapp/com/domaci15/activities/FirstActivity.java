package firebaseapp.com.domaci15.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.List;

import firebaseapp.com.domaci15.Model.NavItem;
import firebaseapp.com.domaci15.Provider.JeloProvider;
import firebaseapp.com.domaci15.R;
import firebaseapp.com.domaci15.adapters.DrawerAdapter;
import firebaseapp.com.domaci15.dialogs.AboutDialog;
import firebaseapp.com.domaci15.fragments.DetailsFragment;
import firebaseapp.com.domaci15.fragments.MasterFragment;


public class FirstActivity extends AppCompatActivity implements MasterFragment.OnItemSelectedListener {

    // model pravi objekat (kostur)
    // provider puni podatke (kostur)
    // adapter povezuje podatke sa xml-fajlom
    // ovaj domaci nema adapter podaci su povezani preko providera sto su samo metode koje instanciraju objekte
    // ima jedan adapter za spinner
    //Loads fruits from array resource

    // fragment implements 2 new methods
    final List<String> jeloNames = JeloProvider.getJeloNames();
    ListView listaJela;

    // attributes used by drawer navDrawer
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private RelativeLayout drawerPane;
    private CharSequence drawerTitle;
    private ArrayList<NavItem> drawerItems = new ArrayList<>();

    // attributes used by diealog
    private AlertDialog dialog;

    // attributes representing the activity's state
    private boolean landScapeMode = false;
    private boolean masterShown = false;
    private boolean detailShown = false;

    private int itemId = 0; // selected item id


    private class DrawerItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (position == 0) {
                // first activity is already shown
            } else if (position == 1) {
                Intent intent = new Intent(FirstActivity.this, SettingsActivity.class);
                startActivity(intent);
            } else if (position == 2) {
                if (dialog == null) {
                    // klasa dialog
                    dialog = new AboutDialog(FirstActivity.this).prepareDialog();
                } else {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
                dialog.show();
            }

            drawerList.setItemChecked(position, true);
            setTitle(drawerItems.get(position).getTitle());
            drawerLayout.closeDrawer(drawerPane);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);

        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            // drawable icon
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer_foreground);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }


        // adds a few navBar items to drawer
        drawerItems.add(new NavItem("Home", "Show All Food", R.drawable.ic_action_product_foreground));
        drawerItems.add(new NavItem("Setting", "Change App Settings", R.drawable.ic_action_settings_foreground));
        drawerItems.add(new NavItem("About", "About Us", R.drawable.ic_action_about_foreground));

        drawerTitle = getTitle();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.navList);

        // populates navBar with options
        drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);
        //todo pogledaj ovo xd
        drawerLayout.setDrawerShadow(R.drawable.ic_baseline_rounded_corner_24, GravityCompat.START);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerList.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(
                // use externalized strings
                this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close
        ) {

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu(); // creates call to on prepareOptionsMenu
            }
        };

        //region this code creates and transmits the fragments
        // manages fragment
        // If the activity is started for the first time create master fragment
        if (savedInstanceState == null) {
            // use the old class
            // FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            // objekat za prenos fragmenta
            MasterFragment masterFragment = new MasterFragment();
            // instanca objekta klase fragment master
            fragmentTransaction.add(R.id.master_view, masterFragment, "Master_Fragment_1");
            // lepljenje fragmenta na xml view preko id-a
            fragmentTransaction.commit();

        }


        if (findViewById(R.id.detail_view) != null) {
            landScapeMode = true;
            getFragmentManager().popBackStack();

            // ovde mora cast
            // ovo je kada su oba fragmenta jedan pored drugog
            DetailsFragment detailsFragment = (DetailsFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            if (detailsFragment == null) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                detailsFragment = new DetailsFragment();
                fragmentTransaction.replace(R.id.detail_view, detailsFragment, "Details_fragment_1");
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
                detailShown = true;
            }

            masterShown = true;
            detailShown = true;
            itemId = 0;


        }

        //endregion this is the end of the region
        //onitemselected method handles selection of items in the master fragment fragments
        //region old code for activity
        // old activity code
        // Toast.makeText(this, "Hey pokrenuto je"+JeloProvider.getJeloNames(), Toast.LENGTH_SHORT).show();

       /* ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,jeloNames);
        listaJela = findViewById(R.id.lstJela); // mora posle adaptera da ide ovo nemoze gore
        listaJela.setAdapter(arrayAdapter);
        listaJela.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("kljuc",position);
                Toast.makeText(FirstActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });*/
        //endregion end of old code for activity

    }

    //region imlements onItemSelected listener for fragments
    // ispod on create
    @Override
    public void onItemSelected(int position) {

        itemId = position;

        if (landScapeMode){

            DetailsFragment df = (DetailsFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            // ovo je metoda iz details fragmenta to jest mora se prvo definisati u klasi dont be stupid.
            //df.updateContent(position);

        }else{

        }

    }

    //endregion end of listener


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}