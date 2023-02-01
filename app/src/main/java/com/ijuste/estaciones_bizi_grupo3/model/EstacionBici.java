package com.ijuste.estaciones_bizi_grupo3.model;

import java.util.Date;

public class EstacionBici {
    int id;
    String about;
    String title;
    String estado;
    String estadoEstacion;
    String address;
    String tipoEquipamiento;
    int BicisDisponibles;
    int anclajesDisponibles;
    String lastUpdated;
    String description;
    String descripcion;
    String Imagen;
    Geometria geometria;

    public EstacionBici(int id, String about, String title,
                        String estado, String estadoEstacion,
                        String address, String tipoEquipamiento,
                        int bicisDisponibles, int anclajesDisponibles,
                        String lastUpdated, String description, String descripcion,
                        String imagen, Geometria geometria) {
        this.id = id;
        this.about = about;
        this.title = title;
        this.estado = estado;
        this.estadoEstacion = estadoEstacion;
        this.address = address;
        this.tipoEquipamiento = tipoEquipamiento;
        BicisDisponibles = bicisDisponibles;
        this.anclajesDisponibles = anclajesDisponibles;
        this.lastUpdated = lastUpdated;
        this.description = description;
        this.descripcion = descripcion;
        Imagen = imagen;
        this.geometria = geometria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstadoEstacion() {
        return estadoEstacion;
    }

    public void setEstadoEstacion(String estadoEstacion) {
        this.estadoEstacion = estadoEstacion;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTipoEquipamiento() {
        return tipoEquipamiento;
    }

    public void setTipoEquipamiento(String tipoEquipamiento) {
        this.tipoEquipamiento = tipoEquipamiento;
    }

    public int getBicisDisponibles() {
        return BicisDisponibles;
    }

    public void setBicisDisponibles(int bicisDisponibles) {
        BicisDisponibles = bicisDisponibles;
    }

    public int getAnclajesDisponibles() {
        return anclajesDisponibles;
    }

    public void setAnclajesDisponibles(int anclajesDisponibles) {
        this.anclajesDisponibles = anclajesDisponibles;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public Geometria getGeometria() {
        return geometria;
    }

    public void setGeometria(Geometria geometria) {
        this.geometria = geometria;
    }

    @Override
    public String toString() {
        return "-----Estación de bici-----" +
                "\nId : " + id +
                "\nAbout : " + about +
                "\nTitle : " + title +
                "\nEstado : " + estado +
                "\nEstado de la estacion : " + estadoEstacion +
                "\nAddress : " + address +
                "\nTipo de equipamiento : " + tipoEquipamiento +
                "\nBicisDisponibles : " + BicisDisponibles +
                "\nAnclajesDisponibles : " + anclajesDisponibles +
                "\nLastUpdated : " + lastUpdated +
                "\nDescription : " + description +
                "\nDescripcion : " + descripcion +
                "\nImagen : " + Imagen + 
                "\nGeometria : " + geometria +
                "--------------------------------";
    }
}
