package com.example.navigationdrawer.ui.fragmento3;

import static android.content.Context.MODE_PRIVATE;

import android.Manifest;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawer.ArrayAdapterRestaurantes;
import com.example.navigationdrawer.Localidades;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.Restaurantes;
import com.example.navigationdrawer.TurismoGaliciaDB;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;


public class Fragmento3 extends Fragment {
    private static final String TAG = "MainActivity";
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    ListView listviewdatosRestaurantes;
    ArrayAdapterRestaurantes adapterRestaurantes;
    int localidadId;

    SQLiteDatabase db;
    SharedPreferences preferencias;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_fragmento3, container, false);


        TurismoGaliciaDB dbHelper = new TurismoGaliciaDB(getActivity());
        db = dbHelper.abreBD();

        List<Restaurantes> restaurantes = new ArrayList<>();
        preferencias=getActivity().getSharedPreferences("preferencias.xml",MODE_PRIVATE);

        localidadId = preferencias.getInt("id_localidad", -1);

        restaurantes = get_restaurantes();


        adapterRestaurantes = new ArrayAdapterRestaurantes(getActivity(),R.layout.item_listview_datos_restaurantes,restaurantes);
        listviewdatosRestaurantes = root.findViewById(R.id.listviewDatosRestaurantes);
        listviewdatosRestaurantes.setAdapter(adapterRestaurantes);

        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }

        PackageManager packageManager = requireContext().getPackageManager();
        String permission = Manifest.permission.ACCESS_FINE_LOCATION;  // Permiso de ubicación precisa
        int result = packageManager.checkPermission(permission, requireContext().getPackageName());

        if (result == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "El permiso de ubicación está otorgado");
        } else {
            Log.d(TAG, "El permiso de ubicación no está otorgado");
        }

        return root;
    }


    public List<Restaurantes> get_restaurantes() {
        List<Restaurantes> restaurantes = new ArrayList<>();

        String get_restaurantes = "SELECT * FROM donde_comer WHERE id_localidad = " + localidadId;
        Cursor cursor = db.rawQuery(get_restaurantes, null);
        ImageButton btn_compartir=new ImageButton(getContext());
        if (cursor.moveToFirst()) {

            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre_restaurante"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion_restaurante"));
                Integer idLocalidad = cursor.getInt(cursor.getColumnIndexOrThrow("id_localidad"));
                Float latitud=cursor.getFloat(cursor.getColumnIndexOrThrow("latitud"));
                Float longitud=cursor.getFloat(cursor.getColumnIndexOrThrow("longitud"));
                restaurantes.add(new Restaurantes(nombre,descripcion,idLocalidad,btn_compartir,latitud,longitud));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return restaurantes;
    }


}