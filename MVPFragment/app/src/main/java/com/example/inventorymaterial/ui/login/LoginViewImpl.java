package com.example.inventorymaterial.ui.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.inventorymaterial.DashboardActivity;
import com.example.inventorymaterial.R;
import com.example.inventorymaterial.ui.base.BaseActivity;

/*
Esta activity es el login de la aplicacion donde el usuario se conectara(no hace login aún, se entra sea cuales sean los datos introducidos)
@author Juan Francisco
@version 17.10.20
 */

public class LoginViewImpl extends BaseActivity implements LoginView {

    private Button btnSingIn;
    private LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter= new LoginPresenterImpl(this);
        btnSingIn=(Button)findViewById(R.id.btnSignIN);
        btnSingIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(v==btnSingIn){
                    loginPresenter.validateCredentials("Lourdes","Lourdes");
                }
        }
    });



    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(LoginViewImpl.this, DashboardActivity.class);
        startActivity(intent);
    }

    @Override
    public void setUserEmptyError() {
        onError(R.string.errorUserEmpty);
    }

    @Override
    public void setPasswordEmptyError() {
        onError(R.string.errorUserEmpty);
    }

    @Override
    public void setPasswordError() {
        onError(R.string.errorPasswordLength);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.onDestroy();
    }
}
