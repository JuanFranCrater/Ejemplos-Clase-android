package com.example.inventorymaterial.ui.dependency.presenter;

import com.example.inventorymaterial.ui.dependency.contrat.ListDependencyContrat;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenterImpl implements ListDependencyContrat.Presenter{
    ListDependencyContrat.View view;

    public ListDependencyPresenterImpl(ListDependencyContrat.View view) {
        this.view=view;
    }

}
