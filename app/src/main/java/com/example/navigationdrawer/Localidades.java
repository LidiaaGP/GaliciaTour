package com.example.navigationdrawer;

import android.widget.Button;
import android.widget.ImageButton;

public class Localidades {
    private String nombre;
    private String descripcion;
    private Integer idLocalidad;
    private ImageButton btn_compartir;
    private Float latitud_localidades;
    private  Float lontigud_localidades;


    public Localidades(String nombre, String descripcion, Integer idLocalidad, ImageButton btn_compartir, Float latitud_localidades, Float lontigud_localidades) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idLocalidad = idLocalidad;
        this.btn_compartir = btn_compartir;
        this.latitud_localidades = latitud_localidades;
        this.lontigud_localidades = lontigud_localidades;
    }

    public ImageButton getBtn_compartir() {
        return btn_compartir;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Float getLatitud_localidades() {
        return latitud_localidades;
    }

    public void setLatitud_localidades(Float latitud_localidades) {
        this.latitud_localidades = latitud_localidades;
    }

    public Float getLontigud_localidades() {
        return lontigud_localidades;
    }

    public void setLontigud_localidades(Float lontigud_localidades) {
        this.lontigud_localidades = lontigud_localidades;
    }
}
