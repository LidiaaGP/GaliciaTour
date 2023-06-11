package com.example.navigationdrawer;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayAdapterLocalidades extends ArrayAdapter<Localidades> {
    Activity activity;
    int idlayout;
    List <Localidades> localidades;
    HashMap<String, Integer> imagenesMap;
    SharedPreferences preferencias;
    private GoogleMap googleMap;
    static class Ref{
        TextView nombre;
        TextView descripcion;
        ImageView img_imagen;
        ImageButton btn_compartir;
        ImageButton btn_favoritos;
        TextView tv_latitud_localidades;
        TextView tv_longitud_Localidades;
        MapView mapView_localidades;


    }

    public ArrayAdapterLocalidades(@NonNull Context context, int resource, @NonNull List<Localidades> localidades) {
        super(context, resource, localidades);
        activity= (Activity) context;
        idlayout=resource;
        this.localidades=localidades;

        imagenesMap = new HashMap<>();
        imagenesMap.put("Castillo de San Sebastián en Vigo", R.drawable.san_sebastian);
        imagenesMap.put("Museo Catedralicio de Santiago de Compostela", R.drawable.museo_santiago);
        imagenesMap.put("Sireno de Vigo y la Puerta del Sol", R.drawable.sireno);
        imagenesMap.put("El Puerto de Vigo",R.drawable.puerto_vigo);
        imagenesMap.put("Concatedral de Santa María de Vigo",R.drawable.santa_maria);
        imagenesMap.put("Islas Cíes",R.drawable.islas_cies);
        imagenesMap.put("VigoZoo",R.drawable.vigozoo);
        imagenesMap.put("Playa de Samil",R.drawable.playa_samil);
        imagenesMap.put("Playa de O Vao",R.drawable.playa_o_vao);
        imagenesMap.put("Playa de Tombo do Gato",R.drawable.playa_tombo_do_gato);

        imagenesMap.put("Catedral de Santiago de Compostela", R.drawable.catedral_santiago);
        imagenesMap.put("Mercado de Abastos en Santiago de Compostela", R.drawable.abastos);
        imagenesMap.put("Universidad de Santiago de Compostela (USC)",R.drawable.usc);
        imagenesMap.put("Monte do Gozo",R.drawable.monte_do_gozo);
        imagenesMap.put("Parque de la Alameda",R.drawable.parque_alameda);
        imagenesMap.put("Parque de Belvís",R.drawable.parque_belvis);
        imagenesMap.put("Seminario Mayor",R.drawable.seminario_mayor);
        imagenesMap.put("Seminario Menor",R.drawable.seminario_menor);
        imagenesMap.put("Ruinas de Santo Domingo",R.drawable.ruinas_santo_domingo);

        imagenesMap.put("Muralla Romana de Lugo",R.drawable.muralla_lugo);
        imagenesMap.put("Catedral de Lugo",R.drawable.catedral_lugo);
        imagenesMap.put("Plaza Mayor de Lugo",R.drawable.plaza_mayor_lugo);
        imagenesMap.put("Bosque da Fervenza en Lugo",R.drawable.bosque_fervenza);
        imagenesMap.put("Plaza de Santa María",R.drawable.plaza_santa_maria);
        imagenesMap.put("Playa de las Catedrales",R.drawable.playa_catedrales);
        imagenesMap.put("Casa dos Mosaicos",R.drawable.casa_dos_mosaicos);
        imagenesMap.put("Museo Universitario «A Domus do Mitreo»",R.drawable.domus_do_mitreo);
        imagenesMap.put("Cañón y riberas del Sil",R.drawable.canhon_sil);
        imagenesMap.put("Santuario de la Virgen Peregrina",R.drawable.santuario_virgen_peregrina);
        imagenesMap.put("Plaza de la Herrería",R.drawable.casa_ciencias);
        imagenesMap.put("Basílica de Santa María la Mayor",R.drawable.santa_maria_la_mayor);
        imagenesMap.put("Playa de Castiñeiras",R.drawable.playa_castinheiras);
        imagenesMap.put("Convento de San Francisco",R.drawable.convento_san_francisco);
        imagenesMap.put("Con Negro",R.drawable.con_negro);

        imagenesMap.put("Torre de Hércules",R.drawable.torre_hercules);
        imagenesMap.put("Casa de las Ciencias en A Coruña",R.drawable.casa_ciencias);
        imagenesMap.put("Aquarium Finisterrae",R.drawable.aquarium_finisterrae);
        imagenesMap.put("Domus-Casa del Hombre en A Coruña",R.drawable.domus);
        imagenesMap.put("El Castillo de Santo Antón",R.drawable.castillo_san_anton);
        imagenesMap.put("Plaza de María Pita",R.drawable.plaza_maria_pita);
        imagenesMap.put("Playa de Riazor",R.drawable.playa_riazor);
        imagenesMap.put("Monte de San Pedro",R.drawable.monte_san_pedro);
        imagenesMap.put("Edificio Castelao",R.drawable.edificio_castelao);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ArrayAdapterLocalidades.Ref ref;
        View layout;
        preferencias=getContext().getSharedPreferences("preferencias.xml",MODE_PRIVATE);
        if(convertView==null){
            layout=activity.getLayoutInflater().inflate(idlayout,null);
            TextView nombre=layout.findViewById(R.id.tv_nombre);
            TextView descripcion=layout.findViewById(R.id.tv_descripcion);
            ImageView img_imagen=layout.findViewById(R.id.img_imagen);
            ImageButton btn_compartir=layout.findViewById(R.id.btn_compartir);
            ImageButton btn_favoritos=layout.findViewById(R.id.btn_favoritos);
            TextView tv_latitud_localidades=layout.findViewById(R.id.tv_latitud_localidades);
            TextView tv_longitud_localidades=layout.findViewById(R.id.tv_longitud_localidades);
            MapView mapView_localidades = layout.findViewById(R.id.mapView_localidades);
            ref=new ArrayAdapterLocalidades.Ref();
            mapView_localidades.onCreate(null);
            mapView_localidades.onResume();
            ref.nombre=nombre;
            ref.descripcion=descripcion;
            ref.img_imagen=img_imagen;
            ref.btn_compartir=btn_compartir;
            ref.btn_favoritos=btn_favoritos;
            ref.mapView_localidades = mapView_localidades;
            ref.tv_latitud_localidades=tv_latitud_localidades;
            ref.tv_longitud_Localidades=tv_longitud_localidades;

            layout.setTag(ref);
        }
        else{
            layout=convertView;
            ref= (ArrayAdapterLocalidades.Ref) layout.getTag();
        }
        Localidades localidad=localidades.get(position);
        ref.nombre.setText(localidad.getNombre());
        ref.descripcion.setText(localidad.getDescripcion());
        Integer imagenId = imagenesMap.get(localidad.getNombre());
        if (imagenId != null) {
            ref.img_imagen.setImageResource(imagenId);
        } else {
            ref.img_imagen.setImageResource(0);
        }
        String latitudStr = String.valueOf(localidad.getLatitud_localidades());
        ref.tv_latitud_localidades.setText(latitudStr);
        String longitudStr = String.valueOf(localidad.getLontigud_localidades());
        ref.tv_longitud_Localidades.setText(longitudStr);
        ref.btn_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = localidad.getNombre();
                List<String> favoritos = obtenerListaFavoritos();
                if (!favoritos.contains(nombre)) {
                    favoritos.add(nombre);
                    guardarListaFavoritos(favoritos);
                    Toast.makeText(getContext(), nombre+" se ha añadido a favoritos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "El lugar ya está en favoritos", Toast.LENGTH_SHORT).show();
                }
            }
        });

         ref.btn_compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = localidad.getNombre();
                String descripcion = localidad.getDescripcion();

                String mensaje = texto + "\n" + descripcion;

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, mensaje);
                activity.startActivity(Intent.createChooser(intent, "Compartir con"));

            }
        });
        ref.mapView_localidades.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap map) {
                googleMap = map; // Almacena la referencia de GoogleMap en una variable de instancia

                // Obtiene la latitud y longitud
                double latitud = localidad.getLatitud_localidades();
                double longitud = localidad.getLontigud_localidades();

                LatLng restauranteLocation = new LatLng(latitud, longitud);
                googleMap.addMarker(new MarkerOptions().position(restauranteLocation));

                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restauranteLocation, 30));


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

    private void abrirMapa(String nombreLocalidad) {
        String uri = "geo:0,0?q=" + nombreLocalidad;
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        mapIntent.setPackage("com.google.android.apps.maps");

        if (mapIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(mapIntent);
        } else {
            Toast.makeText(activity, "No se encontró la aplicación de Google Maps", Toast.LENGTH_SHORT).show();
        }
    }

}
