package com.alotitokehoe.utn.quefrio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CiudadesAdapter extends ArrayAdapter<Ciudad> {

    public CiudadesAdapter(Context context, List<Ciudad> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.list_item_ciudad,
                    parent,
                    false);
        }

        // Referencias UI.
        TextView name = (TextView) convertView.findViewById(R.id.tv_name);

        // Ciudad actual.
        Ciudad ciudad = getItem(position);

        // Setup.
        name.setText(ciudad.getNombre());
        //title.setText(ciudad.getTemperatura());

        return convertView;
    }
}
