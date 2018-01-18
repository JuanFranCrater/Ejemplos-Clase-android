package com.example.ejerciciosxml.utils;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.widget.ArrayAdapter;

import com.example.ejerciciosxml.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Analisis {

   ;

    public static ArrayList<String> analizarTitulares(File file) throws XmlPullParserException, IOException
    {
        boolean dentroLink=false;
        boolean dentroItem = false;
        boolean dentroTitle = false;
        ArrayList<String> titulares= new ArrayList<>();
        ArrayList<String> enlaces = new ArrayList<>();
        XmlPullParser xpp = Xml.newPullParser();
        xpp.setInput(new FileReader(file));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if(xpp.getName().equals("item"))
                    {
                        dentroItem=true;
                    }
                    if(dentroItem&&xpp.getName().equals("title"))
                    {
                        dentroTitle=true;
                    }
                    if(dentroItem&&xpp.getName().equals("link"))
                    {
                        dentroLink=true;
                    }
                    break;
                case XmlPullParser.TEXT:
                    if(dentroItem&&dentroTitle)
                    {
                        titulares.add(xpp.getText());
                    }
                    if(dentroItem&&dentroLink)
                    {
                        Enlace.add(xpp.getText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if(xpp.getName().equals("item"))
                    {
                        dentroItem=false;
                    }

                    if(dentroItem&&xpp.getName().equals("title"))
                    {
                        dentroTitle=false;
                    }
                    if(dentroItem&&xpp.getName().equals("link"))
                    {
                        dentroLink=false;
                    }
                    break;
            }
            eventType = xpp.next();
        }
        return titulares;
    }

    public static String analizarEmpleados(Context c) throws XmlPullParserException, IOException
    {
        double edadSum=0;
        double sueldoMax=0;
        double sueldoMin=0;
        boolean edad= false;
        boolean sueldo=false;
        int contadorEmpleados = 0;
        StringBuilder cadena = new StringBuilder();
        XmlResourceParser xrp = c.getResources().getXml(R.xml.empleados);
        int eventType = xrp.getEventType();

        while (eventType != XmlPullParser. END_DOCUMENT ) {
             if(eventType == XmlPullParser.START_TAG)
            {
                if(xrp.getName().equals("empleados"))
                {
                    cadena.append("Empleados\n");
                }
                if(xrp.getName().equals("empleado"))
                {
                    contadorEmpleados++;
                }
                if(xrp.getName().equals("nombre"))
                {
                    cadena.append("\nEmpleado: ");
                }
                if(xrp.getName().equals("puesto"))
                {
                    cadena.append("\tPuesto: ");
                }
                if(xrp.getName().equals("edad"))
                {
                    cadena.append("\tEdad: ");
                    edad=true;
                }
                if(xrp.getName().equals("sueldo"))
                {
                    cadena.append("\tSueldo: ");
                    sueldo=true;
                }
            }else  if(eventType==XmlPullParser.TEXT)
            {
                if(sueldo)
                {
                    double sueldotemp =Double.parseDouble(xrp.getText());
                    if(sueldoMin==0)
                    {
                        sueldoMin=sueldotemp;
                    }
                    if(sueldotemp>sueldoMax)
                    {
                        sueldoMax=sueldotemp;
                    }else if(sueldotemp<sueldoMin){
                        sueldoMin=sueldotemp;
                    }
                    sueldo=false;
                }else
                if(edad)
                {
                    edadSum+=Double.parseDouble(xrp.getText());
                    edad=false;
                }
                    cadena.append(xrp.getText()+"\n");

            }
            eventType = xrp.next();
        }
        cadena.append( "\n" + "Sueldo Maximo: "+ String.format("%.2f",sueldoMax) + "\n"  +"Sueldo Minimo: "+ String.format("%.2f",sueldoMin) + "\n"+"Edad Media: "+ String.format("%.2f",edadSum/contadorEmpleados));
        return cadena.toString();
    }

    public static Prediccion analizarMeteo(File file) throws NullPointerException, XmlPullParserException,
            IOException {

        Calendar rightNow = Calendar.getInstance();
        int currentHour = rightNow.get(Calendar.HOUR_OF_DAY);
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        String hoyFecha = new SimpleDateFormat("yyyy-MM-dd").format(today);
        String mañFecha = new SimpleDateFormat("yyyy-MM-dd").format(tomorrow);
        Prediccion prediccion= new Prediccion(hoyFecha,mañFecha);
        boolean temperatura=false;
        boolean hoy=false;
        boolean mañana=false;
        boolean minima=false;
        boolean maxima=false;
        boolean estadoCielo = false;

        XmlPullParser xpp = Xml.newPullParser();
        xpp.setInput(new FileReader(file));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if(temperatura)
                    {
                        if(xpp.getName().equals("minima"))
                        {
                            minima=true;
                        }else if(xpp.getName().equals("maxima"))
                        {
                            maxima=true;
                        }
                    }
                        if(xpp.getName().equals("estado_cielo")&&(hoy||mañana))
                        {
                            if (xpp.getAttributeValue(0).equals("00-06")) {
                                if(hoy&&(currentHour<6)) {
                                    estadoCielo=true;
                                }else if(mañana) {

                                    estadoCielo=true;
                                }
                            }else  if (xpp.getAttributeValue(0).equals("06-12")) {
                                if(hoy&&(currentHour<12)) {
                                    estadoCielo = true;
                                }else if(mañana) {
                                    estadoCielo=true;
                                }
                            }else  if (xpp.getAttributeValue(0).equals("12-18")) {
                                if(hoy&&(currentHour<18)) {
                                    estadoCielo = true;
                                }else if(mañana){
                                    estadoCielo=true;
                                }
                            }else if (xpp.getAttributeValue(0).equals("18-24")) {
                                estadoCielo = true;
                            }
                        }

                        if (xpp.getName().equals("dia")) {
                            if (xpp.getAttributeValue(0).equals(hoyFecha)) {
                                hoy = true;
                                mañana = false;
                            } else if (xpp.getAttributeValue(0).equals(mañFecha)) {
                                mañana = true;
                                hoy = false;
                            } else {
                                hoy = false;
                                mañana = false;
                            }
                        } else if (xpp.getName().equals("temperatura")&&(hoy||mañana)) {
                            temperatura = true;
                        }


                    break;
                case XmlPullParser.TEXT:
                    if(estadoCielo)
                    {
                        if(hoy)
                        {
                            estadoCielo=false;
                            prediccion.addPredHoy("http://www.aemet.es/imagenes/png/estado_cielo/"+xpp.getText()+"_g.png");

                        }else if(mañana)
                        {
                            estadoCielo=false;
                            prediccion.addPredMan("http://www.aemet.es/imagenes/png/estado_cielo/"+xpp.getText()+"_g.png");
                        }
                        Log.d("Imagen Obtenida",xpp.getText());

                    }
                       if(temperatura)
                       {
                           if(maxima)
                           {
                                if(hoy) {
                                    prediccion.addTempHoy(xpp.getText() + "ºC\n");
                                }else if(mañana)
                                {
                                    prediccion.addTempMan(xpp.getText() + "ºC\n");
                                }
                           }
                           if(minima)
                           {
                               if(hoy) {
                                   prediccion.addTempHoy(xpp.getText() + "ºC\n");
                               }else if(mañana)
                               {
                                   prediccion.addTempMan(xpp.getText() + "ºC\n");
                               }
                           }

                       }
                    break;
                case XmlPullParser.END_TAG:
                    if(xpp.getName().equals("temperatura"))
                    {
                        temperatura=false;
                    }if(xpp.getName().equals("maxima"))
                      {
                    maxima=false;
                      }
                    if(xpp.getName().equals("minima"))
                    {
                        minima=false;
                    }

                    break;
            }
            eventType = xpp.next();
        }
        return prediccion;
    }
}
