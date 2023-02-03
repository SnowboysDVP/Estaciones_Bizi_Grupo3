package com.ijuste.estaciones_bizi_grupo3.model;

public class Geometria {
    String type;
    String coordinates;

    public Geometria(String type, String coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public Geometria(){}

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Geometria : " +
                "\nType=" + type +
                "\nCoordinates='" + coordinates;
    }
}
