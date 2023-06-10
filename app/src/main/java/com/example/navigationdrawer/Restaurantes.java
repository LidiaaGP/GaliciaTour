package com.example.navigationdrawer;

import android.widget.ImageButton;

import com.google.android.gms.maps.model.LatLng;

public class Restaurantes {

    private String nombre;
    private String descripcion;
    private Integer idLocalidad;
    private ImageButton btn_compartir;
    private Float latitud;
    private  Float lontigud;

    public Restaurantes(String nombre, String descripcion, Integer idLocalidad, ImageButton btn_compartir, Float latitud, Float longitud) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idLocalidad = idLocalidad;
        this.btn_compartir = btn_compartir;
        this.latitud=latitud;
        this.lontigud=longitud;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLontigud() {
        return lontigud;
    }

    public void setLontigud(Float lontigud) {
        this.lontigud = lontigud;
    }

    public ImageButton getBtn_compartir() {
        return btn_compartir;
    }

    public void setBtn_compartir(ImageButton btn_compartir) {
        this.btn_compartir = btn_compartir;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
}
