package com.ijuste.estaciones_bizi_grupo3.bbdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.ijuste.estaciones_bizi_grupo3.R;
import com.ijuste.estaciones_bizi_grupo3.model.EstacionBici;
import com.ijuste.estaciones_bizi_grupo3.model.Geometria;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EstacionesADO implements AutoCloseable{

    private final String TABLA;
    private Context context;
    private DBHelper helper;
    private SQLiteDatabase db;

    public EstacionesADO(Context context){
        this.context = context;
        helper = new DBHelper(context);
        db = helper.getReadableDatabase();
        TABLA = context.getString(R.string.tablaEstacion);
    }

    private void actualizarDatos(@NotNull List<EstacionBici> list){
        helper.onCreate(db);
        insertAll(list);
    }

    public void insertAll(@NotNull List<EstacionBici> list){
        for (EstacionBici estacion : list) {
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
            values.put("Imagen", estacion.getImagen());
            values.put("type", estacion.getGeometria().getType());
            values.put("coordinates", estacion.getGeometria().getCoordinates());
            helper.getWritableDatabase().insert(TABLA, null, values);
        }
    }

    public List<EstacionBici> getAll(){
        List<EstacionBici> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLA;
        Cursor cursor = db.rawQuery(sql, null);

        if(!cursor.moveToFirst()) return null;
        recorrerCursor(cursor, list);
        return list;
    }

    public List<EstacionBici> getByAddress(String address){
        List<EstacionBici> list = new ArrayList<>();
        String sql = "SELECT * FROM " + TABLA + "WHERE addres LIKE %?%";
        Cursor cursor = db.rawQuery(sql, new String[]{address});

        if(!cursor.moveToFirst()) return null;
        recorrerCursor(cursor, list);
        return list;
    }

    private void recorrerCursor(@NonNull Cursor cursor, List<EstacionBici> list) {
        while (cursor.moveToNext()) {
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
                    new Geometria(cursor.getString(13), cursor.getString(14))));
        }
    }

    @Override
    public void close() throws Exception {
        db.close();
    }
}