package com.miempresa.aloir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Jugar_Activity extends AppCompatActivity {

    Button n1, n2, n3, Volver;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        // Botones
        n1 = findViewById(R.id.btnFacil);
        n2 = findViewById(R.id.btnMedio);
        n3 = findViewById(R.id.btnDificil);
        Volver = findViewById(R.id.btnVolver);

        //Acciones
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_activity, R.anim.slide_out_activity);
            }
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                intent.putExtra("dd", "Nivel 1");
                startActivity(intent);
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                intent.putExtra("dd", "Nivel 2");
                startActivity(intent);
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                intent.putExtra("dd", "Nivel 3");
                startActivity(intent);
            }
        });
    }
}