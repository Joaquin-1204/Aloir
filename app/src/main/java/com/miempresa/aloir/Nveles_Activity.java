package com.miempresa.aloir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Nveles_Activity extends AppCompatActivity {

    Button Abandonar;
    TextView difi;
    String bundle;

    private MediaPlayer reproductorAudio;
    private SeekBar seekBar;
    private Button playButton;
    private Handler Ejecutable;
    private boolean recorrido = false;
    private Timer time;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nveles);


        /// Usado para cargar un archivo mp3 y reproducir ---
        reproductorAudio = MediaPlayer.create(this, R.raw.do_afinado);
        seekBar = findViewById(R.id.verticalSeekBar);
        playButton = findViewById(R.id.playButton);
        Ejecutable = new Handler();

        seekBar.setEnabled(false);
        seekBar.setMax(3000); // 3000 milisegundos = 3 segundos

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    reproductorAudio.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                recorrido = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                recorrido = false;
            }
        });

        playButton.setOnClickListener(view -> {
            if (reproductorAudio.isPlaying()) {
                reproductorAudio.pause();
                reproductorAudio.seekTo(0); // Reiniciar el audio desde el principio
                stopUpdatingSeekBar();
                playButton.setText("Play");
            } else {
                reproductorAudio.start();
                startUpdatingSeekBar();
                playButton.setText("Stop");
            }
        });


        reproductorAudio.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //seekBar.setProgress(seekBar.getMax());
                //stopUpdatingSeekBar();
                seekBar.setProgress(0); // Establecer el progreso del SeekBar al inicio
                stopUpdatingSeekBar();
                playButton.setText("Play");
            }
        });


        //Para salir del juego en nivel básico
        Abandonar = findViewById(R.id.btnVolver);
        difi = findViewById(R.id.difficult);
        bundle = getIntent().getStringExtra("dd");
        difi.setText(bundle);

        Abandonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Nveles_Activity.this);
                builder.setTitle(R.string.app_name);
                builder.setMessage("Se perdera el avance ¿Desea salir?");
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        overridePendingTransition(R.anim.radial_transition, 0);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }


    // Método para iniciar el temporizador y actualizar el SeekBar
    private void startUpdatingSeekBar() {
        stopUpdatingSeekBar(); // Detener el temporizador previo para evitar múltiples temporizadores ejecutándose simultáneamente
        time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!recorrido && reproductorAudio != null && reproductorAudio.isPlaying()) {
                    int posicion = reproductorAudio.getCurrentPosition();
                    Ejecutable.post(() -> seekBar.setProgress(posicion));
                } else {
                    stopUpdatingSeekBar(); // Detener la actualización cuando el audio se detiene
                }
            }
        }, 0, 100); // Actualizar cada 100 milisegundos
    }

    // Método para detener el temporizador
    private void stopUpdatingSeekBar() {
        if (time != null) {
            time.cancel();
            time = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (reproductorAudio != null) {
            reproductorAudio.release();
            reproductorAudio = null;
        }
        stopUpdatingSeekBar();
    }

}