package com.example.inventorymaterial.ui.dependency.contrat;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContrat {
    interface View{
        void setPresenter(ListDependencyContrat.Presenter presenter);
    }
    interface Presenter{

    }
}
