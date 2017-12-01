package com.example.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

/**
 * Clase de ejemplo de como funciona RadioButton y RadioGroup
 * @author JuanFrancisco Benitez
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    //Usamos View para usar la programacion generica, simplicar vamos
    private View contraintParticular;
    private View constraintBussiness;
    private RadioGroup rgbTypeClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contraintParticular=findViewById(R.id.contraintParticular);
        constraintBussiness=findViewById(R.id.constraintBussiness);
        rgbTypeClient=findViewById(R.id.rgbTypeClient);
        rgbTypeClient.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                switch (id)
                {
                    case R.id.rbtParticular:
                        viewParticular(true);
                        break;
                    case R.id.rbtBusiness:
                        viewParticular(false);
                        break;
                }
            }
        });
    }

    /**
     * Método que indica que ConstraintLayout ha de estar visible según la opcion seleccionada
     * @param b
     */
    private void viewParticular(boolean b)
    {
        contraintParticular.setVisibility(b?View.VISIBLE:View.GONE);
        constraintBussiness.setVisibility(b?View.GONE:View.VISIBLE);

    }
}
