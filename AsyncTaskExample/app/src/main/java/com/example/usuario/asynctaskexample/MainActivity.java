package com.example.usuario.asynctaskexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnSort,btnCancel;
    ProgressBar progressBar;
    TextView textView;
    private static final int MAX_LENGHT=20000;
    private int[] number= new int[MAX_LENGHT];
    SimpleAsyncTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSort=findViewById(R.id.btnSort);
        textView=findViewById(R.id.txtMessage);
        if (savedInstanceState != null) {
            CharSequence savedText = savedInstanceState.getCharSequence("estado");
            textView.setText(savedText);
            onClickSort(btnSort);
        }
        btnCancel=findViewById(R.id.btnCancel);

        progressBar=findViewById(R.id.progressBar);
        generateNumbers();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putCharSequence("estado", textView.getText());
    }

    @Override
    protected void onResume() {
        task=new SimpleAsyncTask();
        super.onResume();
    }

    private void generateNumbers() {
        Random random=new Random();
        for(int i=0;i<MAX_LENGHT;i++)
        {
            number[i]=random.nextInt();
        }
    }

    /**
     * Metodo que ocurre al hacer click
     * @param view
     */
    public void onClickSort(View view)
    {
        /**Opcion 1: SE obtiene el mensaje de error ANR
     bubbleSort();
     textView.setText(R.string.finished);**/
        /**Opcion 2: para la ejecucion del método
         * bubbleSort y posterior actualización del mensaje
         */
        task=new SimpleAsyncTask();
        task.execute();
    }
    public void onClickCancel(View view)
    {
        task.cancel(true);
    }

    private void execWithThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                bubbleSort();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(R.string.finished);
                    }
                });
            }
        }).start();
    }

    /**
     * Metodo que ordena mediante el algoritmo de la burbuja simple
     */
    private void bubbleSort() {
    int aux;
    for (int i=0;i<number.length-1;i++)
    {
        for(int j=i+1;j<number.length-1;j++)
        {
            if(number[i]>number[j])
            {
                aux=number[i];
                number[i]=number[j];
                number[j]=aux;
            }}}
    }

    private class SimpleAsyncTask extends AsyncTask<Void, Float,Void>
    {
        @Override
        protected void onCancelled() {
            super.onCancelled();

        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            int aux;
            for (int i=0;i<number.length-1;i++)
            {
                for(int j=i+1;j<number.length-1;j++)
                {
                    if(number[i]>number[j])
                    {
                        aux=number[i];
                        number[i]=number[j];
                        number[j]=aux;
                    }
                    publishProgress(100*Float.valueOf((String.valueOf(i)))/number.length);
                    if (isCancelled()) break;
                }
            }

            return null;
        }
    }
}
