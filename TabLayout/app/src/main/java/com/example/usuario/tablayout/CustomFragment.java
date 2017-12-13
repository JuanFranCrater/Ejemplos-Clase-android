package com.example.usuario.tablayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 13/12/17.
 */

public class CustomFragment extends Fragment {
    private TextView textView;
    public static String KEY_MESSAGE;
    public static CustomFragment newInstance(Bundle bnd)
    {
        CustomFragment customFragment = new CustomFragment();
        if(bnd != null)
            customFragment.setArguments(bnd);
        return customFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main, container,false);
        textView=rootView.findViewById(R.id.textview);
        String textMessage = getArguments().getString(KEY_MESSAGE);
        textView.setText(textMessage);
        return rootView;
    }
}
