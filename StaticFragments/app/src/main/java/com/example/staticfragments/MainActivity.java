package com.example.staticfragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener{

    private Fragment fragmentb,fragmentc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentb=getSupportFragmentManager().findFragmentById(R.id.fragmentB);

        fragmentc=getSupportFragmentManager().findFragmentById(R.id.fragmentC);
    }

    @Override
    public void onFragmentAEvent(String message, int size) {
        ((FragmentB)fragmentb).changeTextAndSize(message,size);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("hola","Me reinicio");
    }
}
