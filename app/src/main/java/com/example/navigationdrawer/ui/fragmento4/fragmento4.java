package com.example.navigationdrawer.ui.fragmento4;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.navigationdrawer.ArrayAdapterLocalidades;
import com.example.navigationdrawer.ArrayAdapterRutas;
import com.example.navigationdrawer.Localidades;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Rutas;
import com.example.navigationdrawer.TurismoGaliciaDB;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;


public class fragmento4 extends Fragment{

    ListView listview_rutas;
    ArrayAdapterRutas adapterRutas;
    int localidadId;

    SQLiteDatabase db;
    SharedPreferences preferencias;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_fragmento4, container, false);

        TurismoGaliciaDB dbHelper = new TurismoGaliciaDB(getActivity());
        db = dbHelper.abreBD();

        List<Rutas> rutas = new ArrayList<>();
        preferencias=getActivity().getSharedPreferences("preferencias.xml",MODE_PRIVATE);
        localidadId = preferencias.getInt("id_localidad", -1);
        rutas = getRutas();


        adapterRutas = new ArrayAdapterRutas(getActivity(), R.layout.item_listview_datos_rutas, rutas);
        listview_rutas = root.findViewById(R.id.listview_rutas);
        listview_rutas.setAdapter(adapterRutas);

        return root;

    }
    public List<Rutas> getRutas() {
        List<Rutas> rutas = new ArrayList<>();

        String get_rutas = "SELECT * FROM rutas WHERE id_localidad = " + localidadId;
        Cursor cursor = db.rawQuery(get_rutas, null);
        if (cursor.moveToFirst()) {
            do {
                String nombre_ruta = cursor.getString(cursor.getColumnIndexOrThrow("nombre_ruta"));
                String descripcion_ruta = cursor.getString(cursor.getColumnIndexOrThrow("descripcion_ruta"));
                String dificultad = cursor.getString(cursor.getColumnIndexOrThrow("dificultad"));
                String tiempo_transcurrido = cursor.getString(cursor.getColumnIndexOrThrow("tiempo_transcurrido"));
                String distancia = cursor.getString(cursor.getColumnIndexOrThrow("distancia"));


                Rutas ruta = new Rutas(nombre_ruta,descripcion_ruta,dificultad,tiempo_transcurrido,distancia);

                if (nombre_ruta.equals("nombre_de_la_ruta")) {
                    List<LatLng> coordenadas = new ArrayList<>();
                    coordenadas.add(new LatLng(42.87098672745762, -8.54427274604173));
                    coordenadas.add(new LatLng(42.838967572127835, -8.591034700608251));

                }
                else{
                    Toast.makeText(getContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
                rutas.add(ruta);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return rutas;
    }
   /*
    @Override
    public void onMapReady(@NonNull GoogleMap map) {

          googleMap = map;


        // Añadir marcadores
        LatLng point1 = new LatLng(42.1234, -8.5678);
        googleMap.addMarker(new MarkerOptions().position(point1).title("Punto de inicio"));

        LatLng point2 = new LatLng(42.2345, -8.6789);
        googleMap.addMarker(new MarkerOptions().position(point2).title("Punto de interés"));

        // Dibujar polilínea
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(point1, point2)
                .color(Color.RED)
                .width(5f);
        Polyline polyline = googleMap.addPolyline(polylineOptions);
         */


    }
    /*
      @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
     */

