package com.miempresa.aloir;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Nveles_Activity extends AppCompatActivity {

    Button Abandonar;
    TextView difi, music;
    String bundle;
    int exerciseasy =0;
    private MediaPlayer reproductorAudio, reproductorAudio2;
    private SeekBar seekBar, seekBar2;
    private Button playButton, playButton2, Alto, Bajo, Igual;

    private Timer time;
    public static List<Map<String, Object>> questions = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nveles);

        //Para salir del juego en nivel básico
        Abandonar = findViewById(R.id.btnVolver);
        difi = findViewById(R.id.difficult);
        bundle = getIntent().getStringExtra("dd");
        difi.setText(bundle);
        switch (bundle) {
            case "Facil":
                //DO
                addQuestion( "DO alto", R.raw.do_afinado, R.raw.do_alto, "alto");
                addQuestion("DO bajo", R.raw.do_afinado, R.raw.do_bajo, "bajo");
                addQuestion("DO afi", R.raw.do_afinado, R.raw.do_afinado, "igual");
                //DO#REb
                addQuestion( "DO#REb alto", R.raw.dossreb_afinado, R.raw.dossreb_alto, "alto");
                addQuestion("DO#REb bajo", R.raw.dossreb_afinado, R.raw.dossreb_bajo, "bajo");
                addQuestion("DO#REb afi", R.raw.dossreb_afinado, R.raw.dossreb_afinado, "igual");
                //RE
                addQuestion( "RE alto", R.raw.re_afinado, R.raw.re_alto, "alto");
                addQuestion("RE bajo", R.raw.re_afinado, R.raw.re_bajo, "bajo");
                addQuestion("RE afi", R.raw.re_afinado, R.raw.re_afinado, "igual");
                //RE#MIb
                addQuestion( "RE#MIb alto", R.raw.remib_afinado, R.raw.remib_alto, "alto");
                addQuestion("RE#MIb bajo", R.raw.remib_afinado, R.raw.remib_bajo, "bajo");
                addQuestion("RE#MIb afi", R.raw.remib_afinado, R.raw.remib_afinado, "igual");
                //MI
                addQuestion( "MI alto", R.raw.mi_afinado, R.raw.mi_alto, "alto");
                addQuestion("MI bajo", R.raw.mi_afinado, R.raw.mi_bajo, "bajo");
                addQuestion("MI afi", R.raw.mi_afinado, R.raw.mi_afinado, "igual");
                //FA
                addQuestion( "FA alto", R.raw.fa_afinado, R.raw.fa_alto, "alto");
                addQuestion("FA bajo", R.raw.fa_afinado, R.raw.fa_bajo, "bajo");
                addQuestion("FA afi", R.raw.fa_afinado, R.raw.fa_afinado, "igual");
                //FA#SOLb
                addQuestion( "FA#SOLb alto", R.raw.fasolb_afinado, R.raw.fasolb_alto, "alto");
                addQuestion("FA#SOLb bajo", R.raw.fasolb_afinado, R.raw.fasolb_bajo, "bajo");
                addQuestion("FA#SOLb afi", R.raw.fasolb_afinado, R.raw.fasolb_afinado, "igual");
                //SOL
                addQuestion( "SOL alto", R.raw.sol_afinado, R.raw.sol_alto, "alto");
                addQuestion("SOL bajo", R.raw.sol_afinado, R.raw.sol_bajo, "bajo");
                addQuestion("SOL afi", R.raw.sol_afinado, R.raw.sol_afinado, "igual");
                //SOL#LAb
                addQuestion( "SOL#LAb alto", R.raw.sollab_afinado, R.raw.sollab_alto, "alto");
                addQuestion("SOL#LAb bajo", R.raw.sollab_afinado, R.raw.sollab_bajo, "bajo");
                addQuestion("SOL#LAb afi", R.raw.sollab_afinado, R.raw.sollab_afinado, "igual");
                //LA
                addQuestion( "LA alto", R.raw.la_afinado, R.raw.la_alto, "alto");
                addQuestion("LA bajo", R.raw.la_afinado, R.raw.la_bajo, "bajo");
                addQuestion("LA afi", R.raw.la_afinado, R.raw.la_afinado, "igual");
                //LA#SIb
                addQuestion( "LA#SIb alto", R.raw.lasib_afinado, R.raw.lasib_alto, "alto");
                addQuestion("LA#SIb bajo", R.raw.lasib_afinado, R.raw.lasib_bajo, "bajo");
                addQuestion("LA#SIb afi", R.raw.lasib_afinado, R.raw.lasib_afinado, "igual");
                //SI
                addQuestion( "SI alto", R.raw.si_afinado, R.raw.si_alto, "alto");
                addQuestion("SI bajo", R.raw.si_afinado, R.raw.si_bajo, "bajo");
                addQuestion("SI afi", R.raw.si_afinado, R.raw.si_afinado, "igual");
                next(questions);
                break;
            case "Medio":
                break;
            case  "Dificil":
                break;
        }

        time = new Timer();
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
    //crea el diccionario de preguntas
    public static void addQuestion(String lettermusic, int bar1, int bar2, String correct) {
        Map<String, Object> questionMap = new HashMap<>();
        questionMap.put("lettermusic", lettermusic);
        questionMap.put("bar1", bar1);
        questionMap.put("bar2", bar2);
        questionMap.put("correct", correct);
        questions.add(questionMap);
    }
    public void next(List<Map<String, Object>> qqs) {
        Random random = new Random();
        int randomIndex = random.nextInt(qqs.size());
        Map<String, Object> randomQuestion = qqs.get(randomIndex);
        int principalsound = (int) randomQuestion.get("bar1");
        int secundarysound = (int) randomQuestion.get("bar2");
        String mletter = (String) randomQuestion.get("lettermusic");
        String rpta = (String) randomQuestion.get("correct");
        exercise(principalsound, secundarysound, mletter,rpta);
    }

    @SuppressLint("ResourceAsColor")
    public void exercise(int primary, int secondary, String ml, String response) {
        exerciseasy=exerciseasy + 1;
        // cambiar esto solo verifico si funciona xddd
        if (exerciseasy >= 10) {
            Toast.makeText(this, "completado", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Nveles_Activity.this, MainActivity.class);
            startActivity(intent);
        }
        if (exerciseasy > 1 && exerciseasy <= 9){
            Toast.makeText(this, "Buen trabajo siguiente nivel", Toast.LENGTH_SHORT).show();
        }
        // Usado para cargar audio 01
        reproductorAudio = MediaPlayer.create(this, primary);
        seekBar = findViewById(R.id.verticalSeekBar);
        playButton = findViewById(R.id.playButton);

        // Usado para cargar audio 02
        reproductorAudio2 = MediaPlayer.create(this, secondary);
        seekBar2 = findViewById(R.id.verticalSeekBar2);
        playButton2 = findViewById(R.id.playButton2);

        music = findViewById(R.id.musicletter);
        music.setText(ml);

        Alto = findViewById(R.id.btnAlto);
        Bajo = findViewById(R.id.btnBajo);
        Igual = findViewById(R.id.btnIgual);

        Alto.setBackground(getDrawable(R.drawable.up_arrow));
        Bajo.setBackground(getDrawable(R.drawable.down_arrow));
        Igual.setBackground(getDrawable(R.drawable.equals));

        if (response.equals("alto")){
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Alto.setBackgroundColor(R.color.white);
                    next(questions);
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        } else if (response.equals("bajo")) {
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bajo.setBackgroundColor(R.color.white);
                    next(questions);
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        } else {
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Igual.setBackgroundColor(R.color.white);
                    next(questions);
                }
            });
        }

        configureAudioPlayer(reproductorAudio, seekBar, playButton);
        configureAudioPlayer(reproductorAudio2, seekBar2, playButton2);
    }

    private void configureAudioPlayer(MediaPlayer player, SeekBar seekBar, Button playButton) {
        seekBar.setEnabled(false);
        seekBar.setMax(3000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    player.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        playButton.setOnClickListener(view -> {
            if (player.isPlaying()) {
                player.pause();
                player.seekTo(0);
                stopUpdatingSeekBar(player);
                playButton.setText("▶");
            } else {
                player.start();
                startUpdatingSeekBar(player, seekBar);
                playButton.setText("Stop");
            }
        });

        player.setOnCompletionListener(mp -> {
            seekBar.setProgress(0);
            stopUpdatingSeekBar(player);
            playButton.setText("▶");
        });
    }

    private void startUpdatingSeekBar(MediaPlayer mediaPlayer, SeekBar seekBar) {
        time.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    seekBar.post(() -> seekBar.setProgress(currentPosition));
                } else {
                    // El MediaPlayer no está reproduciendo o es nulo, detener la actualización
                    stopUpdatingSeekBar(mediaPlayer);
                }
            }
        }, 0, 100);
    }

    private void stopUpdatingSeekBar(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            mediaPlayer.seekTo(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Detener el temporizador si está en ejecución
        if (time != null) {
            time.cancel();
            time = null;
        }
        // Liberar los recursos del MediaPlayer
        releaseMediaPlayer(reproductorAudio);
        releaseMediaPlayer(reproductorAudio2);
    }

    private void releaseMediaPlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}