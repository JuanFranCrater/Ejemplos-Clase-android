package com.example.inventorymaterial.ui.dependency.contrat;

import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.base.BaseView;

import java.io.Serializable;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditContrat {
    interface View extends BaseView
    {
        void showListDependency();
        void showErrorName();
        void showErrorShortName();
        void showErrorDescription();
        void showDependencyExitsError();
        void setNameEmptyError();
        void setShortNameEmptyError();
        void setDescriptionEmptyError();
    }
    interface Presenter extends BasePresenter, Serializable {
        void validatedependency(String nombre, String shortname, String description);

    }
}
