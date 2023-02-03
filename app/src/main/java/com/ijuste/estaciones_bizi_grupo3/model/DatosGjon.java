package com.ijuste.estaciones_bizi_grupo3.model;

import java.io.Serializable;
import java.util.List;

public class DatosGjon implements Serializable {

    String total;
    String start;
    String rows;
    List<EstacionBici> lista;

    public DatosGjon(String total, String start, String rows, List<EstacionBici> lista) {
        this.total = total;
        this.start = start;
        this.rows = rows;
        this.lista = lista;
    }

    public DatosGjon() {
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public List<EstacionBici> getLista() {
        return lista;
    }

    public void setLista(List<EstacionBici> lista) {
        this.lista = lista;
    }
}
