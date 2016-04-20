package com.headfirst.stopwatch;

import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Activity;
import android.util.EventLog;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.support.v7.app.*;
import java.util.logging.LogRecord;


public class StopwatchActivity extends Activity{

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    //edit via github;
    //edit via github for fect test
    //small change nklj
    //adding "bug fix"

    //change 1

    //change 2

    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_stopwatch);
        if(savedInstance != null){
            seconds = savedInstance.getInt("sec");
            running = savedInstance.getBoolean("running");
            wasRunning = savedInstance.getBoolean("wasRunning");

        }
        runTimer();
    }

    protected void onPause() {
        super.onPause();
        running = false;

    }

   /* protected void onStop(){
        super.onStop();
        running = false;

    }*/

    /*protected void onStart(){
        super.onStart();
        if(wasRunning){
            running = true;
        }
    }*/

    protected void onResume(){
        super.onResume();
        if(wasRunning){
            running = true;
        }
    }
    public void onClickStart(View view)
    {
        running = true;
        wasRunning = true;
    }

    public void onClickStop(View view){
        running = false;
        wasRunning = false;
    }

    public void onClickReset(View view){
        running = false;
        seconds = 0;
        wasRunning = false;
    }

    public void runTimer()
    {
        final TextView textview = (TextView)findViewById(R.id.textView);

       final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hrs = seconds / 3600;
                int mins = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%d:%02d:%02d", hrs, mins, secs);

                textview.setText(time);

                if (running) {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

     @Override public void onSaveInstanceState(Bundle savedInstance){
         savedInstance.putInt("sec",seconds);
         savedInstance.putBoolean("running",running);
         savedInstance.putBoolean("wasRunning", wasRunning);
     }

    
}
