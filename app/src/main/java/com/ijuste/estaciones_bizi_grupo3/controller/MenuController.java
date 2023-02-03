package com.ijuste.estaciones_bizi_grupo3.controller;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ijuste.estaciones_bizi_grupo3.R;

public class MenuController extends AppCompatActivity {

    private String parametro;

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
            buscarPorParametro();
        }
        return super.onOptionsItemSelected(item);

    }

    private void buscarPorParametro() {


        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);


        final EditText input = new EditText(this);
        input.setHint("Nombre");
        layout.addView(input);


        new AlertDialog.Builder(this).setView(layout)
                .setPositiveButton("OK", (dialog, which) -> parametro = input.getText().toString())
                .setNegativeButton("Cancel", (v, x) -> finish())
                .setOnCancelListener(v -> finish())
                .setTitle("Buscador")
                .setMessage("Introduce un parametro para la busqueda")
                .show();
    }
}
