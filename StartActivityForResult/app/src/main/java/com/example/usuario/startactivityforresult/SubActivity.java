package com.example.usuario.startactivityforresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    private EditText edtMessage;
    private Button btnCancel;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        edtMessage=findViewById(R.id.edtMessage);
        btnCancel=findViewById(R.id.btnCancel);
        btnSend=findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //1. Comprobar que el mensaje no este vacio
                if(edtMessage.getText().length()>0)
                {
                    //2. Se añade el mensaje al intent
                    intent.putExtra("message",edtMessage.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }else{
                    Toast.makeText(SubActivity.this, "Rellena esa mierda", Toast.LENGTH_SHORT).show();
                }
                //3. Indicar que le resultado ha sido correcto
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
