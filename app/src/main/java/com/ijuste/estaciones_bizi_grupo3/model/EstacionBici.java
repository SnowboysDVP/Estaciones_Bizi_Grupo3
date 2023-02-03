package com.ijuste.estaciones_bizi_grupo3.model;

import java.io.Serializable;

public class EstacionBici implements Serializable {
    int id;
    String about;
    String title;
    String estado;
    String estadoEstacion;
    String address;
    String tipoEquipamiento;
    int bicisDisponibles;
    int anclajesDisponibles;
    String lastUpdated;
    String description;
    String descripcion;
    String icon;
    Geometry geometry;

    public EstacionBici(){}

    public EstacionBici(int id, String about, String title,
                        String estado, String estadoEstacion,
                        String address, String tipoEquipamiento,
                        int bicisDisponibles, int anclajesDisponibles,
                        String lastUpdated, String description, String descripcion,
                        String imagen, Geometry geometria) {
        this.id = id;
        this.about = about;
        this.title = title;
        this.estado = estado;
        this.estadoEstacion = estadoEstacion;
        this.address = address;
        this.tipoEquipamiento = tipoEquipamiento;
        this.bicisDisponibles = bicisDisponibles;
        this.anclajesDisponibles = anclajesDisponibles;
        this.lastUpdated = lastUpdated;
        this.description = description;
        this.descripcion = descripcion;
        this.icon = imagen;
        this.geometry = geometria;
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
        return bicisDisponibles;
    }

    public void setBicisDisponibles(int bicisDisponibles) {
        bicisDisponibles = bicisDisponibles;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        icon = icon;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
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
                "\nBicisDisponibles : " + bicisDisponibles +
                "\nAnclajesDisponibles : " + anclajesDisponibles +
                "\nLastUpdated : " + lastUpdated +
                "\nDescription : " + description +
                "\nDescripcion : " + descripcion +
                "\nImagen : " + icon +
                "\nGeometria : " + geometry +
                "--------------------------------";
    }
}
