package com.ijuste.estaciones_bizi_grupo3.bbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import com.ijuste.estaciones_bizi_grupo3.R;

import org.jetbrains.annotations.NotNull;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@NotNull Context context) {
        super(context, context.getString(R.string.bbdd), null, 1);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS estaciones;");
        String sql = "CREATE TABLE estaciones(id INTEGER PRIMARY KEY, about TEXT, title TEXT, estado TEXT, estadoEstacion TEXT," +
                "address TEXT, tipoEquipamiento TEXT, BicisDisponibles INTEGER, anclajesDisponibles INTEGER," +
                "lastUpdated TEXT, description TEXT, descripcion TEXT, Imagen TEXT, type TEXT, latitude TEXT, longitude TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
}
