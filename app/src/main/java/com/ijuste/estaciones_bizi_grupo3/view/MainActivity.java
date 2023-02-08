package com.ijuste.estaciones_bizi_grupo3.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;
import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.bbdd.DBHelper;
import com.ijuste.estaciones_bizi_grupo3.bbdd.EstacionesADO;
import com.ijuste.estaciones_bizi_grupo3.controller.JsonController;
import com.ijuste.estaciones_bizi_grupo3.model.DatosGjon;
import com.ijuste.estaciones_bizi_grupo3.model.EstacionBici;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public DatosGjon D = new DatosGjon();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(this);

        descarga();

        Handler handler = new Handler(Looper.myLooper());

        handler.postDelayed(()-> {
            Intent intent = new Intent(getApplicationContext(), ListadoActivity.class);
            startActivity(intent);
            finish();
        }, 1500);
    }
    public void descarga() {
        new JsonController(this, "https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/estacion-bicicleta.json?rf=html&srsname=wgs84&start=0&rows=50&distance=500");
    }
    }
