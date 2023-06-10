package com.example.navigationdrawer;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class Rutas {
    String nombre_ruta;
    String descripcion_ruta;
    String dificultad;
    String tiempo_transcurrido;
    String distancia;
    private List<LatLng> coordenadas;

    public Rutas(String nombre_ruta, String descripcion_ruta, String dificultad, String tiempo_transcurrido, String distancia) {
        this.nombre_ruta = nombre_ruta;
        this.descripcion_ruta = descripcion_ruta;
        this.dificultad = dificultad;
        this.tiempo_transcurrido = tiempo_transcurrido;
        this.distancia = distancia;
        this.coordenadas = new ArrayList<>();
    }

    public List<LatLng> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<LatLng> coordenadas) {
        this.coordenadas = coordenadas;
    }
    public void addCoordenada(LatLng coordenada) {
        coordenadas.add(coordenada);
    }

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public String getDescripcion_ruta() {
        return descripcion_ruta;
    }

    public void setDescripcion_ruta(String descripcion_ruta) {
        this.descripcion_ruta = descripcion_ruta;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTiempo_transcurrido() {
        return tiempo_transcurrido;
    }

    public void setTiempo_transcurrido(String tiempo_transcurrido) {
        this.tiempo_transcurrido = tiempo_transcurrido;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

}
