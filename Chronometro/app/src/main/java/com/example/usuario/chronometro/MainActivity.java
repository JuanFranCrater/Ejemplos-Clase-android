package com.example.usuario.chronometro;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    private ReverseChronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer= findViewById(R.id.chrono);
        chronometer.setOverallDuration(15);
        chronometer.setWarningDuration(5);
    }

    @Override
    protected void onResume() {
        super.onResume();
        chronometer.run();
    }

    @Override
    protected void onPause() {
        super.onPause();
       chronometer.stop();

    }
}
