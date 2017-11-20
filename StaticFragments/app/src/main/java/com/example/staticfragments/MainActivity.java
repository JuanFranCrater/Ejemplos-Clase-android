package com.example.staticfragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements FragmentA.FragmentAListener{

    private Fragment fragmentb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentb=getFragmentManager().findFragmentById(R.id.fragmentB);


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
