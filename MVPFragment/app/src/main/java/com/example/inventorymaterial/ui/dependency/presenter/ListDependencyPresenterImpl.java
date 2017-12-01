package com.example.inventorymaterial.ui.dependency.presenter;

import android.content.Context;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyContrat;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyInteractor;
import com.example.inventorymaterial.ui.dependency.interactor.ListDependencyInteractorImpl;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenterImpl implements ListDependencyContrat.Presenter, ListDependencyInteractor.OnLoadFinishedListener{
    ListDependencyContrat.View view;
    ListDependencyInteractorImpl listDependencyInteractor;
    public ListDependencyPresenterImpl(ListDependencyContrat.View view) {
        this.view=view;
        this.listDependencyInteractor = new ListDependencyInteractorImpl(this);
    }

    @Override
    public void loadDependency() {
        listDependencyInteractor.loadDependency();
    }

    @Override
    public void delete(Object dependency) {
        listDependencyInteractor.deleteDependency((Dependency) dependency);
        loadDependency();
        view.showDeleteDependency();
    }

    /**
     * Este método es llamado por el interactor cuando los datos/listado de dependencias esté listo. Se avisa a la vista
     * @param list
     */
    @Override
    public void onSuccess(List<Dependency> list) {
        view.showDependency(list);
    }


    @Override
    public void onDestroy() {
        view=null;
        listDependencyInteractor=null;
    }


}
