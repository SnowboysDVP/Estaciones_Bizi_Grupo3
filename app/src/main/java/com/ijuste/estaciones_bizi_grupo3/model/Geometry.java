package com.ijuste.estaciones_bizi_grupo3.model;

import java.io.Serializable;

public class Geometry implements Serializable {
    String type;
    String[] coordinates;

    public Geometry(String type, String[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public Geometry(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Geometria : " +
                "\nType=" + type +
                "\nCoordinates='" + coordinates[0]+coordinates[1];
    }
}
