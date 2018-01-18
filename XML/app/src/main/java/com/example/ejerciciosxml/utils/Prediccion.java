package com.example.ejerciciosxml.utils;

import java.util.ArrayList;

/**
 * Created by usuario on 8/01/18.
 */

public class Prediccion {

     String hoy;
     String manana;

     ArrayList<String> prediccionesHoy;
     ArrayList<String> prediccionesManana;
     ArrayList<String> temperaturaHoy;
     ArrayList<String> temperaturaManana;
    ArrayList<String>  horarios;

    public ArrayList<String> getHorarios() {
        return horarios;
    }

    public Prediccion(String hoy, String manana) {
        this.hoy = hoy;
        this.manana=manana;
        prediccionesHoy= new ArrayList<>();
        prediccionesManana= new ArrayList<>();
        temperaturaHoy= new ArrayList<>();
        temperaturaManana= new ArrayList<>();
        horarios=new ArrayList<>();
        horarios.add("00-06");
        horarios.add("06-12");
        horarios.add("12-18");
        horarios.add("18-24");

    }
    public String getFechaHoy()
    {
        return hoy;
    }

    public String getHoy() {
        return hoy;
    }

    public ArrayList<String> getTemperaturaHoy() {
        return temperaturaHoy;
    }

    public ArrayList<String> getTemperaturaManana() {
        return temperaturaManana;
    }

    public ArrayList<String> getPrediccionesManana() {

        return prediccionesManana;
    }

    public ArrayList<String> getPrediccionesHoy() {

        return prediccionesHoy;
    }

    public String getFechaMan()
    {
        return manana;
    }
    public void addPredHoy(String pred)
    {
        prediccionesHoy.add(pred);
    }
    public void addPredMan(String pred)
    {
        prediccionesManana.add(pred);
    }
    public void addTempHoy(String temp)
    {
        temperaturaHoy.add(temp);
    }
    public void addTempMan(String temp)
    {
        temperaturaManana.add(temp);
    }
}
