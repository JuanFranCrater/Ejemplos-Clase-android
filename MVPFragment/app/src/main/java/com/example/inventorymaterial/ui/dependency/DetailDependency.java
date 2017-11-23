package com.example.inventorymaterial.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependency extends Fragment {

    public static final String TAG="detaildependency";


    public static Fragment newInstance(Bundle arguments) {
        DetailDependency detailDependency = new DetailDependency();
        if(arguments!=null)
        {
            detailDependency.setArguments(arguments);
        }
        return detailDependency;
    }

}
