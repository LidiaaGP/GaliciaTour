package com.example.navigationdrawer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

public class ArrayAdapterRutas extends ArrayAdapter<Rutas> {
    private Context context;
    private int layoutResourceId;
    private List<Rutas> rutasList;

    public ArrayAdapterRutas(Context context, int layoutResourceId, List<Rutas> rutasList) {
        super(context, layoutResourceId, rutasList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.rutasList = rutasList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(layoutResourceId, parent, false);

        TextView tv_nombre_ruta = row.findViewById(R.id.tv_nombre_ruta);
        TextView tv_descripcion_ruta = row.findViewById(R.id.tv_descripcion_ruta);
        TextView tv_dificultad = row.findViewById(R.id.tv_dificultad);
        TextView tv_tiempo_transcurrido = row.findViewById(R.id.tv_tiempo_transcurrido);
        TextView tv_distancia = row.findViewById(R.id.tv_distancia);
        MapView mapView = row.findViewById(R.id.mapView);

        Rutas ruta = rutasList.get(position);

        tv_nombre_ruta.setText(ruta.getNombre_ruta());
        tv_descripcion_ruta.setText(ruta.getDescripcion_ruta());
        tv_dificultad.setText(ruta.getDificultad());
        tv_tiempo_transcurrido.setText(ruta.getTiempo_transcurrido());
        tv_distancia.setText(ruta.getDistancia());

        mapView.onCreate(null);
        mapView.onResume();

        return row;

    }
    private void configurarMapa(MapView mapView, List<LatLng> coordenadas) {
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                PolylineOptions polylineOptions = new PolylineOptions();
                polylineOptions.addAll(coordenadas);
                polylineOptions.color(Color.RED);
                googleMap.addPolyline(polylineOptions);

                // Mover la cámara del mapa para que muestre todas las coordenadas
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (LatLng coordenada : coordenadas) {
                    builder.include(coordenada);
                }
                LatLngBounds bounds = builder.build();
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
            }
        });
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



         Rutas ruta = rutasList.get(position);
                LatLng ubicacion = ruta.getUbicacion();
                googleMap.addMarker(new MarkerOptions().position(ubicacion));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15f));
    }
 */
}
