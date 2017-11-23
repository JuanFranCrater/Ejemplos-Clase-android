package com.example.inventorymaterial.ui.dependency;

import android.app.Activity;
import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.adapter.DependencyAdapter;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyContrat;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements ListDependencyContrat.View {

    public static final String TAG="listdependency";
    private ListDependencyListener callback;
    private ListDependencyContrat.Presenter presenter;

    interface ListDependencyListener{
        void addNewDependency();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            callback=(ListDependencyListener)activity;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(activity.toString()+" must implements ListDependencyListener");
        }
    }

    public static Fragment newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments!=null)
        {
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_list_dependency,container,false);
        //Como se encuentra en el fragment, usamos rootView
        FloatingActionButton fab = (FloatingActionButton)rootView.findViewById(R.id.fab);
        //Si el floatingActionButton se encontrara en el xml de la activity
        //FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              callback.addNewDependency();
            }
        });
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }

    @Override
    public void setPresenter(ListDependencyContrat.Presenter presenter) {
        this.presenter=presenter;
    }
}
