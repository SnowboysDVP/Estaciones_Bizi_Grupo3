package com.ijuste.estaciones_bizi_grupo3.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.model.EstacionBici;
import com.ijuste.estaciones_bizi_grupo3.model.Geometry;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EstacionesADO implements AutoCloseable{

    private final String TABLA;
    private final DBHelper helper;
    private final SQLiteDatabase db;

    public EstacionesADO(Context context){
        helper = new DBHelper(context);
        db = helper.getReadableDatabase();
        TABLA = context.getString(R.string.tablaEstacion);
    }

    public void update(@NotNull List<EstacionBici> list){
        helper.onCreate(db);
        insertAll(list);
    }

    public void insertAll(@NotNull List<EstacionBici> list){
        for (EstacionBici estacion : list) {
            insertStation(estacion);
        }
    }

    private void insertStation(@NonNull EstacionBici estacion) {
        ContentValues values = new ContentValues();
        values.put("id", estacion.getId());
        values.put("about", estacion.getAbout());
        values.put("title", estacion.getTitle());
        values.put("estado", estacion.getEstado());
        values.put("estadoEstacion", estacion.getEstadoEstacion());
        values.put("address", estacion.getAddress());
        values.put("tipoEquipamiento", estacion.getTipoEquipamiento());
        values.put("BicisDisponibles", estacion.getBicisDisponibles());
        values.put("anclajesDisponibles", estacion.getAnclajesDisponibles());
        values.put("lastUpdated", estacion.getLastUpdated());
        values.put("description", estacion.getDescription());
        values.put("descripcion", estacion.getDescripcion());
        values.put("Imagen", estacion.getIcon());
        values.put("type", estacion.getGeometry().getType());
        values.put("latitude", estacion.getGeometry().getCoordinates()[0]);
        values.put("longitude", estacion.getGeometry().getCoordinates()[1]);
        helper.getWritableDatabase().insert(TABLA, null, values);
    }

    public ArrayList<EstacionBici> getAll(){
        String sql = "SELECT * FROM " + TABLA;
        return runCursor(db.rawQuery(sql, null));
    }

    public ArrayList<EstacionBici> getByAddress(String address){
        String sql = "SELECT * FROM " + TABLA + " WHERE address LIKE ?";
        address = "%" + address + "%";
        return runCursor(db.rawQuery(sql, new String[]{address}));
    }

    @Nullable
    private ArrayList<EstacionBici> runCursor(@NonNull Cursor cursor) {
        ArrayList<EstacionBici> list = new ArrayList<>();
        if(!cursor.moveToFirst()) return null;
        do {
            list.add(new EstacionBici(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getString(9),
                    cursor.getString(10),
                    cursor.getString(11),
                    cursor.getString(12),
                    new Geometry(cursor.getString(13), new String[]{cursor.getString(14), cursor.getString(15)})));
        } while (cursor.moveToNext());
        return list;
    }

    @Override
    public void close(){
        db.close();
    }
}