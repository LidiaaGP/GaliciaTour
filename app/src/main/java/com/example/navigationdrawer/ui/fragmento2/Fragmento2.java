package com.example.navigationdrawer.ui.fragmento2;

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

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawer.ArrayAdapterLocalidades;
import com.example.navigationdrawer.Localidades;
import com.example.navigationdrawer.TurismoGaliciaDB;
import com.example.navigationdrawer.R;

import java.util.ArrayList;
import java.util.List;

public class Fragmento2 extends Fragment{
    private static final String TAG = "MainActivity";
    private static final int REQUEST_LOCATION_PERMISSION = 1;
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


    public List<Localidades> getLugaresdeInteres() {
        List<Localidades> localidades = new ArrayList<>();

        String get_localidades = "SELECT * FROM lugares_interes WHERE id_localidad = " + localidadId;
        Cursor cursor = db.rawQuery(get_localidades, null);
        if (cursor.moveToFirst()) {

            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
                String descripcion = cursor.getString(cursor.getColumnIndexOrThrow("descripcion"));
                Integer idLocalidad = cursor.getInt(cursor.getColumnIndexOrThrow("id_localidad"));
                Float latitud=cursor.getFloat(cursor.getColumnIndexOrThrow("latitud"));
                Float longitud=cursor.getFloat(cursor.getColumnIndexOrThrow("longitud"));
                ImageButton btn_compartir=new ImageButton(getContext());
                localidades.add(new Localidades(nombre, descripcion, idLocalidad,btn_compartir,latitud,longitud));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return localidades;
    }



}