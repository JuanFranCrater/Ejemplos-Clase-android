package com.example.staticfragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by usuario on 16/11/17.
 */

public class FragmentC extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c,container,false);
        Log.d(this.getClass().getName(), "onCreateView");
        return view;
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
}
