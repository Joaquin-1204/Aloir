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
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Nveles_Activity extends AppCompatActivity {

    Button Abandonar;
    TextView difi;
    String bundle;

    private MediaPlayer reproductorAudio, reproductorAudio2;
    private SeekBar seekBar, seekBar2;
    private Button playButton, playButton2;
    private Handler ejecutable;
    private Handler ejecutable2;
    private boolean recorrido = false;
    private boolean recorrido2 = false;
    private Timer time, time2;

    private int[] audiosRaw = {R.raw.do_alto, R.raw.do_bajo, R.raw.do_afinado}; // Array de recursos de audio
    private Random random = new Random(); // Generador de números aleatorios



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nveles);


        // Usado para cargar audio 01
        reproductorAudio = MediaPlayer.create(this, R.raw.do_afinado);
        seekBar = findViewById(R.id.verticalSeekBar);
        playButton = findViewById(R.id.playButton);
        ejecutable = new Handler();

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
                String audioFileName = getResources().getResourceEntryName(R.raw.do_afinado); // Obtener el nombre del archivo de audio "do_afinado"
                Log.d("Audio reproduciendo", audioFileName); // Mostrar el nombre del archivo de audio en la consola
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

        // Usado para cargar audio 02
        reproductorAudio2 = MediaPlayer.create(this, R.raw.do_alto);
        seekBar2 = findViewById(R.id.verticalSeekBar2);
        playButton2 = findViewById(R.id.playButton2);
        ejecutable2 = new Handler();

        seekBar2.setEnabled(false);
        seekBar2.setMax(3000); // 3000 milisegundos = 3 segundos

        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    reproductorAudio2.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                recorrido2 = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                recorrido2 = false;
            }
        });

        playButton2.setOnClickListener(view -> {
            if (reproductorAudio2 != null && reproductorAudio2.isPlaying()) {
                reproductorAudio2.pause(); // Pausar la reproducción actual
                reproductorAudio2.seekTo(0); // Reiniciar el audio desde el principio
                stopUpdatingSeekBar2(); // Detener el temporizador
                playButton2.setText("Play");
            } else {
                if (reproductorAudio2 != null) {
                    reproductorAudio2.release(); // Liberar el recurso anterior
                }
                int audioIndex = random.nextInt(audiosRaw.length); // Obtener un índice aleatorio
                int audioResource = audiosRaw[audioIndex]; // Obtener el recurso de audio correspondiente al índice
                reproductorAudio2 = MediaPlayer.create(this, audioResource); // Crear el MediaPlayer con el audio seleccionado
                reproductorAudio2.start();
                startUpdatingSeekBar2();
                playButton2.setText("Stop");
                String audioFileName = getResources().getResourceEntryName(audioResource); // Obtener el nombre del archivo de audio
                Log.d("Audio reproduciendo", audioFileName); // Mostrar el nombre del archivo de audio en la consola
            }
        });

        reproductorAudio2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                //seekBar2.setProgress(seekBar2.getMax());
                seekBar2.setProgress(0); // Establecer el progreso del SeekBar al inicio
                stopUpdatingSeekBar2();
                playButton2.setText("Play");
                reproductorAudio2.seekTo(0); // Reiniciar el audio desde el principio
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
                    ejecutable.post(() -> seekBar.setProgress(posicion));
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

    // Método para iniciar el temporizador y actualizar el SeekBar para el segundo audio
    private void startUpdatingSeekBar2() {
        stopUpdatingSeekBar2();
        time2 = new Timer();
        time2.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (!recorrido2 && reproductorAudio2 != null && reproductorAudio2.isPlaying()) {
                    int currentPosition = reproductorAudio2.getCurrentPosition();
                    ejecutable2.post(() -> seekBar2.setProgress(currentPosition));
                } else {
                    stopUpdatingSeekBar2();
                }
            }
        }, 0, 100);
    }

    // Método para detener el temporizador para el segundo audio
    private void stopUpdatingSeekBar2() {
        if (time2 != null) {
            time2.cancel();
            time2 = null;
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

        if (reproductorAudio2 != null) {
            reproductorAudio2.release();
            reproductorAudio2 = null;
        }
        stopUpdatingSeekBar2();
    }


}