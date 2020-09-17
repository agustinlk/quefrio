package com.alotitokehoe.utn.quefrio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CiudadFragment ciudadFragment = (CiudadFragment)
                getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        if (ciudadFragment == null) {
            ciudadFragment = CiudadFragment.newInstance();
            //Aca agregamos el fragmento al frameLayout del activity_main
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout, ciudadFragment);
            transaction.commit();
        }
    }


}