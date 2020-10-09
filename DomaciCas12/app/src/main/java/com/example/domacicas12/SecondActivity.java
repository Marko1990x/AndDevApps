package com.example.domacicas12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.MediaStore;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void trecaAktivnost(View view){

        Intent i = new Intent(this, ThirdActivity.class); // ovo pokrece prozor
        startActivity(i);

    }

    // pogledaj na sajtu kod ubaci u manifest u odgovarajucu klasu
    // ne zaboravi View View da bi mogao da pristupis metodi

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final Uri locationForPhotos = null;
    public void capturePhoto(View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void createAlarm(String message, int hour, int minutes) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void Alarm (View view){   // poziv metode create alarm
        String s = "Alarm Postavljen";
        int hour = 19;
        int minutes = 33;
        createAlarm(s,hour,minutes);
    }


}