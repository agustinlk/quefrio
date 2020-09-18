package com.alotitokehoe.utn.quefrio;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CiudadesRepository {

    private static CiudadesRepository repository = new CiudadesRepository();
    private HashMap<String, Ciudad> ciudades = new HashMap<>();


    public static CiudadesRepository getInstance() {
        return repository;
    }

    private CiudadesRepository() {
        saveCiudad(new Ciudad("Cordoba"));
        saveCiudad(new Ciudad("Buenos Aires"));
        saveCiudad(new Ciudad("Rosario"));
        saveCiudad(new Ciudad("Bariloche"));
        saveCiudad(new Ciudad("Campana"));
    }

    public void saveCiudad(Ciudad ciudad) {
        ciudades.put(ciudad.getId(), ciudad);
    }

    public List<Ciudad> getCiudades() {
        return new ArrayList<>(ciudades.values());
    }
}
