package com.example.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity  implements FragmentA.FragmentAListener{

    private Fragment fragmentA;
    private Fragment fragmentB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentA = fragmentManager.findFragmentByTag("fragmentA");
        if(fragmentA==null)
        fragmentA= new FragmentA();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragmentA, "fragmentA");
        fragmentTransaction.commit();
    }


    @Override
    public void onFragmentAEvent(String message, int size) {
        fragmentB = new FragmentB();
        Bundle bnd = new Bundle();
        bnd.putString("message",message);
        bnd.putInt("size",size);
        //Con el método setArgument se pasa la informacon que necesita el fragment
        fragmentB.setArguments(bnd);
        //A continuación, se empieza la transacción de FragmentA a FragmentB
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content,fragmentB);
        fragmentTransaction.commit();
    }
}
