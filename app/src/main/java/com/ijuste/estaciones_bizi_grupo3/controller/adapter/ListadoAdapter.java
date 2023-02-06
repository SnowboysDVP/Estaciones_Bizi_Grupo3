package com.ijuste.estaciones_bizi_grupo3.controller.adapter;

import android.app.AlertDialog;
import android.content.Intent;
import android.text.NoCopySpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.model.EstacionBici;
import com.ijuste.estaciones_bizi_grupo3.view.FichaEstacionActivity;

import java.io.Serializable;
import java.util.List;

public class ListadoAdapter extends RecyclerView.Adapter<ListadoAdapter.ViewHolder> implements Serializable {

    private final List<EstacionBici> estaciones;

    public ListadoAdapter(List<EstacionBici> estaciones) {this.estaciones = estaciones;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EstacionBici estacion = estaciones.get(position);

        holder.txtTituloCalle.setText(estacion.getAddress());
        holder.txtBicisDisponibles.setText(String.valueOf(estacion.getBicisDisponibles()));
        holder.txtAnclajesDisponibles.setText(String.valueOf(estacion.getAnclajesDisponibles()));


        holder.itemView.setOnClickListener(v->{

            Intent intent = new Intent(v.getContext(), FichaEstacionActivity.class);
            intent.putExtra("posicion", position);
            intent.putExtra("array", (Serializable) estaciones);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return estaciones.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTituloCalle;
        TextView txtBicisDisponibles;
        TextView txtAnclajesDisponibles;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTituloCalle = itemView.findViewById(R.id.txtTituloCalle);
            txtBicisDisponibles = itemView.findViewById(R.id.txtBicisDisponibles);
            txtAnclajesDisponibles = itemView.findViewById(R.id.txtAnclajesDisponibles);
        }
    }
}
