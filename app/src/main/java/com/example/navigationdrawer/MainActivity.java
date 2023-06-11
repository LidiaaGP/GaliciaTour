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

        String nombreLugar = "Casa dos Xacobes";
        String nombreLugar2="Restaurante Abrasador Gaia Medieval";
        String nombreLugar3="Sicilia in Bocca, Avenida de Rosalía de Castro, Santiago de Compostela";
        String nombreLugar4="Garum Bistro";
        String nombreLugar5="Mesón 42";
        String nombreLugar6="O Tamboril";
        String nombreLugar7="O Sendeiro";
        String nombreLugar8="Bar La Tita";
        String nombreLugar9="Epoca Restaurante Peruano Fusión";


        String nombreLugar10="Os Padróns Vigo";
        String nombreLugar11="Restaurante Valdevez";
        String nombreLugar12="Trepia gastronomía";
        String nombreLugar13="Nikko Espacio Gastronomico Vigo";
        String nombreLugar14="Casa Obdulia";
        String nombreLugar15="La pepita Vigo";
        String nombreLugar16="Taberna A Pedra";


        String nombreLugar17="Parrillada Caminito Lugo";
        String nombreLugar18="La pizzeria di Totó";
        String nombreLugar19="Pasarela Lugo";
        String nombreLugar20="La Urbana cerca de Rúa Bispo";
        String nombreLugar21="Pulpería O Xugo";
        String nombreLugar22="Mesón da Rúa";
        String nombreLugar23="O tentaculo";
        String nombreLugar24="A Casa D'auga, Rúa do Miño, Lugo";
        String nombreLugar25="Restaurante Paprica Lugo";

        String nombreLugar26="Pepe Vieira";
        String nombreLugar27="Casa Solla";
        String nombreLugar28="Maruja Limón";
        String nombreLugar29="Eirado Da Leña";
        String nombreLugar30="O Pote Pontevedra";
        String nombreLugar31="Casa Román";
        String nombreLugar32="Don Alex Pontevedra";
        String nombreLugar33="Restaurante Rias Bajas Pontevedra";
        String nombreLugar34="Casa Marco Pontevedra";
        String nombreLugar35="Milongas Parrillada Coruña";


        String nombreLugar36="Restaurante Alborada A Coruña";
        String nombreLugar37="O'fragón restaurante";
        String nombreLugar38="Árbore da Veira";
        String nombreLugar39="O Lagar da Estrella";
        String nombreLugar40="Restaurante Bido";
        String nombreLugar41="O Retiro da Costiña";

        System.out.println("LUGAR 1");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar);
        System.out.println("LUGAR 2");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar2);
        System.out.println("LUGAR 3");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar3);
        System.out.println("LUGAR 4");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar4);
        System.out.println("LUGAR 5");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar5);
        System.out.println("LUGAR 6");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar6);
        System.out.println("LUGAR 7");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar7);
        System.out.println("LUGAR 8");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar8);
        System.out.println("LUGAR 9");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar9);

        System.out.println("LUGAR 10");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar10);
        System.out.println("LUGAR 11");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar11);
        System.out.println("LUGAR 12");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar12);
        System.out.println("LUGAR 13");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar13);
        System.out.println("LUGAR 14");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar14);
        System.out.println("LUGAR 15");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar15);
        System.out.println("LUGAR 16");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar16);

        System.out.println("LUGAR 17");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar17);
        System.out.println("LUGAR 18");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar18);
        System.out.println("LUGAR 19");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar19);
        System.out.println("LUGAR 20");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar20);
        System.out.println("LUGAR 21");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar21);
        System.out.println("LUGAR 22");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar22);
        System.out.println("LUGAR 23");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar23);
        System.out.println("LUGAR 24");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar24);
        System.out.println("LUGAR 25");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar25);
        System.out.println("LUGAR 26");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar26);
        System.out.println("LUGAR 27");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar27);
        System.out.println("LUGAR 28");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar28);
        System.out.println("LUGAR 29");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar29);
        System.out.println("LUGAR 30");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar30);
        System.out.println("LUGAR 31");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar31);
        System.out.println("LUGAR 32");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar32);
        System.out.println("LUGAR 33");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar33);
        System.out.println("LUGAR 34");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar34);
        System.out.println("LUGAR 35");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar35);
        System.out.println("LUGAR 36");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar36);
        System.out.println("LUGAR 37");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar37);
        System.out.println("LUGAR 38");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar38);
        System.out.println("LUGAR 39");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar39);
        System.out.println("LUGAR 40");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar40);
        System.out.println("LUGAR 41");
        GeocoderUtils.obtenerLatitudLongitud(getApplicationContext(), nombreLugar41);




        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }
        PackageManager packageManager = getPackageManager();

        String permission = Manifest.permission.ACCESS_FINE_LOCATION;  // Permiso de ubicación precisa
        int result = packageManager.checkPermission(permission, getPackageName());

        if (result == PackageManager.PERMISSION_GRANTED) {
            // El permiso ha sido otorgado
            Log.d(TAG, "El permiso de ubicación está otorgado");
        } else {
            // El permiso no ha sido otorgado
            Log.d(TAG, "El permiso de ubicación no está otorgado");
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout); // Contenedor principal que incluye toda la interfaz con el menú deslizante
        NavigationView navigationView = findViewById(R.id.nav_view); // Menú deslizante

        // IDs fragments(mobile_navigation.xml) y eb menu deslizante(activity_main_drawer.xml)
        // a tener en cuenta para visualizar en la barra de acción
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.fragmento2, R.id.fragmento3,R.id.fragmento4,R.id.fragmento5)
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
