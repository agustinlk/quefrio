package com.alotitokehoe.utn.quefrio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class EditorFragment extends Fragment {

    private View v;

    public EditorFragment() {
        // Required empty public constructor
    }

    public static EditorFragment newInstance() {
        EditorFragment fragment = new EditorFragment();
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
        this.v = inflater.inflate(R.layout.editor_fragment, container, false);
        Button botonAgregar = (Button) v.findViewById(R.id.btnAgregar);
        botonAgregar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vb){
                agregarYVolver(v);
            }
        });

        Button botonCancelar = (Button) v.findViewById(R.id.btnCancelar);
        botonCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vb){
                volver(v);
            }
        });

        return v;
    }

    public void agregarYVolver(View v) {
        Bundle args = new Bundle();
        EditText txtCiudad = v.findViewById(R.id.editNombreCiudad);
        String algo = txtCiudad.getText().toString();
        args.putString("respuesta", "Ciudad " + txtCiudad.getText());
        CiudadFragment ciudadFragment = new CiudadFragment();
        ciudadFragment.setArguments(args);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, ciudadFragment).commit();
    }

    public void volver(View v) {
        Bundle args = new Bundle();
        args.putString("respuesta", "...cancelado...");
        CiudadFragment ciudadFragment = new CiudadFragment();
        ciudadFragment.setArguments(args);
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, ciudadFragment).commit();
    }
}