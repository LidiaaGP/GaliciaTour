package com.example.navigationdrawer;

import android.widget.ImageButton;

public class LugaresFavoritos {

    private String nombre;
    private String descripcion;
    private Integer idLocalidad;
    private ImageButton btn_eliminar_favoritos;

    public LugaresFavoritos(String nombre, String descripcion, Integer idLocalidad,ImageButton btn_eliminar_favoritos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idLocalidad = idLocalidad;
        this.btn_eliminar_favoritos=btn_eliminar_favoritos;
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
