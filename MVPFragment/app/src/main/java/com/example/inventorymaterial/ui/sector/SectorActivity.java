package com.example.inventorymaterial.ui.sector;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.adapter.SectorAdapter;
import com.example.inventorymaterial.data.db.model.Sector;

public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSector;
    private SectorAdapter adapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_section,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSector= findViewById(R.id.recyclerSector);
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager(new GridLayoutManager(this,2));
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(savedInstanceState!=null)
        {
            adapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));

        }else {
            adapter= new SectorAdapter();
        }

        recyclerSector.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("sector",((SectorAdapter)recyclerSector.getAdapter()).getSectorsMod());
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        adapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        super.onRestoreInstanceState(savedInstanceState);
    }
}
