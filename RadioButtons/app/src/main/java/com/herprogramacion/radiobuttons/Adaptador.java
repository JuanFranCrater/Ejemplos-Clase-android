package com.herprogramacion.radiobuttons;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private final Context contexto;

    private OnItemClickListener escucha;

    interface OnItemClickListener {
        public void onClick(ViewHolder holder, int opcion);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Referencias UI
        public TextView opcion;

        public ViewHolder(View v) {
            super(v);
            opcion = (TextView) v.findViewById(android.R.id.text1);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            escucha.onClick(this, getAdapterPosition());
        }
    }

    public Adaptador(Context contexto, OnItemClickListener escucha) {
        this.contexto = contexto;
        this.escucha = escucha;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // Asignación UI
        holder.opcion.setText(ITEMS[position]);
    }

    @Override
    public int getItemCount() {
        return ITEMS.length;
    }


    public static String[] ITEMS = {
            "1. Usar RadioButton En Android",
            "2. Obtener Valor",
            "3. Cambiar Estado",
            "4. RadioButton desde Android Studio",
            "5. Manejo de Eventos",
            "6. Crear RadioButtons desde SQLite",
            "7. Cambiar Color y Background"
    };
}
