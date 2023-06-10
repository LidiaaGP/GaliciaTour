package com.example.navigationdrawer;

import android.widget.Button;
import android.widget.ImageButton;

public class Localidades {
    private String nombre;
    private String descripcion;
    private Integer idLocalidad;
    private Button btn_ver_mapa;
    private ImageButton btn_compartir;

    public Localidades(String nombre, String descripcion, Integer idLocalidad, Button btn_ver_mapa, ImageButton btn_compartir) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idLocalidad = idLocalidad;
        this.btn_ver_mapa = btn_ver_mapa;
        this.btn_compartir = btn_compartir;
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


}
