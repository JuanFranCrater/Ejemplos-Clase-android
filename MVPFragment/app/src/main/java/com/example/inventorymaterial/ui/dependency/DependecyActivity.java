package com.example.inventorymaterial.ui.dependency;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.adapter.DependencyAdapter;

/**
 * Created by usuario on 25/10/17.
 */

public class DependecyActivity extends AppCompatActivity{

    //private ArrayAdapter<Dependency> dependencies;
    private DependencyAdapter adapter;
    private ListView listView;
    private FloatingActionButton fab;
    private CoordinatorLayout cord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        //Caso 1 : apater no personalizado
       // dependencies = new ArrayAdapter(this, android.R.layout.simple_list_item_1, DependencyRepository.getInstance().getDependencies());
        //getListView().setAdapter(dependencies);
        //caso 2: Array Adapter personalizado
        listView= (ListView) findViewById(android.R.id.list);
        cord=findViewById(R.id.cordL);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        fab=findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        adapter= new DependencyAdapter(this);
        listView.setAdapter(adapter);

        //Al pulsar se visualizará el SnackBar y el FAB se desplazara hacia arriba.
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DependecyActivity.this,AddDependencyActivity.class));
            }
        });

    }
}
