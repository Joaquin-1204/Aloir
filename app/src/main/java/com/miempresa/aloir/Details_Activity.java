package com.miempresa.aloir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {
    TextView puntos, resuelto, noresult, mj;
    Button Volver;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        puntos = findViewById(R.id.pt);
        resuelto = findViewById(R.id.results);
        noresult = findViewById(R.id.results2);
        Volver = findViewById(R.id.btnVolver);
        mj = findViewById(R.id.mensaje);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int bundle = extras.getInt("puntos");
            int rere = bundle;
            rere = rere / 10;
            int neg = 10 - rere;
            String points = String.valueOf(bundle);

            if (rere >= 0 && rere <= 5){
                mj.setText("Tu puedes sigue intentando");
            } else if (rere >= 6 && rere <= 8){
                mj.setText("¡Bien hecho! :D");
            } else {
                mj.setText("¡FELICITACIONES! :D");
            }

            puntos.setText("00" + points);
            resuelto.setText("Respuestas correctas: " + rere);
            noresult.setText("Respuestas incorrectas: " + neg);
        }

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_activity, R.anim.slide_out_activity);
            }
        });


    }
}