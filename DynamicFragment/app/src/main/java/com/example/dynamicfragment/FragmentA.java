package com.example.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

/**
 * Created by usuario on 16/11/17.
 */

public class FragmentA extends Fragment {

    private EditText edtMessage;
    private Button btnSize;
    private SeekBar skbSize;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(this.getClass().getName(),"Fragment: onCreateView()");
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        edtMessage=view.findViewById(R.id.edtMessage);
        btnSize=view.findViewById(R.id.btnSize);
        skbSize=view.findViewById(R.id.skbSize);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(this.getClass().getName(),"Fragment: onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
        btnSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.onFragmentAEvent(edtMessage.getText().toString(),skbSize.getProgress());
            }
        });
    }

    private FragmentAListener mCallBack;

    /**Se define la interfaz que servirá de contrato entre el Fragment y la activity **/
    public interface FragmentAListener{
        void onFragmentAEvent(String message, int size);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(this.getClass().getName(), "OnAttach");
        try {
            mCallBack=(FragmentAListener)activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString() +" must implement FragmentAListener");
        }
        if(isAdded()){
            Log.d(this.getClass().getName(), "isAdded()");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallBack=null;
        Log.d(this.getClass().getName(), "OnDetach");
    }

    /**
     * Este metodo solo funciona en la API 23 en adelante, si se ejecuta en una api inferior, no falla pero tampoco FUNCIONA LA COMUNICACION
     */
    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }*/


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
}
