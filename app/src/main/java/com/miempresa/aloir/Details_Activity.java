package com.miempresa.aloir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {
    TextView puntos, resuelto, noresult, mj, dif;
    Button Volver,replay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        puntos = findViewById(R.id.pt);
        resuelto = findViewById(R.id.results);
        noresult = findViewById(R.id.results2);
        Volver = findViewById(R.id.btnVolver);
        dif = findViewById(R.id.difficult);
        mj = findViewById(R.id.mensaje);
        replay = findViewById(R.id.replays);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int bundle = extras.getInt("puntos");
            String rep = extras.getString("nivel");
            dif.setText(rep);
            int rere = bundle;
            rere = rere / 10;
            int neg = 10 - rere;
            String points = String.valueOf(bundle);

            if (rere >= 0 && rere <= 5){
                mj.setText("Tu puedes, sigue intentando");
            } else if (rere >= 6 && rere <= 8){
                mj.setText("¡Bien hecho!");
            } else {
                mj.setText("¡FELICITACIONES!");
            }

            puntos.setText("00" + points);
            resuelto.setText("✔ Respuestas correctas: " + rere);
            noresult.setText("❌ Respuestas incorrectas: " + neg);

            replay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Details_Activity.this, Nveles_Activity.class);
                    intent.putExtra("dd",rep);
                    startActivity(intent);
                }
            });
        }

        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_activity, R.anim.slide_out_activity);
                Intent intent = new Intent(Details_Activity.this, Jugar_Activity.class);
                startActivity(intent);
            }
        });


    }
}