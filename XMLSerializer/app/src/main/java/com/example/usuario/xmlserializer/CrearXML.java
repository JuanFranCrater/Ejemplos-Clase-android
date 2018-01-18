package com.example.usuario.xmlserializer;

import android.os.Environment;
import android.util.Xml;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by usuario on 16/01/18.
 */

public class CrearXML {

    public static void crearXML(ArrayList<Noticia> noticias, String fichero) throws IOException {
        FileOutputStream fout;
        fout = new FileOutputStream(new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fichero));
        XmlSerializer serializer = Xml.newSerializer();
        serializer.setOutput(fout, "UTF-8");
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true); //poner tabulación
        serializer.startTag(null, "titulares");
        for (int i = 0; i < noticias.size(); i++) {

        }
        serializer.endTag(null, "titulares");
        serializer.endDocument();
        serializer.flush();
        fout.close();
    }
}
