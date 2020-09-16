package com.alotitokehoe.utn.quefrio;

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
        saveCiudad(new Ciudad("Argentina"));
        saveCiudad(new Ciudad("Brasil"));
        saveCiudad(new Ciudad("España"));
        saveCiudad(new Ciudad("Paraguay"));
        saveCiudad(new Ciudad("China"));
    }

    private void saveCiudad(Ciudad ciudad) {
        ciudades.put(ciudad.getId(), ciudad);
    }

    public List<Ciudad> getCiudades() {
        return new ArrayList<>(ciudades.values());
    }
}
