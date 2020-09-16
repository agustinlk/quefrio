package com.alotitokehoe.utn.quefrio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CiudadFragment ciudadFragment = (CiudadFragment)
                getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        if (ciudadFragment == null) {
            ciudadFragment = CiudadFragment.newInstance();
            //Aca agregamos el fragmento frameLayout del activity_main
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, ciudadFragment)
                    .commit();
        }
    }

}