package com.ijuste.estaciones_bizi_grupo3.controller;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.bbdd.EstacionesADO;
import com.ijuste.estaciones_bizi_grupo3.controller.adapter.ListadoAdapter;
import com.ijuste.estaciones_bizi_grupo3.view.ListadoActivity;

public class MenuController extends AppCompatActivity {
    private EstacionesADO ado;

    private String parametro;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_layout,menu);
        ado= new EstacionesADO(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.listadoRegistros){
            Intent intento = new Intent(getApplicationContext(), ListadoActivity.class);
            startActivity(intento);
        }else if(item.getItemId()==R.id.actualizarDatos){
            ado.getAll();
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
                .setPositiveButton("OK", (dialog, which) ->{
                    parametro = input.getText().toString();
                    Intent intent = new Intent(this,ListadoActivity.class);
                    intent.putExtra("listafiltrada",ado.getByAddress(parametro));
                    startActivity(intent);
                } )
                .setNegativeButton("Cancel", (v, x) -> finish())
                .setOnCancelListener(v -> finish())
                .setTitle("Buscador")
                .setMessage("Introduce un parametro para la busqueda")
                .show();
    }
}
