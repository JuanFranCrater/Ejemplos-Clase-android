package com.example.ejerciciosxml;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnEmpleado,btnNews, btnMeteo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnEmpleado=findViewById(R.id.btnEmpleados);
        btnMeteo=findViewById(R.id.btnMeteo);
        btnNews= findViewById(R.id.btnNews);
        btnMeteo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,MeteoActivity.class));
            }
        });
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,PeriodicosActivity.class));
            }
        });
        btnEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this,EmpleadosActivity.class));
            }
        });
    }
}
