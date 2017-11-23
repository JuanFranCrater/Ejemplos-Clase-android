package com.example.inventorymaterial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by usuario on 26/10/17.
 * //Tampoco usamos esta, porque patata
 */

public class DependencyAdapterB extends ArrayAdapter<Dependency> {
    public DependencyAdapterB(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;

        View view=convertView;

        if (view == null) {

        //1.Obtener el servicio del sistema LayoutInflater en el contexto
        // /Opcion1: Esto no ('cause she doesnt use it)-> LayoutInflater inflater = LayoutInflater.from(getContext());
        // Opcion2: no por que nos la jugamos -> LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //2.Inflar la vista Crea en memoria el objeto View con todos los Widget del xml: item_dependency.xml
        view = inflater.inflate(R.layout.item_dependency, null);//null porque ya hemos establecio el viewGroup para nuestro item_dependency
        }
        //3. Inicializar las variables a los objetos ya creados de los widget del xml. !!WARNING VIEW.FINDVIEWID!!
        icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
        txvName = (TextView) view.findViewById(R.id.txvName);
        txvShortName = (TextView) view.findViewById(R.id.txvShortName);
        //4. Mostrar los datos de la posicion del ArrayList mediante position
        icon.setLetter(getItem(position).getShortname().substring(0, 1));
        txvName.setText(getItem(position).getName());//getItem viene de la parametrizacion de la clase(extends)
        txvShortName.setText(getItem(position).getShortname());

        return view;
    }
}
