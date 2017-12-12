package com.example.usuario.xml;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by usuario on 12/12/17.
 */

public class Analisis {
    public static final String TEXTO = "<texto><saludo>Hello World!</saludo><despedida>Goodbye</despedida></texto>";

    public static String analizar(String texto) throws XmlPullParserException, IOException
    {
        StringBuilder cadena = new StringBuilder();
        XmlPullParser xpp = Xml.newPullParser();

        xpp.setInput( new StringReader(texto));
        int eventType = xpp.getEventType();
        cadena.append("Inicio . . . \n");
        while (eventType != XmlPullParser. END_DOCUMENT ) {
            if(eventType == XmlPullParser.START_DOCUMENT)
            {
                cadena.append("Inicio del documento\n");
            }else if(eventType == XmlPullParser.START_TAG)
            {
                cadena.append("Inicio del TAG: "+xpp.getName()+'\n');
            }else if(eventType== XmlPullParser.END_TAG)
            {
                cadena.append("Fin del TAG: "+xpp.getName()+'\n');
            }else if(eventType==XmlPullParser.TEXT)
            {
                cadena.append("TEXT: "+ xpp.getText()+'\n');
            }else if(eventType==XmlPullParser.COMMENT)
            {
                cadena.append("COMENTARIO: "+xpp.getText()+'\n');
            }
            eventType = xpp.next();
        }
        cadena.append("Fin del documento" + "\n" + "Fin");
        return cadena.toString();
    }
}
