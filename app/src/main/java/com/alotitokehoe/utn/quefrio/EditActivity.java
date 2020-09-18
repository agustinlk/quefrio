package com.alotitokehoe.utn.quefrio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditorFragment editorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        this.editorFragment = (EditorFragment)
                getSupportFragmentManager().findFragmentById(R.id.frameLayout);

        if (this.editorFragment == null) {
            this.editorFragment = EditorFragment.newInstance();
            //Aca agregamos el fragmento al frameLayout del activity_main
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frameLayout, this.editorFragment);
            transaction.commit();
        }
    }

    public void onClicAgregarVolver(View v) {
        Intent intentMain = new Intent(this, MainActivity.class);

        EditText nombreNuevaCiudad = editorFragment.getView().findViewById(R.id.editNombreCiudad);
        intentMain.putExtra("respuesta", nombreNuevaCiudad.getText().toString());

        startActivity(intentMain);
    }

    public void onClicVolver(View v) {
        Intent intentMain = new Intent(this, MainActivity.class);

        intentMain.putExtra("respuesta", "cancelado");

        startActivity(intentMain);
    }

}