package com.example.ejerciciosxml;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerciciosxml.utils.Analisis;
import com.example.ejerciciosxml.utils.Prediccion;
import com.example.ejerciciosxml.utils.Restclient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;

import cz.msebera.android.httpclient.Header;

public class MeteoActivity extends AppCompatActivity implements View.OnClickListener{

    private static String URL="http://www.aemet.es/xml/municipios/localidad_29067.xml";
    private static String TEMPORAL = "meteo.xml";
    Button boton;
    TextView informacion;
    TableLayout tableLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meteo);
        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(this);
        tableLayout =findViewById(R.id.tabLayout);
        informacion = (TextView) findViewById(R.id.txvInformacion);


    }

    @Override
    public void onClick(View v) {
        if (v == boton) {
            tableLayout.removeAllViews();
            descarga(URL, TEMPORAL);
        }
    }

    private void descarga(String rss, String temporal) {
        final ProgressDialog progreso = new ProgressDialog(this);
        File miFichero = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), temporal);
        Restclient.get(rss, new FileAsyncHttpResponseHandler(miFichero) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                progreso.dismiss();
                Toast.makeText(MeteoActivity.this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                progreso.dismiss();
                Toast.makeText(MeteoActivity.this,"Fichero descargado correctamente",Toast.LENGTH_SHORT).show();
                try {
                    Prediccion prediccion=Analisis.analizarMeteo(file);
                    tableLayout.setBackground(getResources().getDrawable (R.drawable.border,null));

                    //Primera Row
                    TableRow titleRow = new TableRow(MeteoActivity.this);
                    ImageView image = new ImageView(MeteoActivity.this);


                    TextView view = new TextView(MeteoActivity.this);
                    view.setTextSize(20);
                    view.setText("Fecha");
                    view.setBackgroundResource(R.color.tableColor);
                    titleRow.addView(view);

                    view=new TextView(MeteoActivity.this);
                    view.setText("   "+prediccion.getFechaHoy()+"   ");
                    view.setGravity(Gravity.CENTER);
                    view.setTextSize(20);
                    view.setBackgroundResource(R.color.tableColor);
                    titleRow.addView(view);
                    view=new TextView(MeteoActivity.this);
                    view.setText("   "+prediccion.getFechaMan()+"   ");
                    view.setGravity(Gravity.CENTER);
                    view.setTextSize(20);
                    view.setBackgroundResource(R.color.tableColor);
                    titleRow.addView(view);
                    tableLayout.addView(titleRow);

                    //Segunda Row
                    TableRow meteoRow= new TableRow(MeteoActivity.this);
                    view=new TextView(MeteoActivity.this);
                    view.setText("Estado del\ncielo");
                    view.setTextSize(20);
                    meteoRow.addView(view);
                    //Tabla de predicciones HOY
                    TableLayout prediccionHoy = new TableLayout(MeteoActivity.this);
                    TableRow tmpHoy= new TableRow(MeteoActivity.this);
                    for (int i = 0; i <prediccion.getPrediccionesHoy().size() ; i++)
                    {

                        Picasso.with(MeteoActivity.this)
                                .load(prediccion.getPrediccionesHoy().get(i))
                                .into(image);
                        tmpHoy.addView(image);
                        image=new ImageView(MeteoActivity.this);

                    }
                    prediccionHoy.addView(tmpHoy);
                    meteoRow.addView(prediccionHoy);

                    //Tabla de predicciones Manana
                    TableLayout prediccionMan = new TableLayout(MeteoActivity.this);
                    TableRow tmp= new TableRow(MeteoActivity.this);
                    for (int i = 0; i <prediccion.getPrediccionesManana().size() ; i++)
                    {

                        Picasso.with(MeteoActivity.this)
                                .load(prediccion.getPrediccionesManana().get(i))
                                .into(image);
                        tmp.addView(image);
                        image=new ImageView(MeteoActivity.this);

                    }

                    prediccionMan.addView(tmp);
                    meteoRow.addView(prediccionMan);



                    tableLayout.addView(meteoRow);

                    //Tercera Row
                    TableRow temperaturaRow = new TableRow(MeteoActivity.this);
                    view = new TextView(MeteoActivity.this);

                    view.setText("Temp máx.\n/min (ºC)");
                    view.setTextSize(20);
                    temperaturaRow.addView(view);

                    view=new TextView(MeteoActivity.this);
                    view.setText(prediccion.getTemperaturaHoy().get(0)+"/"+prediccion.getTemperaturaHoy().get(1));
                    view.setTextSize(20);
                    temperaturaRow.addView(view);
                    view=new TextView(MeteoActivity.this);
                    view.setText(prediccion.getTemperaturaManana().get(0)+"/"+prediccion.getTemperaturaManana().get(1));
                    view.setTextSize(20);
                    temperaturaRow.addView(view);
                    tableLayout.addView(temperaturaRow);

                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                    Toast.makeText(MeteoActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(MeteoActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onStart() {
                super.onStart();
                progreso.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progreso.setMessage("Conectando . . .");
                progreso.setCancelable(false);
                progreso.show();
            }

        });
    }
}