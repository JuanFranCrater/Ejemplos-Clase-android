package com.example.ejerciciosxml;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ejerciciosxml.utils.Enlace;

import java.util.ArrayList;

public class PeriodicosActivity extends ListActivity {

    ListView listView;
    ArrayList<String> listItems = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodicos);
        listView=findViewById(android.R.id.list);
        listItems.add("Eurogamer");
        listItems.add("Publico");
        listItems.add("PcWorld");
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String selecion= (String) listView.getItemAtPosition(position);
               if(selecion.equals("PcWorld"))
               {
                   Enlace.setEnlace(Enlace.PC);
               }else if(selecion.equals("Publico"))
               {
                   Enlace.setEnlace(Enlace.PUBLICO);
               } else if(selecion.equals("Eurogamer"))
               {
                   Enlace.setEnlace(Enlace.EURO);
               }
                startActivity(new Intent(PeriodicosActivity.this,TitularesActivity.class));
            }
        });
    }
}
