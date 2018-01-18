package com.example.ejerciciosxml.utils;

import java.util.ArrayList;

/**
 * Created by PcCom on 27/12/2017.
 */

public class Enlace {
    public static String EURO="http://www.eurogamer.es/?format=rss";
    public static String PUBLICO="http://www.publico.es/rss/";
    public static String PC="https://www.pcworld.com/index.rss";
    public static ArrayList<String> enlaces= new ArrayList<String>();
    private static String enlace;

    public static void add(String enlace)
    {
        enlaces.add(enlace);
    }
    public static void limpiar()
    {
        enlaces.clear();
    }
    public static ArrayList<String> getEnlaces()
    {
        return enlaces;
    }
    public static void setEnlace(String enlace) {
        Enlace.enlace = enlace;
    }

    public static String getEnlace() {

        return enlace;
    }
}
