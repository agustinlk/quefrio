package com.alotitokehoe.utn.quefrio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences misPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.misPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CiudadesFragment ciudadesFragment = (CiudadesFragment)
                getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        Bundle params = this.getIntent().getExtras();
        String respuesta = "";
        if(params != null) {
            respuesta = params.getString("respuesta");
            if(!respuesta.equals("cancelado")){
                Toast.makeText(getApplicationContext(),"Se agregó la ciudad: " + respuesta,Toast.LENGTH_SHORT).show();
            }
        }

        TextView labelAgregadas = findViewById(R.id.label_agregadas);
        SharedPreferences.Editor editor = this.misPref.edit();
        String ciudadesAgregadas = this.misPref.getString("ciudades_agregadas", "");
        ciudadesAgregadas = ciudadesAgregadas + " " + respuesta;
        editor.putString( "ciudades_agregadas", ciudadesAgregadas);
        editor.commit();
        labelAgregadas.setText("Ciudades agregadas usuario: " +  ciudadesAgregadas);

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