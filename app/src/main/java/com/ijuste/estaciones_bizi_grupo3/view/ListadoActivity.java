package com.ijuste.estaciones_bizi_grupo3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.bbdd.EstacionesADO;
import com.ijuste.estaciones_bizi_grupo3.controller.MenuController;
import com.ijuste.estaciones_bizi_grupo3.controller.adapter.ListadoAdapter;
import com.ijuste.estaciones_bizi_grupo3.model.EstacionBici;

import java.util.List;

public class ListadoActivity extends MenuController {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        RecyclerView recycler = findViewById(R.id.recyclerLista);
        recycler.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recycler.setLayoutManager(layoutManager);

        EstacionesADO objetoAdo = new EstacionesADO(this);

        List<EstacionBici> estaciones = objetoAdo.getAll();
        recycler.setAdapter(new ListadoAdapter(estaciones));

    }
}