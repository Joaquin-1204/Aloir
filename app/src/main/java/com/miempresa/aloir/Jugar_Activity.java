package com.miempresa.aloir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Jugar_Activity extends AppCompatActivity {

    Button Facil, Medio, Dificil, Volver;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        // Botones
        Facil = findViewById(R.id.btnFacil);
        Medio = findViewById(R.id.btnMedio);
        Dificil = findViewById(R.id.btnDificil);
        Volver = findViewById(R.id.btnVolver);

        //Acciones
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}