package com.miempresa.aloir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Nveles_Activity extends AppCompatActivity {

    Button Abandonar;
    TextView difi;
    String bundle;

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Button playButton;
    private ToneGenerator toneGenerator;
    //private SeekBar seekBar;
    private TextView toneTextView;
    private int referenceTone = 440; // A4 (440 Hz)
    private static final int MAX_TONE = 880; // A5 (880 Hz)

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nveles);

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build());

        seekBar = findViewById(R.id.playBar);
        toneTextView = findViewById(R.id.toneTextView);

        if (seekBar != null) {
            seekBar.setMax(MAX_TONE);
            seekBar.setProgress(referenceTone);

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    if (fromUser) {
                        double ratio = Math.pow(2, (double)(progress - referenceTone) / 1200); // Convertir la diferencia de tono a una relación de frecuencia
                        int targetFrequency = (int) (referenceTone * ratio);
                        toneTextView.setText(String.format("Tono: %d Hz", targetFrequency));
                        playTone(targetFrequency);

                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                }
            });
        }

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

    private void playTone(int frequency) {
        // Detener la reproducción del tono si ya está sonando
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }

        // Configurar el tono y reproducirlo en bucle
        try {
            mediaPlayer.reset();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mediaPlayer.setDataSource(getResources().openRawResourceFd(R.raw.la)); // Cargar el archivo de audio desde la carpeta "res/raw"
            }
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

        /*

        //Usado para cargar un archivo mp3 y reproducir ---


        mediaPlayer = MediaPlayer.create(this, R.raw.ringtones);
        seekBar = findViewById(R.id.verticalSeekBar);
        playButton = findViewById(R.id.playButton);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        playButton.setOnClickListener(view -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        });
        */



}