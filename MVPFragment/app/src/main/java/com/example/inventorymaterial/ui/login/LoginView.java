package com.example.inventorymaterial.ui.login;

/**
 * Created by usuario on 10/11/17.
 */

//Contiene los métodos necesesarios/expuestos para la comunicación del presentador con la vista
public interface LoginView {
    void navigateToHome();

    void setUserEmptyError();

    void setPasswordEmptyError();

    void setPasswordError();
}
