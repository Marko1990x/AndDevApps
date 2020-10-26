package github.io.radnacasu22;

import androidx.appcompat.app.AppCompatActivity;

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



    }

    private void stopMyService(){

    }





}