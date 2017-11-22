package com.example.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity  implements FragmentA.FragmentAListener{

    private Fragment fragmentA;
    private Fragment fragmentB;
    private static String TAG="Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getFragmentManager();
        fragmentA = fragmentManager.findFragmentByTag("fragmentA");

        if(fragmentA==null){
        fragmentA= new FragmentA();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(android.R.id.content, fragmentA, "fragmentA");
        fragmentTransaction.commit();
        }
        Log.d(TAG,"Activity: onCreate()");
    }

    @Override
    public void onFragmentAEvent(String message, int size) {

       // fragmentB = new FragmentB();
        Bundle bnd = new Bundle();
        bnd.putString("message",message);
        bnd.putInt("size",size);
        //Con el método setArgument se pasa la informacon que necesita el fragment
        //fragmentB.setArguments(bnd);
        //Se debe utilizar el patrón factoria donde la creación del objeto y el paso
        //de argumneto se ejecute consecutivamente
        fragmentB=FragmentB.newInstance(bnd);
        //A continuación, se empieza la transacción de FragmentA a FragmentB
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(android.R.id.content,fragmentB);
        //Antes del commit se debe guardar la transaccion
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Activity: onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Activity: onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Activity: onStop()");
    }
}
