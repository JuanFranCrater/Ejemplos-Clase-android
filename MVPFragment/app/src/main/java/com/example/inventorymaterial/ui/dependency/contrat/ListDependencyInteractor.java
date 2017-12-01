package com.example.inventorymaterial.ui.dependency.contrat;

import com.example.inventorymaterial.data.db.model.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {
    void loadDependency();
    void deleteDependency(Dependency dependency);
    interface OnLoadFinishedListener
    {
        void onSuccess(List<Dependency> list);
    }
}
