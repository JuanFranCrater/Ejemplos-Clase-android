package com.herprogramacion.radiobuttons;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class ActividadEjemplos extends AppCompatActivity {

    public static int[] layouts = {
            R.layout.ejemplo_1,
            R.layout.ejemplo_2,
            R.layout.ejemplo_3,
            R.layout.ejemplo_4,
            R.layout.ejemplo_5,
            R.layout.ejemplo_6,
            R.layout.ejemplo_7

    };

    private RadioButton radioDeposito;
    private View contenedorParticular;
    private View contenedorCorporativo;

    private ControladorSQLite sqLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int opcion = getIntent().getIntExtra(ActividadPrincipal.EXTRA_OPCION, -1);

        setContentView(layouts[opcion]);

        switch (opcion) {
            case 1:
                // Ejemplo 2
                radioDeposito = (RadioButton) findViewById(R.id.radio_deposito);
                break;
            case 2:
                // Ejemplo 3
                RadioGroup contenedor = (RadioGroup) findViewById(R.id.grupo_dias);
                RadioButton opcionI2 = (RadioButton) contenedor.getChildAt(2);
                opcionI2.setChecked(true);
                break;

            case 4:
                // Ejemplo 5
                contenedorParticular = findViewById(R.id.ll_contenedor_particular);
                contenedorCorporativo = findViewById(R.id.ll_contenedor_corporativo);
                break;

            case 5:
                // Ejemplo 6
                RadioGroup opcionesMarca = (RadioGroup) findViewById(R.id.rg_respuestas);

                sqLiteOpenHelper = new ControladorSQLite(this);

                Cursor c = sqLiteOpenHelper.getRespuestas();

                while (c.moveToNext()) {
                    String respuesta = c.getString(c.getColumnIndex(Contrato.ColumnasRespuesta.RESPUESTA));
                    opcionesMarca.addView(crearRadioButton(respuesta));
                }
                break;
        }

    }

    public void comprobarModoPago(View v) {
        if (radioDeposito.isChecked()) {
            final String text = "Comprobar ubicación del usuario";
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }

    public void onRadioButtonClicked(View view) {
        boolean marcado = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rb_corporativo:
                if (marcado) {
                    mostrarParticular(false);
                }
                break;

            case R.id.rb_particular:
                if (marcado) {
                    mostrarParticular(true);
                }
                break;
        }
    }

    private void mostrarParticular(boolean b) {
        contenedorParticular.setVisibility(b ? View.VISIBLE : View.GONE);
        contenedorCorporativo.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    private RadioButton crearRadioButton(String respuesta) {
        RadioButton nuevoRadio = new RadioButton(this);
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(
                RadioGroup.LayoutParams.WRAP_CONTENT,
                RadioGroup.LayoutParams.WRAP_CONTENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(respuesta);
        nuevoRadio.setTag(respuesta);
        return nuevoRadio;
    }

}
