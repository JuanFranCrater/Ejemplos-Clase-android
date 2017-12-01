package com.example.inventorymaterial.ui.dependency.presenter;

import com.example.inventorymaterial.ui.dependency.contrat.AddEditContrat;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditInteractor;
import com.example.inventorymaterial.ui.dependency.interactor.AddEditDependencyInteractorImpl;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenterImpl  implements AddEditContrat.Presenter, AddEditInteractor.OnAddDependecyListener{
    private AddEditContrat.View view;
    private AddEditDependencyInteractorImpl addEditInteractor;
    public AddEditDependencyPresenterImpl(AddEditContrat.View view)
    {
        this.view =view;
        addEditInteractor = new AddEditDependencyInteractorImpl();
    }

    @Override
    public void validatedependency(String nombre, String shortname, String description) {
        addEditInteractor.validateDependency(nombre,shortname,description,this);
    }

    @Override
    public void onNameEmptyError() {
        view.showErrorName();
        view.setNameEmptyError();
    }

    @Override
    public void onShortNameEmptyError() {
        view.showErrorShortName();
        view.setShortNameEmptyError();
    }

    @Override
    public void onDescriptionError() {
        view.showErrorDescription();
        view.setDescriptionEmptyError();
    }

    @Override
    public void onDependencyDuplicated() {
        view.showDependencyExitsError();
    }

    @Override
    public void onSuccess() {
        view.showListDependency();
    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public void onDestroy() {
        view=null;
        addEditInteractor=null;
    }


}
