package com.example.inventorymaterial.ui.dependency.presenter;

import com.example.inventorymaterial.ui.dependency.AddEditDependency;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditContrat;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenterImpl  implements AddEditContrat.Presenter{
    private final AddEditContrat.View view;

    public AddEditDependencyPresenterImpl(AddEditContrat.View view)
    {
        this.view =view;
    }
}
