package com.example.inventorymaterial.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventorymaterial.R;import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyAdapter extends ArrayAdapter<Dependency> {
    /**
     * Se crea una copia del ArrayList que se tiene en DependencyRepository
     * para tener una copia local en el Adapter que se pueda modificar sin cambiar los datos originales
     * @param context
     */
    public DependencyAdapter(@NonNull Context context) {
        super(context, R.layout.item_dependency, new ArrayList<Dependency>(DependencyRepository.getInstance().getDependencies()));
        sort(new Dependency.DependencyOrderByShortName());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;
        View view=convertView;

        if (view == null) {

        //1.Obtener el servicio del sistema LayoutInflater en el contexto
        // /Opcion1: Esto no ('cause she doesnt use it)-> LayoutInflater inflater = LayoutInflater.from(getContext());
        // Opcion2: no por que nos la jugamos -> LayoutInflater inflater = ((Activity)getContext()).getLayoutInflater();
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //2.Inflar la vista Crea en memoria el objeto View con todos los Widget del xml: item_dependency.xml
        view = inflater.inflate(R.layout.item_dependency, null);//null porque ya hemos establecio el viewGroup para nuestro item_dependency
        dependencyHolder  = new DependencyHolder();
            //3. Inicializar las variables a los objetos ya creados de los widget del xml. !!WARNING VIEW.FINDVIEWID!!
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.icon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            dependencyHolder.txvShortName = (TextView) view.findViewById(R.id.txvShortName);
            view.setTag(dependencyHolder);
        }else {
            dependencyHolder=(DependencyHolder)view.getTag();
        }
        //4. Mostrar los datos de la posicion del ArrayList mediante position
        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0, 1));
        dependencyHolder.txvName.setText(getItem(position).getName());//getItem viene de la parametrizacion de la clase(extends)
        dependencyHolder.txvShortName.setText(getItem(position).getShortname());

        return view;
    }
    class DependencyHolder{
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;

    }
}
