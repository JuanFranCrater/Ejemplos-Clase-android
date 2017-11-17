package com.example.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Clase de ejemplo de como funciona RadioButton y RadioGroup
 * @author JuanFrancisco Benitez
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    //Usamos View para usar la programacion generica, simplicar vamos
    private View contraintParticular;
    private View constraintBussiness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contraintParticular=findViewById(R.id.contraintParticular);
        constraintBussiness=findViewById(R.id.constraintBussiness);
    }

    /**
     * Método que gestiona el evento onClick en los componentes RadioButton de la Interface
     * @param view
     */
    public void onRadioButtonClicked (View view){
        switch (view.getId())
        {
            case R.id.rbtParticular:
                viewParticular(true);
                break;
            case R.id.rbtBusiness:
                viewParticular(false);
                break;
        }
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
