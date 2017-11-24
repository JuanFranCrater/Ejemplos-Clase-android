package com.example.inventorymaterial.ui.dependency.contrat;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditInteractor {
    interface OnAddDependecyListener {
        void onNameEmptyError();

        void onShortNameEmptyError();

        void onDescriptionError();

        void onDependencyDuplicated();

        void onSuccess();
    }
    void validateDependency(String nombre, String shortname, String description);
}
