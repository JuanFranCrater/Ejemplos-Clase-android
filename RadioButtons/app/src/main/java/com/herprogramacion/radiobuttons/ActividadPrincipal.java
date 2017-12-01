package com.herprogramacion.radiobuttons;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

public class ActividadPrincipal extends AppCompatActivity implements Adaptador.OnItemClickListener {

    public static final String EXTRA_OPCION = "extra.opcion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        Adaptador adaptador = new Adaptador(this, this);

        RecyclerView recicler = (RecyclerView) findViewById(R.id.lista);
        recicler.setAdapter(adaptador);
    }

    @Override
    public void onClick(Adaptador.ViewHolder holder, int opcion) {
        mostrarOpcion(opcion);
    }

    private void mostrarOpcion(int indice) {
        Intent i = new Intent(this, ActividadEjemplos.class);
        i.putExtra(EXTRA_OPCION, indice);

        startActivity(i);
    }
}