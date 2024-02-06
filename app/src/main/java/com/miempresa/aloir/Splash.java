package com.miempresa.aloir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //Animaciones
        Animation a1 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
        Animation a2 = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);

        TextView paraTextView = findViewById(R.id.paratextView);
        TextView aloirTextView = findViewById(R.id.aloirtextView);
        ImageView logoImageView = findViewById(R.id.logoimageView);

        paraTextView.setAnimation(a2);
        aloirTextView.setAnimation(a2);
        logoImageView.setAnimation(a1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}