package com.example.inventorymaterial.ui.dependency;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.ui.base.BaseActivity;
import com.example.inventorymaterial.ui.dependency.presenter.AddEditDependencyPresenterImpl;
import com.example.inventorymaterial.ui.dependency.presenter.ListDependencyPresenterImpl;

/**
 * Created by usuario on 25/10/17.
 */

public class DependecyActivity extends BaseActivity implements ListDependency.ListDependencyListener{

    private ListDependency listDependency;
    private ListDependencyPresenterImpl listPresenter;
    private AddEditDependency addeditDependency;
    private AddEditDependencyPresenterImpl addEditPresenter;
    private DetailDependency detailDependency;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fraMag = getFragmentManager();
        FragmentTransaction fraTra = fraMag.beginTransaction();
        //1. Se crea la vista
        listDependency=(ListDependency) fraMag.findFragmentByTag(ListDependency.TAG);
        if(listDependency==null)
        {
            listDependency=(ListDependency) ListDependency.newInstance(null);
            fraTra.add(android.R.id.content,listDependency,ListDependency.TAG);
            fraTra.commit();

        }
        //2. Se crea el presentador, y se le pasa en el constructor la vista correspondiente/su fragment
        listPresenter = new ListDependencyPresenterImpl(listDependency);

        //3.Si necesitamos, se asigna el presentador a su fragment
        listDependency.setPresenter(listPresenter);

    }

    @Override
    public void addNewDependency() {
        FragmentManager fraMag = getFragmentManager();
        FragmentTransaction fraTra = fraMag.beginTransaction();
        addeditDependency = (AddEditDependency)fraMag.findFragmentByTag(AddEditDependency.TAG);
        if(addeditDependency==null)
        {
            addeditDependency= AddEditDependency.newInstance(null);
            fraTra.replace(android.R.id.content,addeditDependency,AddEditDependency.TAG);
            fraTra.addToBackStack(null);
            fraTra.commit();
        }

    }
}
