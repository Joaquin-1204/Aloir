package com.miempresa.aloir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                overridePendingTransition(R.anim.slide_in_activity, R.anim.slide_out_activity);
            }
        });
        Facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                intent.putExtra("dd", "Facil");
                startActivity(intent);
            }
        });
        Medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                //intent.putExtra("dd", "Medio");
                //startActivity(intent);
                Toast.makeText(Jugar_Activity.this, "Próximamente", Toast.LENGTH_SHORT).show();
            }
        });
        Dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                //intent.putExtra("dd", "Dificil");
                //startActivity(intent);
                Toast.makeText(Jugar_Activity.this, "Próximamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}