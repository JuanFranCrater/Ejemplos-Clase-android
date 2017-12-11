package com.example.inventorymaterial.ui.dependency.interactor;

import android.text.TextUtils;
import android.util.Log;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.example.inventorymaterial.ui.dependency.contrat.AddEditInteractor;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyInteractorImpl implements AddEditInteractor {

    @Override
    public void validateDependency(String name, String shortname, String description, AddEditInteractor.OnAddDependecyListener listener) {
        if (TextUtils.isEmpty(name)) {
            listener.onNameEmptyError();
        } else if (TextUtils.isEmpty(shortname)) {
            listener.onShortNameEmptyError();
        } else if (TextUtils.isEmpty(description)) {
            listener.onDescriptionError();
        } else if(DependencyRepository.getInstance().foundDependency(name, shortname)!=-1)//se pregunta si existe en la base de datos
        {
            int id=DependencyRepository.getInstance().foundDependency(name,shortname);
            if(id==-1)
            {
                DependencyRepository.getInstance().addDependency(new Dependency(id, name, shortname, description));
            }else{
                DependencyRepository.getInstance().editDependency(id,name,shortname,description);
            }
           listener.onSuccess();

        } else{
            listener.onDependencyDuplicated();
        }
    }
}
