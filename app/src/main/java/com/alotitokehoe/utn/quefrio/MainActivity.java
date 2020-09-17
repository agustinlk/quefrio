package com.alotitokehoe.utn.quefrio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CiudadFragment ciudadFragment = (CiudadFragment)
                getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        Bundle params = this.getIntent().getExtras();
        String respuesta = "Nuevo";
        if(params != null) {
            respuesta = params.getString("respuesta");
        }
        Toast.makeText(getApplicationContext(),respuesta,Toast.LENGTH_SHORT).show();

        if (ciudadFragment == null) {
            ciudadFragment = CiudadFragment.newInstance();
            //Aca agregamos el fragmento al frameLayout del activity_main
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout, ciudadFragment);
            transaction.commit();
        }
    }

    public void onClicIrEditor(View v) {
        Intent intentEdit = new Intent(this, EditActivity.class);
        startActivity(intentEdit);
    }


}