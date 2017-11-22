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
            if(bundle!=null)
            changeTextAndSize(bundle.getString("message"),bundle.getInt("size"));
    }

    public void changeTextAndSize(String message, int size)
    {
        txvMessage.setText(message);
        txvMessage.setTextSize(size);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("message",txvMessage.getText().toString());
        outState.putFloat("size",  txvMessage.getTextSize()/getResources().getDisplayMetrics().scaledDensity);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState!=null) {
            txvMessage.setText(savedInstanceState.getString("message"));
            txvMessage.setTextSize(savedInstanceState.getFloat("size"));
        }
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(this.getClass().getName(), "OnAttach");
        if(isAdded()){
            Log.d(this.getClass().getName(), "isAdded()");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        Log.d(this.getClass().getName(), "OnCreate");
        super.onCreate(savedInstanceState);
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
}
