package com.example.felipe.datetimetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t = new Thread(){
            @Override
            public void run(){
                try {
                    while(!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView tdate = findViewById(R.id.date);
                                TextView ttime = findViewById(R.id.time);
                                long date = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("hh-mm-ss a");
                                String dateString = sdf.format(date);
                                SimpleDateFormat sdft = new SimpleDateFormat("MMM dd yyyy");
                                String dateString2 = sdft.format(date);
                                tdate.setText(dateString);

                                ttime.setText(dateString2);
                            }
                        });
                    }
                }catch (InterruptedException e){

                }

            }
        };
        t.start();
    }
}
