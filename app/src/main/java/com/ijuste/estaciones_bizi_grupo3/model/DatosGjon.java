package com.ijuste.estaciones_bizi_grupo3.model;

import java.io.Serializable;
import java.util.List;

public class DatosGjon implements Serializable {

    String totalCount;
    String start;
    String rows;
    List<EstacionBici> result;

    public DatosGjon(String total, String start, String rows, List<EstacionBici> lista) {
        this.totalCount = total;
        this.start = start;
        this.rows = rows;
        this.result = lista;
    }

    public DatosGjon() {
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
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

    public List<EstacionBici> getResult() {
        return result;
    }

    public void setResult(List<EstacionBici> result) {
        this.result = result;
    }
}
