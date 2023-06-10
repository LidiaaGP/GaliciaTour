package com.example.navigationdrawer.ui.fragmento2;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawer.ArrayAdapterLocalidades;
import com.example.navigationdrawer.Localidades;
import com.example.navigationdrawer.TurismoGaliciaDB;
import com.example.navigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class Fragmento2 extends Fragment{
    ListView lisviewdatoslocalidades;
    ArrayAdapterLocalidades adapterLocalidades;
    int localidadId;

    SQLiteDatabase db;
    SharedPreferences preferencias;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_fragmento2, container, false);

        TurismoGaliciaDB dbHelper = new TurismoGaliciaDB(getActivity());
        db = dbHelper.abreBD();

        List<Localidades> localidades = new ArrayList<>();
        preferencias=getActivity().getSharedPreferences("preferencias.xml",MODE_PRIVATE);
        localidadId = preferencias.getInt("id_localidad", -1);
        localidades = getLugaresdeInteres();


        adapterLocalidades = new ArrayAdapterLocalidades(getActivity(), R.layout.item_listview_datos, localidades);
        lisviewdatoslocalidades = root.findViewById(R.id.listViewDatosLocalidades);
        lisviewdatoslocalidades.setAdapter(adapterLocalidades);

        return root;
    }


    public List<Localidades> getLugaresdeInteres() {
        List<Localidades> localidades = new ArrayList<>();

        String get_localidades = "SELECT * FROM lugares_interes WHERE id_localidad = " + localidadId;
        Cursor cursor = db.rawQuery(get_localidades, null);
        if (cursor.moveToFirst()) {

            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                Integer idLocalidad = cursor.getInt(cursor.getColumnIndexOrThrow("id_localidad"));
                Button btn_ver_mapa = new Button(getContext());
                ImageButton btn_compartir=new ImageButton(getContext());
                localidades.add(new Localidades(nombre, descripcion, idLocalidad, btn_ver_mapa,btn_compartir));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return localidades;
    }



}