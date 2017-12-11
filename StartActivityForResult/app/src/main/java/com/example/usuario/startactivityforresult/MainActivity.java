package com.example.usuario.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txvName;
    private TextView txvSurname;
    private Button btnName;
    private Button btnSurname;
    private final static int NAME= 0;
    private final static int SURNAME= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvName=findViewById(R.id.txvName);
        txvSurname =findViewById(R.id.txvSurname);
        btnName=findViewById(R.id.btnName);
        btnSurname=findViewById(R.id.btnSurname);
        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                startActivityForResult(intent,MainActivity.NAME);
            }
        });
        btnSurname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SubActivity.class);
                startActivityForResult(intent,MainActivity.SURNAME);
            }
        });
    }

    /**
     * Se trata de un métoo callback que será llamdo cuando la app secundaria finalize
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //1. Primero se comprueba el codigo de la peticion

        switch (requestCode){
            case NAME:
                if(resultCode==RESULT_OK)
                {
                    String message = data.getExtras().getString("message");
                    txvName.setText(message);
                }
                break;
            case SURNAME:
                if(resultCode==RESULT_OK)
                {
                    String message = data.getExtras().getString("message");
                    txvSurname.setText(message);
                }
                break;
        }
        //2. Se comprueba el resultado

    }
}
