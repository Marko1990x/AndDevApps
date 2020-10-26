package github.io.radnacasu22;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //my app u manifestu je potrebno da moja applikacija zna sta je vrapper za nju

    private EditText etText;
    private Button bStart;
    private Button bStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etText = findViewById(R.id.et_text1);
        bStart = findViewById(R.id.bStart);
        bStop = findViewById(R.id.bStop);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMyService();
            }
        });

        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMyService();
            }
        });



    }

    private void startMyService(){

        String msg = etText.getText().toString();
        Intent intent = new Intent(this, MySevice.class);
        intent.putExtra(MySevice.MSG_TAG, msg);

        ContextCompat.startForegroundService(this, intent);
    }

    private void stopMyService(){
        Intent intent = new Intent(this, MySevice.class);
        stopService(intent);

    }





}