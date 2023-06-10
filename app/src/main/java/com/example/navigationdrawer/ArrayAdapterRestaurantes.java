package com.example.navigationdrawer;

import static android.content.Context.MODE_PRIVATE;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayAdapterRestaurantes extends ArrayAdapter<Restaurantes> {
    Activity activity;
    int idlayout;
    List <Restaurantes> dondecomer;
    HashMap<String, Integer> imagenesMap;
    SharedPreferences preferencias;
    private GoogleMap googleMap;

    static class Ref{
        TextView nombre;
        TextView descripcion;
        ImageView img_imagen;
        ImageButton btn_favoritos;
        ImageButton btn_compartir;
        MapView mapView;

    }


    public ArrayAdapterRestaurantes(@NonNull Context context, int resource, @NonNull List<Restaurantes> dondecomer) {
        super(context, resource, dondecomer);
        activity= (Activity) context;
        idlayout=resource;
        this.dondecomer=dondecomer;

        imagenesMap = new HashMap<>();
        imagenesMap.put("Casa dos xacobes", R.drawable.casa_dos_xacobes);
        imagenesMap.put("Restaurante Abrasador Gaia Medieval",R.drawable.abrasador_gaia);
        imagenesMap.put("Sicilia in Bocca",R.drawable.sicilia_in_bocca);
        imagenesMap.put("Mesón 42",R.drawable.meson_42);
        imagenesMap.put("Garum Bistro",R.drawable.garum_bistro);
        imagenesMap.put("Epoca Restaurante Peruano Fusión",R.drawable.peruano_fusion);
        imagenesMap.put("Os Padróns",R.drawable.os_padrons);
        imagenesMap.put("O Tamboril",R.drawable.tamboril);
        imagenesMap.put("O Sendeiro",R.drawable.o_sendeiro);
        imagenesMap.put("La Tita",R.drawable.la_tita);
        imagenesMap.put("Restaurante Valdevez",R.drawable.valdevez);
        imagenesMap.put("Trepia gastronomía",R.drawable.trepia_gastronomia);
        imagenesMap.put("Nikko",R.drawable.nikko);
        imagenesMap.put("Casa Obdulia",R.drawable.casa_obdulia);
        imagenesMap.put("La pepita",R.drawable.la_pepita);
        imagenesMap.put("A pedra",R.drawable.a_pedra);
        imagenesMap.put("Bar Restaurante Parrilla Argentina Caminito",R.drawable.bar_restaurante_parrilla_argentina_caminito);
        imagenesMap.put("La pizzeria di Totó",R.drawable.pizzeria_di_toto);
        imagenesMap.put("Pasarela",R.drawable.pasarela);
        imagenesMap.put("La Urbana",R.drawable.la_urbana);
        imagenesMap.put("O Xugo",R.drawable.o_xugo);
        imagenesMap.put("Mesón da Rúa",R.drawable.meson_da_rua);
        imagenesMap.put("O tentaculo",R.drawable.o_tentaculo);
        imagenesMap.put("Casa D Auga",R.drawable.casa_d_auga);
        imagenesMap.put("Restaurante Paprica",R.drawable.paprica);
        imagenesMap.put("Pepe Vieira",R.drawable.pepe_vieira);
        imagenesMap.put("Casa Solla",R.drawable.casa_solla);
        imagenesMap.put("Maruja Limón",R.drawable.maruja_limon);
        imagenesMap.put("Eirado Da Leña",R.drawable.eirado_de_lenha);
        imagenesMap.put("Rías Baixas",R.drawable.restaurante_rias_baixas);
        imagenesMap.put("O Pote",R.drawable.o_pote);
        imagenesMap.put("Casa Román",R.drawable.casa_roman);
        imagenesMap.put("Don Alex",R.drawable.don_alex);
        imagenesMap.put("Casa Marco",R.drawable.casa_marco);
        imagenesMap.put("Parrillada Milongas",R.drawable.milongas_corunha);
        imagenesMap.put("Alborada",R.drawable.alborada);
        imagenesMap.put("Taberna O Fragón",R.drawable.o_fragon);
        imagenesMap.put("Árbore da Veira",R.drawable.arbore_da_veira);
        imagenesMap.put("O Lagar da Estrella",R.drawable.o_lagar_da_estrella);
        imagenesMap.put("Bido",R.drawable.bido);
        imagenesMap.put("O Retiro da Costiña",R.drawable.retiro_da_costinha);
        imagenesMap.put("A Estación",R.drawable.a_estacion);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ArrayAdapterRestaurantes.Ref ref;
        View layout;
        preferencias=getContext().getSharedPreferences("preferencias.xml",MODE_PRIVATE);
        if(convertView==null){
            layout=activity.getLayoutInflater().inflate(idlayout,null);
            TextView nombre=layout.findViewById(R.id.tv_nombre_restaurante);
            TextView descripcion=layout.findViewById(R.id.tv_descripcion_restaurante);
            ImageView img_imagen=layout.findViewById(R.id.imageView);
            ImageButton btn_favoritos=layout.findViewById(R.id.btn_favoritos);
            ImageButton btn_compartir=layout.findViewById(R.id.btn_compartir);
            MapView mapView = layout.findViewById(R.id.mapView);

            mapView.onCreate(null);
            mapView.onResume();

            ref=new ArrayAdapterRestaurantes.Ref();
            ref.nombre=nombre;
            ref.descripcion=descripcion;
            ref.img_imagen=img_imagen;
            ref.btn_favoritos=btn_favoritos;
            ref.btn_compartir=btn_compartir;
            ref.mapView = mapView;

            layout.setTag(ref);
        }
        else{
            layout=convertView;
            ref= (ArrayAdapterRestaurantes.Ref) layout.getTag();
        }
        Restaurantes dondeComer=dondecomer.get(position);
        ref.nombre.setText(dondeComer.getNombre());
        ref.descripcion.setText(dondeComer.getDescripcion());
        ref.btn_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = dondeComer.getNombre();
                List<String> favoritos = obtenerListaFavoritos();
                if (!favoritos.contains(nombre)) {
                    favoritos.add(nombre);
                    guardarListaFavoritos(favoritos);
                    Toast.makeText(getContext(), nombre+" se ha añadido a favoritos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "El restaurante ya está en favoritos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ref.btn_compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = dondeComer.getNombre();
                String descripcion = dondeComer.getDescripcion();
                String mensaje = texto + "\n" + descripcion;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                activity.startActivity(Intent.createChooser(intent, "Compartir con"));
            }
        });

        Integer imagenId = imagenesMap.get(dondeComer.getNombre());
        if (imagenId != null) {
            ref.img_imagen.setImageResource(imagenId);
        } else {
            ref.img_imagen.setImageResource(0);
        }
        ref.mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap map) {
                googleMap = map; // Almacena la referencia de GoogleMap en una variable de instancia

                // Obtiene la latitud y longitud
                double latitud = dondeComer.getLatitud();
                double longitud = dondeComer.getLontigud();

                LatLng restauranteLocation = new LatLng(latitud, longitud);
                googleMap.addMarker(new MarkerOptions().position(restauranteLocation));

                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restauranteLocation, 12));
            }
        });


        return layout;
    }
    private List<String> obtenerListaFavoritos() {
        String favoritosJson = preferencias.getString("favoritos", "");
        List<String> favoritos = new ArrayList<>();
        if (!favoritosJson.isEmpty()) {
            favoritos = new Gson().fromJson(favoritosJson, new TypeToken<List<String>>(){}.getType());
        }
        return favoritos;
    }

    private void guardarListaFavoritos(List<String> favoritos) {
        String favoritosJson = new Gson().toJson(favoritos);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString("favoritos", favoritosJson);
        editor.apply();
    }


}
