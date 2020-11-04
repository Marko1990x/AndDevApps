package firebaseapp.com.domaci20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import Provajder.Glumac_Provajder;

public class MainActivity extends AppCompatActivity {

    final List<String> imenaGlumaca = Glumac_Provajder.getGlumciNames();
    ListView listaGlumaca;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.firstElement) {
                    Toast.makeText(MainActivity.this, "First Element", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("kljuc", 0);
                    startActivity(intent);
                }
                if (id == R.id.secondElement) {
                    Toast.makeText(MainActivity.this, "Second Element", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("kljuc", 1);
                    startActivity(intent);
                }
                if (id == R.id.thirdElement) {
                    Toast.makeText(MainActivity.this, "Third Element", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("kljuc", 2);
                    startActivity(intent);
                }
                if (id == R.id.fourthElement) {
                    Toast.makeText(MainActivity.this, "Third Element", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("kljuc", 3);
                    startActivity(intent);
                }
                if (id == R.id.fifthElement) {
                    Toast.makeText(MainActivity.this, "Third Element", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("kljuc", 4);
                    startActivity(intent);
                }


                return true;
            }
        });


        //getSupportActionBar().hide();
       // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        listaGlumaca = findViewById(R.id.lst_Glumci);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, imenaGlumaca);
        listaGlumaca.setAdapter(arrayAdapter);
        listaGlumaca.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "glumac sa id " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("kljuc", position);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}