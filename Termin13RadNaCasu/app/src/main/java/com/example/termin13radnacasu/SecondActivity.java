package com.example.termin13radnacasu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 578){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String url = getIntent().getStringExtra("url");

        WebView wv = findViewById(R.id.webview);  // referenca
        wv.loadUrl(url);

        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (result == PackageManager.PERMISSION_GRANTED){
            // uputili nameru kameri
            Toast.makeText(this, "Imam Dozvolu za kameru", Toast.LENGTH_SHORT).show();
        }else{
            // ako je nema onda treba je zatraziti
          /*  ActivityCompat.requestPermissions(this, new String[]{
               Manifest.permission.CAMERA;
            },578);*/

          ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 578);



        }
    }


}