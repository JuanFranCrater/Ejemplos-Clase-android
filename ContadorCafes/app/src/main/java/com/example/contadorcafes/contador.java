package com.example.contadorcafes;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class contador extends AppCompatActivity {

    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contador);
        int contadorTiempo = 1;
        MyCountDownTimer miContador = new MyCountDownTimer(contadorTiempo*60,1000);
        texto=(TextView) findViewById(R.id.txvContador) ;
        miContador.start();

    }
    class MyCountDownTimer extends CountDownTimer
    {

        long minutos;
        long segundos;


        public MyCountDownTimer(long starTime, long interval) {
            super(starTime, interval);

        }

        @Override
        public void onTick(long l) {
            minutos= (l/1000)/60;
            segundos = (l/1000)%60;
            texto.setText(minutos+":"+segundos);

        }

        @Override
        public void onFinish() {

        }
    }
}




