package firebaseapp.com.aad10.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import firebaseapp.com.aad10.R;
import firebaseapp.com.aad10.activity.MwainActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        // kotlin
        // supportActionBar?.hide()
        //java
        if (getSupportActionBar()!= null){
            getSupportActionBar().hide();
        }


        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent();
            }
        },3000);


    }


    private void intent(){
        Intent intent = new Intent(this, MwainActivity.class);
        startActivity(intent);
    }
}