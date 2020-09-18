package com.alotitokehoe.utn.quefrio;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class CiudadesFragment extends Fragment {

    ListView ciudadesList;
    CiudadesAdapter ciudadesAdapter;

    public CiudadesFragment() {
    }

    public static CiudadesFragment newInstance() {
        CiudadesFragment fragment = new CiudadesFragment();
        //Setup parameters
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get parameters
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Se obtiene el objeto vista a partir del fragment, luego se puede modificar para despues retornarlo
        View v = inflater.inflate(R.layout.ciudad_fragment, container, false);
        // Instancia del ListView
        ciudadesList = (ListView) v.findViewById(R.id.ciudades_list);
        ciudadesAdapter = new CiudadesAdapter(getActivity(),CiudadesRepository.getInstance().getCiudades());
        ciudadesList.setAdapter(ciudadesAdapter);

        //Metodo que se ejecuta al seleccionar un item
        ciudadesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Ciudad ciudadElegida = ciudadesAdapter.getItem(position);
                new ClimaOnline((AppCompatActivity) getActivity()).execute(ciudadElegida.getNombre());
            }
        });

        return v;
    }

}