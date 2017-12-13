package com.example.trabajosobrefcheros;

import android.app.ProgressDialog;
import android.os.Debug;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private EditText edtURLImg;
    private EditText edtURLFrases;
    private TextView txtFrases;
    private ImageView imgvImagenes;
    private Button btnDescargar;
    private ArrayList<String> frases;
    private ArrayList<String> imagenes;
    private int tiempo;
    private Handler hdl;
    private int imagenPos;
    private int frasePos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obtenerTiempo();
        imagenPos=0;
        frasePos=0;

        frases = new ArrayList<>();
        imagenes=new ArrayList<>();

        edtURLFrases = (EditText) findViewById(R.id.edtURLfrases);
        edtURLImg = (EditText) findViewById(R.id.edtURLimg);
        txtFrases = (TextView) findViewById(R.id.txtFrases);
        imgvImagenes = (ImageView) findViewById(R.id.imgvImgs);
        btnDescargar =(Button) findViewById(R.id.btnDescargar);
        txtFrases.setText("");
        btnDescargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descargarFichero(edtURLFrases.getText().toString());
                descargarImagenes(edtURLImg.getText().toString());
                obtenerTiempo();

                try {
                    Thread.sleep(2000); //Al parecer debemos darle tiempo a que descarge los datos por que a veces falla
                    if (hdl != null) {
                        hdl.removeCallbacksAndMessages(null);
                    }
                    iniciar();
                } catch (InterruptedException e) {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Error en la obtencion de datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void obtenerTiempo() {
        InputStream is = this.getResources().openRawResource(R.raw.tiempo);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        try {
            tiempo = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            Toast.makeText(MainActivity.this,"Fallo en la lectura del intervalo de tiempo, se instanciara con un intervalo de 5000 milisegundos",Toast.LENGTH_SHORT).show();
            escribirFicheroError(e.getMessage()+" - "+new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()));
            tiempo = 5000;
        }

    }
    private void escribirFicheroError(String error) {
        AsyncHttpClient cliente = new AsyncHttpClient();
        cliente.setTimeout(2000);
        cliente.setMaxRetriesAndTimeout(1, 5000);
        RequestParams params = new RequestParams();
        params.put("lineaError", error);

        cliente.post("http://alumno.mobi/~alumno/superior/benitez/Errores.php", params, new TextHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString, Throwable throwable) {

                Toast.makeText(MainActivity.this, "No se ha podido subir el error", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, String responseString) {
                Toast.makeText(MainActivity.this, "El error ha sido subido", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void descargarImagenes(final String url) {
        final ProgressDialog progreso = new ProgressDialog(this);
        final AsyncHttpClient cliente = new AsyncHttpClient();
        cliente.setTimeout(2000);
        cliente.setMaxRetriesAndTimeout(1, 5000);

            cliente.get(url, new FileAsyncHttpResponseHandler(this) {
                @Override
                public void onStart() {
                    progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progreso.setMessage("Descargando imágenes...");
                    progreso.setCancelable(false);
                    progreso.show();
                }
                @Override
                public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                    String linea;
                    imagenes.clear();
                    try {
                        FileInputStream fis = new FileInputStream(file);
                        InputStreamReader isr = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(isr);
                        while ((linea = br.readLine()) != null) {
                            imagenes.add(linea);
                        }
                        br.close();
                        Toast.makeText(MainActivity.this, "Fichero descargado", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        escribirFicheroError(e.getMessage()+"Fichero De Error "+url+" - "+new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()));
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        escribirFicheroError(e.getMessage()+"Fichero De Error "+url+" - "+new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()));
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    progreso.dismiss();
                }
                @Override
                public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {
                    escribirFicheroError("Fallo al buscar el fichero. Fichero De Error "+url+" - "+new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()));
                    Toast.makeText(MainActivity.this, "Fallo al buscar fichero", Toast.LENGTH_SHORT).show();
                    progreso.dismiss();
                }


            });
    }
    private void descargarFichero(final String url) {
        final ProgressDialog progreso = new ProgressDialog(this);
        final AsyncHttpClient cliente = new AsyncHttpClient();
        cliente.setTimeout(2000);
        cliente.setMaxRetriesAndTimeout(1, 5000);

        cliente.get(url, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onStart() {
                progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progreso.setMessage("Descargando fichero frases...");
                progreso.setCancelable(false);
                progreso.show();
            }

            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, File file) {
                String linea;
                frases.clear();
                try {
                    //fallo de Encoding?
                    FileInputStream fis = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fis, "UTF-8");//No toma las frases en UTF-8?
                    BufferedReader br = new BufferedReader(isr);
                    while ((linea = br.readLine()) != null) {
                        frases.add(linea);
                    }
                    br.close();
                    Toast.makeText(MainActivity.this, "Fichero descargado", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    escribirFicheroError(e.getMessage()+"Fichero De Error "+url+" - "+new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()));
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    escribirFicheroError(e.getMessage()+"Fichero De Error "+url+" - "+new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()));
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                progreso.dismiss();
            }
            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, Throwable throwable, File file) {
                escribirFicheroError("Fallo al buscar el fichero. Fichero De Error"+url+" - "+new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date()));
                Toast.makeText(MainActivity.this, "Fallo al buscar fichero", Toast.LENGTH_SHORT).show();
                progreso.dismiss();
            }
        });
    }
    private void nextImage(int i) {
        Picasso.with(getApplicationContext()).load(imagenes.get(i)).placeholder(R.drawable.placeholder).error(R.drawable.placeholder_error)
                .resize(300, 300).into(imgvImagenes);
    }
    private void iniciar() {
        hdl = new Handler();
        hdl.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    nextImage(imagenPos % imagenes.size());
                    imagenPos++;
                    txtFrases.setText(frases.get(frasePos% frases.size()));
                    frasePos++;
                }catch (ArithmeticException e)
                {}
                hdl.postDelayed(this, tiempo);
            }
        },tiempo);
    }
}
