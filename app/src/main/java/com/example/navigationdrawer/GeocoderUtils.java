package com.example.navigationdrawer;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeocoderUtils {
    private static final String TAG = "GeocoderUtils";

    public static void obtenerLatitudLongitud(Context context, String lugar) {
        Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocationName(lugar, 1);
            if (addresses != null && addresses.size() > 0) {
                Address address = addresses.get(0);
                double latitud = address.getLatitude();
                double longitud = address.getLongitude();
                Log.d(TAG, "Latitud: " + latitud);
                Log.d(TAG, "Longitud: " + longitud);
            } else {
                Log.d(TAG, "No se encontraron resultados para el lugar: " + lugar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
