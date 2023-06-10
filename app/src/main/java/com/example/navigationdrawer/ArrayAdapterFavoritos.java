package com.example.navigationdrawer;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ArrayAdapterFavoritos extends ArrayAdapter<LugaresFavoritos> {
    Activity activity;
    int idlayout;
    List <LugaresFavoritos> lugaresFavoritos;
    HashMap<String, Integer> imagenesMap;
    SharedPreferences preferencias;
    static class Ref{
        TextView nombre;
        TextView descripcion;
        ImageView img_imagen;
        ImageButton btn_eliminar_favoritos;

    }
    public ArrayAdapterFavoritos(@NonNull Context context, int resource, @NonNull List<LugaresFavoritos> lugaresFavoritos) {
        super(context, resource, lugaresFavoritos);
        activity= (Activity) context;
        idlayout=resource;
        this.lugaresFavoritos=lugaresFavoritos;

        imagenesMap = new HashMap<>();
        // Imagenes lugares
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

        // Imagenes restaurantes
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
        ArrayAdapterFavoritos.Ref ref;
        View layout;
        preferencias=getContext().getSharedPreferences("preferencias.xml",MODE_PRIVATE);
        if(convertView==null){
            layout=activity.getLayoutInflater().inflate(idlayout,null);
            TextView nombre=layout.findViewById(R.id.tv_nombre_favoritos);
            TextView descripcion=layout.findViewById(R.id.tv_descripcion_favoritos);
            ImageView img_imagen=layout.findViewById(R.id.imagen_favoritos);
            ImageButton btn_eliminar_favoritos=layout.findViewById(R.id.btn_eliminar_favoritos);

            ref=new ArrayAdapterFavoritos.Ref();
            ref.nombre=nombre;
            ref.descripcion=descripcion;
            ref.img_imagen=img_imagen;
            ref.btn_eliminar_favoritos=btn_eliminar_favoritos;

            layout.setTag(ref);
        }
        else{
            layout=convertView;
            ref= (ArrayAdapterFavoritos.Ref) layout.getTag();
        }
        LugaresFavoritos favoritos=lugaresFavoritos.get(position);
        ref.nombre.setText(favoritos.getNombre());
        ref.descripcion.setText(favoritos.getDescripcion());
        Integer imagenId = imagenesMap.get(favoritos.getNombre());
        if (imagenId != null) {
            ref.img_imagen.setImageResource(imagenId);
        } else {
            ref.img_imagen.setImageResource(0);
        }
        ref.btn_eliminar_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LugaresFavoritos lugares_favoritos = lugaresFavoritos.get(position);
                String nombre = lugares_favoritos.getNombre();
                List<String> favoritos = obtenerListaFavoritos();
                favoritos.remove(nombre);
                guardarListaFavoritos(favoritos);
                lugaresFavoritos.remove(position);
                notifyDataSetChanged();
                Toast.makeText(getContext(), nombre+" se ha borrado de favoritos", Toast.LENGTH_SHORT).show();
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
