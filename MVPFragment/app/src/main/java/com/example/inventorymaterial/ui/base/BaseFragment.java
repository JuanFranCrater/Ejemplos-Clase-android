package com.example.inventorymaterial.ui.base;

import android.app.Fragment;
import android.support.design.widget.Snackbar;

/**
 * Created by usuario on 24/11/17.
 */

public class BaseFragment extends Fragment {
    public void showMessage(String message)
    {
        onError(message);
    }
    public void onError(String message)
    {
        Snackbar.make(getActivity().findViewById(android.R.id.content),message,Snackbar.LENGTH_SHORT).show();
    }

    public void onError(int resId)
    {
        Snackbar.make(getActivity().findViewById(android.R.id.content),getResources().getString(resId),Snackbar.LENGTH_SHORT).show();
    }
}
