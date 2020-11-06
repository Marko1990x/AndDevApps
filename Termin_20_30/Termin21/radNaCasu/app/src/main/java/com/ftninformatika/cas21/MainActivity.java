package com.ftninformatika.cas21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;
    private Switch swSmer;
    private boolean smer = true;
    private Button bStart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText = findViewById(R.id.tvText);
        swSmer = findViewById(R.id.swSmer);
        bStart = findViewById(R.id.bStart);

        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  startThread();
                startAsyncTask();
            }
        });
        // na osnovu bollean dobija prvu ili drugu vrednost
        swSmer.setText(smer ? "Pozitivan" : "Negativan");
        swSmer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                smer = !smer;
                swSmer.setText(smer ? "Pozitivan" : "Negativan");
            }
        });



    }

    /*private void startThread(){
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start(); // mora se odma i startovati ako nemamo reference
    }*/

    private void startAsyncTask(){
        MojAsynthTask mojAsynthTask = new MojAsynthTask();
        mojAsynthTask.execute(10);
    }

    private void startThread(){
        bStart.setEnabled(false);
        Thread mojThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int sek = 10;
                while(sek > 0){
                    sek = smer ? sek+1: sek-1; // uvecava ili smanjuje promenjivu u odnosu na smer
                  //  tvText.setText(sek +""); ne sme se iz pozadinske niti dirati korisnicki interface
                    updateTextViewAsync(sek +"");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                updateTextViewAsync("BOOM!!!");
                bStart.post(new Runnable() {
                    @Override
                    public void run() {
                        bStart.setEnabled(true);
                    }
                });
            }
        });
        mojThread.start();
    }



    private void updateTextViewAsync(final String text){
        tvText.post(new Runnable() {
            @Override
            public void run() {
                tvText.setText(text);
            }
        });
    }



    private class MojAsynthTask extends AsyncTask<Integer, Integer, Void>{

        @Override
        protected void onPreExecute() {
            bStart.setEnabled(false);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            bStart.setEnabled(true);
            updateTextViewAsync("BOOM!!!");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            tvText.setText(values[0]+ "");
        }

        @Override
        protected Void doInBackground(Integer... integers) {

            int sek = integers[0];
            do{

                sek = smer ? sek+1:sek-1;
                publishProgress(sek);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }while(sek > 0);

            return null;
        }
    }










}