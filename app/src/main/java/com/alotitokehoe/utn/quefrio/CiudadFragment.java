package com.alotitokehoe.utn.quefrio;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CiudadFragment extends Fragment {

    ListView ciudadesList;
    CiudadesAdapter ciudadesAdapter;

    public CiudadFragment() {
        // Required empty public constructor
    }

    public static CiudadFragment newInstance() {
        CiudadFragment fragment = new CiudadFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ciudad_fragment, container, false);
        // Instancia del ListView
        ciudadesList = (ListView) root.findViewById(R.id.ciudades_list);
        /*String[] nombresCiudades = {
                "Argentina",
                "China",
                "España",
                "Lituania",
                "Estados Unidos",
                "Islandia",
                "Rusia",
                "Sudafrica",
                "Paraguay",
                "Uruguay"
        };*/
        /*mCiudadesAdapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                nombresCiudades);*/

        ciudadesAdapter = new CiudadesAdapter(getActivity(),CiudadesRepository.getInstance().getCiudades());

        ciudadesList.setAdapter(ciudadesAdapter);

        return root;
    }
}