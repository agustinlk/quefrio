package com.alotitokehoe.utn.quefrio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class CiudadFragment extends Fragment {

    ListView ciudadesList;
    CiudadesAdapter ciudadesAdapter;

    public CiudadFragment() {
        // Required empty public constructor
    }

    public static CiudadFragment newInstance() {
        CiudadFragment fragment = new CiudadFragment();
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

        Button botonNueva = (Button) v.findViewById(R.id.btnNueva);
        botonNueva.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                abrirEditor(v);
            }
        });

        Bundle params = getArguments();
        String respuesta = "Nuevo";
        if(params != null) {
            respuesta = params.getString("respuesta");
        }
        Toast.makeText(getActivity().getApplicationContext(),respuesta,Toast.LENGTH_SHORT).show();
        // Instancia del ListView
        ciudadesList = (ListView) v.findViewById(R.id.ciudades_list);
        ciudadesAdapter = new CiudadesAdapter(getActivity(),CiudadesRepository.getInstance().getCiudades());
        ciudadesList.setAdapter(ciudadesAdapter);

        return v;
    }

    public void abrirEditor(View v){
        EditorFragment editorFragment = new EditorFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, editorFragment).commit();
    }



}