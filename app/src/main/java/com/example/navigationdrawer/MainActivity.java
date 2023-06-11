package com.example.navigationdrawer;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigationdrawer.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnLocalidadSeleccionadaListener{
    private AppBarConfiguration mAppBarConfiguration;
    private boolean pulsadoDosVecesAtrasParaSalir = false;
    private SharedPreferences preferencias;
    private String localidad;
    private static final String TAG = "MainActivity";
    private static final int REQUEST_LOCATION_PERMISSION = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        /* Barra de acción */
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /* Botón flotante */



        DrawerLayout drawer = findViewById(R.id.drawer_layout); // Contenedor principal que incluye toda la interfaz con el menú deslizante
        NavigationView navigationView = findViewById(R.id.nav_view); // Menú deslizante

        // IDs fragments(mobile_navigation.xml) y eb menu deslizante(activity_main_drawer.xml)
        // a tener en cuenta para visualizar en la barra de acción
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.fragmento2, R.id.fragmento3,R.id.fragmento5)
                .setOpenableLayout(drawer)
                .build();

        /* Enlazamos cargador de fragments del menú deslizante (NavController) con barra de acción */
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        preferencias = getSharedPreferences("preferencias.xml", MODE_PRIVATE);
        localidad = preferencias.getString("localidad", "");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                NavigationView navigationView = findViewById(R.id.nav_view);
                // Buscamos id menú/fragmento Actual
                long idMenuPrevioSeleccionado = -1;
                for (int i = 0; i < navigationView.getMenu().size(); i++) {
                    if (navigationView.getMenu().getItem(i).isChecked()) {
                        idMenuPrevioSeleccionado = navigationView.getMenu().getItem(i).getItemId();

                    }
                }

                if (menuItem.getItemId() == R.id.nav_salir) {
                    finish();
                } else {
                    Bundle argumentos = null;
                    // Ejemplo para enviar argumentos a un fragmento
                    if (idMenuPrevioSeleccionado == R.id.nav_home && menuItem.getItemId() == R.id.fragmento2) {
                        argumentos = new Bundle();
                        argumentos.putString("dato", "X-100");
                    }


                    NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
                    NavOptions.Builder opcionesBuilder = new NavOptions.Builder();
                    opcionesBuilder.setPopUpTo(menuItem.getItemId(), true);
                    navController.navigate(menuItem.getItemId(), argumentos, opcionesBuilder.build());

                    ((DrawerLayout) findViewById(R.id.drawer_layout)).closeDrawers();
                }

                return true;
            }
        });
        if(localidad.equals("Santiago de Compostela")){
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_santiago, localidad, localidad);
        }
        else if (localidad.equals("Vigo")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_vigo, localidad, localidad);
        }
        else if (localidad.equals("Lugo")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_lugo, localidad, localidad);
        }
        else if (localidad.equals("Pontevedra")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_pontevedra, localidad, localidad);
        }
        else if (localidad.equals("A Coruña")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_corunha, localidad, localidad);
        }




        // Eventos del menú deslizante
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                // Menú deslizante abierto
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                // Menú deslizante cerrado
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }



    /* Menú principal */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {  // Manejo del historial de framentos
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    // Confirmacion de cierre de aplicación
    @Override
    public void onBackPressed() {
        // Fragmentos en la pila de fragmentos
        int count = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment).getChildFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            if (pulsadoDosVecesAtrasParaSalir) { // Ha confirmado con 2 pulsaciones segidas que quiere salir
                super.onBackPressed(); // el codido heredado cerrará la aplicación
                return;
            }

            pulsadoDosVecesAtrasParaSalir = true;
            Toast.makeText(getApplicationContext(), "Por favor, presione ATRAS otra vez para SALIR", Toast.LENGTH_LONG).show();

            new TareaCancelaSalidaApp().execute();

        } else {
            NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
            navController.popBackStack();
        }

    }

    @Override
    public void onLocalidadSeleccionada(String localidadNombre) {
        NavigationView navigationView = findViewById(R.id.nav_view);
        if(localidadNombre.equals("Santiago de Compostela")){
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_santiago, localidadNombre, localidadNombre);
        }
        else if (localidadNombre.equals("Vigo")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_vigo, localidadNombre, localidadNombre);
        }
        else if (localidadNombre.equals("Lugo")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_lugo, localidadNombre, localidadNombre);
        }
        else if (localidadNombre.equals("Pontevedra")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_pontevedra, localidadNombre, localidadNombre);
        }
        else if (localidadNombre.equals("A Coruña")) {
            UtilidadesNavigationDrawer.cambiarCabecera(navigationView, R.drawable.escudo_corunha, localidadNombre, localidadNombre);
        }

    }


    class TareaCancelaSalidaApp extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(2000);
                pulsadoDosVecesAtrasParaSalir = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}
