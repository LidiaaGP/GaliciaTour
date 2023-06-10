package com.example.navigationdrawer;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.navigation.NavigationView;

public class UtilidadesNavigationDrawer {
    public static void irAlFragmentoAnterior(MainActivity ma) {
        NavController navController =   Navigation.findNavController(ma, R.id.nav_host_fragment);
        if (navController.getCurrentBackStackEntry()!=null && navController.getCurrentBackStackEntry().getDestination().getId()!=R.id.nav_home) {
            navController.popBackStack();
        }
    }

    public static void cambiarCabecera(NavigationView navigationView, int idRecursoImagen, String textoCabecera1, String textCabecera2) {
        TextView tv_cabecera1 = ((TextView)(navigationView.getHeaderView(0).findViewById(R.id.tv_cabecera1)));
        tv_cabecera1.setText(textoCabecera1);

        TextView tv_cabecera2 = ((TextView)(navigationView.getHeaderView(0).findViewById(R.id.tv_cabecera2)));
        tv_cabecera2.setText(textCabecera2);

        ImageView imageViewCabecera = ((ImageView)(navigationView.getHeaderView(0).findViewById(R.id.imageViewCabecera)));
        imageViewCabecera.setImageResource(idRecursoImagen);
    }
}
