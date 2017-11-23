package com.example.inventorymaterial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.inventorymaterial.ui.login.LoginViewImpl;

/*
Esta activity es un Splash que se muestra al inicio de nuestra aplicacion(desactivada actualmente)
@author Juan Franciscog
@version 17.10.20
 */
public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imgV=(ImageView)findViewById(R.id.imageView);
        imgV.setOnClickListener(this);
        //llamarLogin();

    }
    private void llamarLogin()
    {
        Intent intent = new Intent(SplashActivity.this, LoginViewImpl.class);

        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if (view == imgV)
        {llamarLogin();}
    }
}
