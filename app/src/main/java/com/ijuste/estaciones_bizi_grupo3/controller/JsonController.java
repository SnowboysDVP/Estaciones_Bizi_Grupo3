package com.ijuste.estaciones_bizi_grupo3.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.ijuste.estaciones_bizi_grupo3.bbdd.EstacionesADO;
import com.ijuste.estaciones_bizi_grupo3.model.DatosGjon;
import com.ijuste.estaciones_bizi_grupo3.model.EstacionBici;
import com.ijuste.estaciones_bizi_grupo3.util.UtilidadesJson;
import com.ijuste.estaciones_bizi_grupo3.view.ListadoActivity;
import com.ijuste.estaciones_bizi_grupo3.view.MainActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonController extends  Thread{


    private String url;
    private Context context;


    public JsonController(Context context, String url){
        this.url = url;
        this.context = context;
        start(); // Iniciamos el hilo en el constructor, puede hacerse fuera
    }

    @Override
    public void run() {
        String content = null;
        try {
            content = UtilidadesJson.descargarTexto(url); // Usamos esta función para descargar la información
            Log.i("tag",content);
            Gson gson = new Gson();
            DatosGjon datos = gson.fromJson(content,DatosGjon.class);
            EstacionesADO ado = new EstacionesADO(context);
            ado.update(datos.getResult());
            Log.i("tag",datos.getResult().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }
