package com.example.autocompletetextviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar = (ProgressBar)findViewById(R.id.progressBarId);
        Thread thread  = new Thread(new Runnable() {
            @Override
            public void run() {
                doLoadeing();
                gotoApp();
            }
        });
        thread.start();



    }

    public void doLoadeing(){
        for (progresses=0; progresses<=100;progresses=progresses+1){
            try {
                Thread.sleep(40);
                progressBar.setProgress(progresses);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void gotoApp(){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();
    }


}