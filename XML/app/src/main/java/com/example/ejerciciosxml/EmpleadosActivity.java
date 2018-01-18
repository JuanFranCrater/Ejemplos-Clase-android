package com.example.ejerciciosxml;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ejerciciosxml.utils.Analisis;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class EmpleadosActivity extends AppCompatActivity {
    String textoEmpleados;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);
        textView=findViewById(R.id.textView);
        try {
            textoEmpleados= Analisis.analizarEmpleados(this);
            textView.setText(textoEmpleados);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
