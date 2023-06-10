package com.example.navigationdrawer.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.TurismoGaliciaDB;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
SQLiteDatabase db;
Cursor cursor;
SharedPreferences preferencias;
OnLocalidadSeleccionadaListener listener;
int localidadId;
ImageButton que_ver;
ImageButton donde_comer;
Spinner spinnerLocalidad;
private List<String> lugares_galicia = null;
TextView tv_que_ver;
TextView tv_donde_comer;
ImageButton btn_favoritos;

    public interface OnLocalidadSeleccionadaListener {
        void onLocalidadSeleccionada(String localidadNombre);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnLocalidadSeleccionadaListener) context;

        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " debe implementar OnLocalidadSeleccionadaListener");
        }
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        que_ver=root.findViewById(R.id.que_ver);
        donde_comer=root.findViewById(R.id.donde_comer);
        spinnerLocalidad = root.findViewById(R.id.spinnerLocalidad);
        tv_que_ver=root.findViewById(R.id.tv_que_ver);
        tv_donde_comer=root.findViewById(R.id.tv_donde_comer);
        btn_favoritos=root.findViewById(R.id.favoritos);

        preferencias=getActivity().getSharedPreferences("preferencias.xml",MODE_PRIVATE);

        TurismoGaliciaDB dbHelper = new TurismoGaliciaDB(getActivity());
        db = dbHelper.abreBD();
        if (lugares_galicia == null) {
            lugares_galicia = get_lugares_galicia();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, lugares_galicia);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLocalidad.setAdapter(adapter);
        int lastSelectedPosition = preferencias.getInt("last_selected_position", 0);
        spinnerLocalidad.setSelection(lastSelectedPosition);
        spinnerLocalidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLocalidad=lugares_galicia.get(position);
                int selectedLocalidadId = getLocalidadId(selectedLocalidad);
                SharedPreferences.Editor editor = preferencias.edit();
                listener.onLocalidadSeleccionada(selectedLocalidad);
                editor.putInt("id_localidad",selectedLocalidadId);
                editor.putString("localidad",selectedLocalidad);
                editor.putInt("last_selected_position", position);
                editor.apply();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        tv_que_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString("fragmentoDestino", "fragmento2");
                navController.navigate(R.id.fragmento2, bundle);
            }
        });

        que_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString("fragmentoDestino", "fragmento2");
                navController.navigate(R.id.fragmento2, bundle);
            }
        });
        donde_comer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.fragmento3);
            }
        });
        tv_donde_comer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString("fragmentoDestino", "fragmento2");
                navController.navigate(R.id.fragmento3, bundle);
            }
        });

        btn_favoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString("fragmentoDestino", "fragmento5");
                navController.navigate(R.id.fragmento5, bundle);
            }
        });

        return root;



    }


    public List<String> get_lugares_galicia() {
        List<String> localidades = new ArrayList<>();
        String query = "SELECT * FROM localidades";
        cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                String localidad = cursor.getString(cursor.getColumnIndexOrThrow("localidad"));
                localidades.add(localidad);
            } while (cursor.moveToNext());
        }
        return localidades;
    }
    private int getLocalidadId(String localidad) {
        String query = "SELECT id_localidad FROM localidades WHERE localidad = ?";
        Cursor cursor = db.rawQuery(query, new String[]{localidad});


        if (cursor.moveToFirst()) {
            localidadId = cursor.getInt(cursor.getColumnIndexOrThrow("id_localidad"));
        }

        cursor.close();

        return localidadId;
    }




        @Override
    public void onPause() {
        super.onPause();


    }
}