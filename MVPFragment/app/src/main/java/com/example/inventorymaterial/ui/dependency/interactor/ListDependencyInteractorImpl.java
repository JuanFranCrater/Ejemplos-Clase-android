package com.example.inventorymaterial.ui.dependency.interactor;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyInteractor;
import com.example.inventorymaterial.ui.login.LoginInteractor;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor{
    private ListDependencyInteractor.OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(ListDependencyInteractor.OnLoadFinishedListener listener) {
        this.listener=listener;
    }

    @Override
    public void loadDependency() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependency(dependency);
    }

}
