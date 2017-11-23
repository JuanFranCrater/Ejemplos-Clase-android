package com.example.inventorymaterial.ui.product;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inventorymaterial.R;
/*
Esta activity es un constrainLayout creado para editar o dar de alta un producto(solo muestra interface)
@author Juan Francisco
@version 17.10.20
 */
public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }
}
