package com.ijuste.estaciones_bizi_grupo3.controller;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ijuste.estaciones_bizi_grupo3.R;

public class MenuController extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.listadoRegistros){

        }else if(item.getItemId()==R.id.actualizarDatos){

        }else if(item.getItemId()==R.id.busacdorDatos){

        }
        return super.onOptionsItemSelected(item);

    }
}
