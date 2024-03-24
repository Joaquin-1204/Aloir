package com.miempresa.aloir;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Jugar_Activity extends AppCompatActivity {

    Button n1, n2, n3, n4, n5, n6, Volver;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);
        // Botones
        n1 = findViewById(R.id.btnFacil);
        n2 = findViewById(R.id.btnMedio);
        n3 = findViewById(R.id.btnDificil);
        n4 = findViewById(R.id.btnn4);
        n5 = findViewById(R.id.btnn5);
        n6 = findViewById(R.id.btnn6);
        Volver = findViewById(R.id.btnVolver);

        //Acciones
        Volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_activity, R.anim.slide_out_activity);
                Intent intent = new Intent(Jugar_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(Jugar_Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Confirmación")
                        .setContentText("¿Estás seguro de que quieres empezar el Nivel 1?")
                        .setConfirmText("Iniciar")
                        .setCancelText("Cancelar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                                intent.putExtra("dd", "Nivel 1");
                                startActivity(intent);
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(Jugar_Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Confirmación")
                        .setContentText("¿Estás seguro de que quieres empezar el Nivel 2?")
                        .setConfirmText("Iniciar")
                        .setCancelText("Cancelar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                                intent.putExtra("dd", "Nivel 2");
                                startActivity(intent);
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(Jugar_Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Confirmación")
                        .setContentText("¿Estás seguro de que quieres empezar el Nivel 3?")
                        .setConfirmText("Iniciar")
                        .setCancelText("Cancelar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                                intent.putExtra("dd", "Nivel 3");
                                startActivity(intent);
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(Jugar_Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Confirmación")
                        .setContentText("¿Estás seguro de que quieres empezar el Nivel 4?")
                        .setConfirmText("Iniciar")
                        .setCancelText("Cancelar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                                intent.putExtra("dd", "Nivel 4");
                                startActivity(intent);
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(Jugar_Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Confirmación")
                        .setContentText("¿Estás seguro de que quieres empezar el Nivel 5?")
                        .setConfirmText("Iniciar")
                        .setCancelText("Cancelar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                                intent.putExtra("dd", "Nivel 5");
                                startActivity(intent);
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(Jugar_Activity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Confirmación")
                        .setContentText("¿Estás seguro de que quieres empezar el Nivel 6?")
                        .setConfirmText("Iniciar")
                        .setCancelText("Cancelar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                Intent intent = new Intent(Jugar_Activity.this, Nveles_Activity.class);
                                intent.putExtra("dd", "Nivel 6");
                                startActivity(intent);
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                            }
                        })
                        .show();
            }
        });
    }
}