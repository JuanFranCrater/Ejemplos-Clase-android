package com.example.inventorymaterial.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.example.inventorymaterial.R;

import com.example.inventorymaterial.data.db.model.Sector;
import com.example.inventorymaterial.data.db.repository.SectorRepository;

import java.util.ArrayList;


/**
 * Created by usuario on 30/10/17.
 */

public class SectorAdapter extends RecyclerView.Adapter<SectorAdapter.SectorViewHolder>{
    private ArrayList<Sector> sectors;

    public ArrayList<Sector> getSectors() {
        return sectors;
    }

    public ArrayList<Sector> getSectorsMod() {
        return sectorsMod;
    }
    //Array que almacenara los sectores que se han modificado en la interfaz y no se han guardado aun en la base de datos.
    //En nuestro caso en el Repository
    private ArrayList<Sector> sectorsMod;
    private OnSwitchCheckedChangeListener onSwitchCheckedChangeListener;


    public SectorAdapter(){
    sectors= SectorRepository.getInstance().getSectors();
    sectorsMod= new ArrayList<>();
    }

    //Constructor que se llamara cuando la SectorActivity se venga de un cambio de configuracion
    //y se haya salvado el estado dinámico
    public SectorAdapter(ArrayList<Sector> sectorsMod)
    {
        sectors=SectorRepository.getInstance().getSectors();
        this.sectorsMod=sectorsMod;
    }

    @Override
    public SectorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //2.Inflar la vista Crea en memoria el objeto View con todos los Widget del xml: item_dependency.xml
        View viewHolder = inflater.inflate(R.layout.item_sector, null);
        //null porque ya hemos establecio el viewGroup para nuestro item_dependency
        //3. Se crea el objetos SectorViewHolder a partir de la vista
        SectorViewHolder _sectorViewHolder = new SectorViewHolder(viewHolder);
        return _sectorViewHolder;
    }

    @Override
    public void onBindViewHolder(SectorViewHolder holder, int position) {
        holder.swEnabled.setChecked(sectors.get(position).isEnable());
        holder.txvName.setText(sectors.get(position).getName());
        holder.swEnabled.setOnCheckedChangeListener(onSwitchCheckedChangeListener);
        if(sectors.get(position).is_default())
        {
            holder.txvSectorDefault.setText(R.string.txvSectorDefault);
        }
    }

    /**
     * Se crearan tantos elementos SectorViewHolder como elementos haya en el ArrayList definido dentro de la clase
     * @return
     */
    @Override
    public int getItemCount() {
        return sectors.size();
    }

    public static class SectorViewHolder extends RecyclerView.ViewHolder{
        private Switch swEnabled;
        private TextView txvName;
        private TextView txvSectorDefault;

        public SectorViewHolder(View view)
        {super(view);
            swEnabled= view.findViewById(R.id.swSector);
            txvName= view.findViewById(R.id.txvNameS);
            txvSectorDefault= view.findViewById(R.id.txvShortNameS);
        }
    }

    /**
     * Devuelve el arrray de los sectores que el ususario ha modificado cuando la actividad estaba visible(estado dinamico) y que no
     * se ha guardaddo en la base de datos(persistente)
     *
     * @return Arraylist de sectores modificados
     */
    public ArrayList<Sector> getSectorsModified()
    {
        return sectorsMod;
    }

    class OnSwitchCheckedChangeListener implements CompoundButton.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

        }
    }

}
