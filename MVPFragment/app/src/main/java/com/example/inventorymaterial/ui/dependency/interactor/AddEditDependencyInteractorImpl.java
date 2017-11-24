package com.example.inventorymaterial.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditInteractor;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyInteractorImpl {

    public void validateDependency(String name, String shortname ,String description, AddEditInteractor.OnAddDependecyListener listener) {
        //Si el password es vacío
        if (TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        } else if (TextUtils.isEmpty(shortname)) {
            listener.onShortNameEmptyError();
        } else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionError();
        } else if(false)
        {
            listener.onDependencyDuplicated();
        }
    }
}
