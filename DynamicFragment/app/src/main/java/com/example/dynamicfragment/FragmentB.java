package com.example.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 16/11/17.
 */

public class FragmentB extends Fragment {

    private TextView txvMessage;
    private String message;
    private int size;

    /**
     *  PATRÓN FACTORY, QUE ES UNA SIMPLIFICACION DEL PATRÓN BUILDER/CREATOR
     * @param bnd
     * @return
     */
    public static Fragment newInstance(Bundle bnd) {
        FragmentB fragmentB = new FragmentB();
        if(bnd!=null)
        {
            fragmentB.setArguments(bnd);
        }
        return fragmentB;

    }

    /**
     * Atención: para que le estado dinámico de un fragment sea permanetne ante un cambio de
     * confiugración usar setRetainInstance();
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        setRetainInstance(true);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(this.getClass().getName(),"Fragment: onCreateView()");
        View view = inflater.inflate(R.layout.fragment_b,container,false);
        txvMessage=view.findViewById(R.id.txvMessage);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(this.getClass().getName(),"Fragment: onViewCreated()");
            Bundle bundle=getArguments();
            if(savedInstanceState==null) //No hay cambio de configuracion, se ejecuta por primera vez
            {
                if (bundle != null) { //Si hay parámetro se asigna
                    message = bundle.getString("message");
                    size = bundle.getInt("size");
                }
            }
            changeTextAndSize(message,size);
    }

    public void changeTextAndSize(String message, int size)
    {
        txvMessage.setText(message);
        txvMessage.setTextSize(size);
    }
/*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            txvMessage.setText(savedInstanceState.getString("message"));
            txvMessage.setTextSize(savedInstanceState.getFloat("size"));
        }
    }
    */
    /*
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("message",txvMessage.getText().toString());
        outState.putFloat("size",  txvMessage.getTextSize()/getResources().getDisplayMetrics().scaledDensity);
    }
*/



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(this.getClass().getName(), "OnAttach");
        if(isAdded()){
            Log.d(this.getClass().getName(), "isAdded()");
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(this.getClass().getName(), "OnStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        if(isAdded()){
            Log.d(this.getClass().getName(), "isAdded()");
        }
        Log.d(this.getClass().getName(), "OnResume");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.getClass().getName(), "OnDestroy");
    }


}
