package com.example.inventorymaterial.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditContrat;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditContrat.View {
    public static final String TAG="addeditdependency";
    public static AddEditDependency newInstance(Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if(arguments!=null)
        {
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add_edit_dependency,container,false);
        if(getArguments()!=null)//es editar
        {

        }
        return rootView;
    }
}
