package com.example.usuario.xmlserializer;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by usuario on 16/01/18.
 */

public class Analisis {

    public static ArrayList<Noticia> analizarTitulares(File file) throws XmlPullParserException, IOException
    {
        boolean dentroLink=false;
        boolean dentroItem = false;
        boolean dentroTitle = false;
        boolean dentroDescription=false;
        ArrayList<Noticia> titulares= new ArrayList<>();
        Noticia noticia = new Noticia();
        XmlPullParser xpp = Xml.newPullParser();
        xpp.setInput(new FileReader(file));
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_TAG:
                    if(xpp.getName().equals("item"))
                    {
                        dentroItem=true;
                        noticia=new Noticia();
                    }
                    if(dentroItem&&xpp.getName().equals("title"))
                    {
                        dentroTitle=true;
                    }
                    if(dentroItem&&xpp.getName().equals("link"))
                    {
                        dentroLink=true;
                    }
                    if(dentroItem&&xpp.getName().equals("description"))
                    {
                        dentroDescription=true;
                    }
                    break;
                case XmlPullParser.TEXT:
                    if(dentroItem&&dentroTitle)
                    {
                        noticia.setTitle(xpp.getText());
                    }
                    if(dentroItem&&dentroLink)
                    {
                        noticia.setLink(xpp.getText());
                    }
                    if(dentroItem&&dentroDescription)
                    {
                        noticia.setDescription(xpp.getText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if(xpp.getName().equals("item"))
                    {
                        titulares.add(noticia);
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
}
