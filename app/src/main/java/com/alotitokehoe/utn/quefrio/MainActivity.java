package com.alotitokehoe.utn.quefrio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //SharedPreferences misPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /*this.misPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        String unNombre = this.misPref.getString("nombre", "");
        SharedPreferences.Editor editor = this.misPref.edit();
        editor.putString( "nombre", "algo");
        editor.commit();
        String unNombre2 = this.misPref.getString("nombre", "");*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CiudadesFragment ciudadesFragment = (CiudadesFragment)
                getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        Bundle params = this.getIntent().getExtras();
        String respuesta = "Nuevo";
        if(params != null) {
            respuesta = params.getString("respuesta");
            if(!respuesta.equals("cancelado")){
                Toast.makeText(getApplicationContext(),"Se agregó la ciudad: " + respuesta,Toast.LENGTH_SHORT).show();
            }
        }

        if (ciudadesFragment == null) {
            ciudadesFragment = CiudadesFragment.newInstance();
            //Aca agregamos el fragmento al frameLayout del activity_main
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout, ciudadesFragment);
            transaction.commit();
        }

    }

    public void onClicIrEditor(View v) {
        Intent intentEdit = new Intent(this, EditActivity.class);
        startActivity(intentEdit);
    }


}