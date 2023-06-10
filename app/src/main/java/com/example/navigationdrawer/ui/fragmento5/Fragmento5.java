package com.example.navigationdrawer.ui.fragmento5;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.navigationdrawer.ArrayAdapterFavoritos;
import com.example.navigationdrawer.Localidades;
import com.example.navigationdrawer.LugaresFavoritos;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.TurismoGaliciaDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Fragmento5 extends Fragment {

    ListView listviewdatosLugaresFavoritos;
    ArrayAdapterFavoritos adapterLugaresFavoritos;
    int localidadId;

    SQLiteDatabase db;
    SharedPreferences preferencias;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fragmento5, container, false);

        TurismoGaliciaDB dbHelper = new TurismoGaliciaDB(getActivity());
        db = dbHelper.abreBD();

        List<LugaresFavoritos> lugaresFavoritos = new ArrayList<>();
        preferencias=getActivity().getSharedPreferences("preferencias.xml",MODE_PRIVATE);

        localidadId = preferencias.getInt("id_localidad", -1);

        List<String> favoritos = obtenerListaFavoritos();


        lugaresFavoritos = get_lugares_favoritos(favoritos);


        adapterLugaresFavoritos = new ArrayAdapterFavoritos(getActivity(),R.layout.item_listview_datos_favoritos,lugaresFavoritos);
        listviewdatosLugaresFavoritos = root.findViewById(R.id.listview_favoritos);
        listviewdatosLugaresFavoritos.setAdapter(adapterLugaresFavoritos);
        return  root;

    }
    private List<String> obtenerListaFavoritos() {
        String favoritosJson = preferencias.getString("favoritos", "");
        List<String> favoritos = new ArrayList<>();
        if (!favoritosJson.isEmpty()) {
            favoritos = new Gson().fromJson(favoritosJson, new TypeToken<List<String>>() {}.getType());
        }
        return favoritos;
    }
    public List<LugaresFavoritos> get_lugares_favoritos(List<String> favoritos) {
        List<LugaresFavoritos> lugaresFavoritos = new ArrayList<>();
        String get_restaurantes = "SELECT * FROM donde_comer WHERE id_localidad = " + localidadId;
        Cursor cursor = db.rawQuery(get_restaurantes, null);
        ImageButton btn_eliminar_favoritos=new ImageButton(getContext());
        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre_restaurante"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion_restaurante"));
                Integer idLocalidad = cursor.getInt(cursor.getColumnIndexOrThrow("id_localidad"));
                if(favoritos.contains(nombre)){
                    lugaresFavoritos.add(new LugaresFavoritos(nombre,descripcion,idLocalidad,btn_eliminar_favoritos));
                }
            } while (cursor.moveToNext());
        }
        String get_localidades = "SELECT * FROM lugares_interes WHERE id_localidad = " + localidadId;
        cursor = db.rawQuery(get_localidades, null);
        if (cursor.moveToFirst()) {

            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                Integer idLocalidad = cursor.getInt(cursor.getColumnIndexOrThrow("id_localidad"));
                if(favoritos.contains(nombre)){
                    lugaresFavoritos.add(new LugaresFavoritos(nombre,descripcion,idLocalidad,btn_eliminar_favoritos));
                }
            } while (cursor.moveToNext());
        }

        cursor.close();

        return lugaresFavoritos;
    }



}