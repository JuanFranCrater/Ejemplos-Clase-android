package com.example.inventorymaterial.ui.dependency.contrat;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.ui.base.BasePresenter;
import com.example.inventorymaterial.ui.base.BaseView;

import java.io.Serializable;
import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContrat {
    interface View extends BaseView{
      void showDependency(List<Dependency> list);
      void showDeleteDependency();
      void showMessageList(String message);
    }
    interface Presenter extends BasePresenter, Serializable {
        void loadDependency();
    }
}
