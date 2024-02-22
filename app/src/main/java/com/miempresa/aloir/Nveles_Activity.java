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
    TextView difi, music, questionCounter, scoreCounter;
    String bundle;
    int exerciseasy =0;
    private MediaPlayer reproductorAudio, reproductorAudio2;
    private SeekBar seekBar, seekBar2;
    private Button playButton, playButton2, Alto, Bajo, Igual;

    private int puntajeActual = 0;
    private final int puntajeMaximo = 100;


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

                //DO4 escala 4
                addQuestion( "DO4 alto", R.raw.do4_afinado, R.raw.do4_alto, "alto");
                addQuestion("DO4 bajo", R.raw.do4_afinado, R.raw.do4_bajo, "bajo");
                addQuestion("DO4 afi", R.raw.do4_afinado, R.raw.do4_afinado, "igual");

                //DO#RE4 escala 4
                addQuestion( "DO#RE4 alto", R.raw.doreb4_afinado, R.raw.doreb4_alto, "alto");
                addQuestion("DO#RE4 bajo", R.raw.doreb4_afinado, R.raw.doreb4_bajo, "bajo");
                addQuestion("DO#RE4 afi", R.raw.doreb4_afinado, R.raw.doreb4_afinado, "igual");

                //RE4 escala 4
                addQuestion( "RE4 alto", R.raw.re4_afinado, R.raw.re4_alto, "alto");
                addQuestion("RE4 bajo", R.raw.re4_afinado, R.raw.re4_bajo, "bajo");
                addQuestion("RE4 afi", R.raw.re4_afinado, R.raw.re4_afinado, "igual");

                //RE#MI4 escala 4
                addQuestion( "RE#MI4 alto", R.raw.re4_afinado, R.raw.re4_alto, "alto");
                addQuestion("RE#MI4 bajo", R.raw.re4_afinado, R.raw.re4_bajo, "bajo");
                addQuestion("RE#MI4 afi", R.raw.re4_afinado, R.raw.re4_afinado, "igual");

                //MI4 escala 4
                addQuestion( "MI4 alto", R.raw.mi4_afinado, R.raw.mi4_alto, "alto");
                addQuestion("MI4 bajo", R.raw.mi4_afinado, R.raw.mi4_bajo, "bajo");
                addQuestion("MI4 afi", R.raw.mi4_afinado, R.raw.mi4_afinado, "igual");

                //FA4 escala 4
                addQuestion( "FA4 alto", R.raw.fa4_afinado, R.raw.fa4_alto, "alto");
                addQuestion("FA4 bajo", R.raw.fa4_afinado, R.raw.fa4_bajo, "bajo");
                addQuestion("FA4 afi", R.raw.fa4_afinado, R.raw.fa4_afinado, "igual");

                //FA#SOL4 escala 4
                addQuestion( "FA#SOL4 alto", R.raw.fasol4_afinado, R.raw.fasol4_alto, "alto");
                addQuestion("FA#SOL4 bajo", R.raw.fasol4_afinado, R.raw.fasol4_bajo, "bajo");
                addQuestion("FA#SOL4 afi", R.raw.fasol4_afinado, R.raw.fasol4_afinado, "igual");

                //SOL4 escala 4
                addQuestion( "SOL4 alto", R.raw.sol4_afinado, R.raw.sol4_alto, "alto");
                addQuestion("SOL4 bajo", R.raw.sol4_afinado, R.raw.sol4_bajo, "bajo");
                addQuestion("SOL4 afi", R.raw.sol4_afinado, R.raw.sol4_afinado, "igual");

                //SOL#LA4 escala 4
                addQuestion( "SOL#LA4 alto", R.raw.solla4_afinado, R.raw.solla4_alto, "alto");
                addQuestion("SOL#LA4 bajo", R.raw.solla4_afinado, R.raw.solla4_bajo, "bajo");
                addQuestion("SOL#LA4 afi", R.raw.solla4_afinado, R.raw.solla4_afinado, "igual");

                //LA4 escala 4
                addQuestion( "LA4 alto", R.raw.la4_afinado, R.raw.la4_alto, "alto");
                addQuestion("LA4 bajo", R.raw.la4_afinado, R.raw.la4_bajo, "bajo");
                addQuestion("LA4 afi", R.raw.la4_afinado, R.raw.la4_afinado, "igual");

                //LA#SI4 escala 4
                addQuestion( "LA#SI4 alto", R.raw.lasi4_afinado, R.raw.lasi4_alto, "alto");
                addQuestion("LA#SI4 bajo", R.raw.lasi4_afinado, R.raw.lasi4_bajo, "bajo");
                addQuestion("LA#SI4 afi", R.raw.lasi4_afinado, R.raw.lasi4_afinado, "igual");

                //SI4 escala 4
                addQuestion( "SI4 alto", R.raw.si4_afinado, R.raw.si4_alto, "alto");
                addQuestion("SI4 bajo", R.raw.si4_afinado, R.raw.si4_bajo, "bajo");
                addQuestion("SI4 afi", R.raw.si4_afinado, R.raw.si4_afinado, "igual");

                //DO5 escala 5
                addQuestion( "DO5 alto", R.raw.do5_afinado, R.raw.do5_alto, "alto");
                addQuestion("DO5 bajo", R.raw.do5_afinado, R.raw.do5_bajo, "bajo");
                addQuestion("DO5 afi", R.raw.do5_afinado, R.raw.do5_afinado, "igual");

                //DO#RE5 escala 5
                addQuestion( "DO#RE5 alto", R.raw.dore5_afinado, R.raw.dore5_alto, "alto");
                addQuestion("DO#RE5 bajo", R.raw.dore5_afinado, R.raw.dore5_bajo, "bajo");
                addQuestion("DO#RE5 afi", R.raw.dore5_afinado, R.raw.dore5_afinado, "igual");

                //RE5 escala 5
                addQuestion( "RE5 alto", R.raw.re5_afinado, R.raw.re5_alto, "alto");
                addQuestion("RE5 bajo", R.raw.re5_afinado, R.raw.re5_bajo, "bajo");
                addQuestion("RE5 afi", R.raw.re5_afinado, R.raw.re5_afinado, "igual");

                //RE#MI5 escala 5
                addQuestion( "RE#MI5 alto", R.raw.remi5_afinado, R.raw.remi5_alto, "alto");
                addQuestion("RE#MI5 bajo", R.raw.remi5_afinado, R.raw.remi5_bajo, "bajo");
                addQuestion("RE#MI5 afi", R.raw.remi5_afinado, R.raw.remi5_afinado, "igual");

                //MI5 escala 5
                addQuestion( "MI5 alto", R.raw.mi5_afinado, R.raw.mi5_alto, "alto");
                addQuestion("MI5 bajo", R.raw.mi5_afinado, R.raw.mi5_bajo, "bajo");
                addQuestion("MI5 afi", R.raw.mi5_afinado, R.raw.mi5_afinado, "igual");

                //FA5 escala 5
                addQuestion( "FA5 alto", R.raw.fa5_afinado, R.raw.fa5_alto, "alto");
                addQuestion("FA5 bajo", R.raw.fa5_afinado, R.raw.fa5_bajo, "bajo");
                addQuestion("FA5 afi", R.raw.fa5_afinado, R.raw.fa5_afinado, "igual");

                //FA#SOL5 escala 5
                addQuestion( "FA#SOL5 alto", R.raw.fasol5_afinado, R.raw.fasol5_alto, "alto");
                addQuestion("FA#SOL5 bajo", R.raw.fasol5_afinado, R.raw.fasol5_bajo, "bajo");
                addQuestion("FA#SOL5 afi", R.raw.fasol5_afinado, R.raw.fasol5_afinado, "igual");

                //SOL5 escala 5
                addQuestion( "SOL5 alto", R.raw.sol5_afinado, R.raw.sol5_alto, "alto");
                addQuestion("SOL5 bajo", R.raw.sol5_afinado, R.raw.sol5_bajo, "bajo");
                addQuestion("SOL5 afi", R.raw.sol5_afinado, R.raw.sol5_afinado, "igual");

                //SOL#LA5 escala 5
                addQuestion( "SOL#LA5 alto", R.raw.solla5_afinado, R.raw.solla5_alto, "alto");
                addQuestion("SOL#LA5 bajo", R.raw.solla5_afinado, R.raw.solla5_bajo, "bajo");
                addQuestion("SOL#LA5 afi", R.raw.solla5_afinado, R.raw.solla5_afinado, "igual");

                //LA5 escala 5
                addQuestion( "LA5 alto", R.raw.la5_afinado, R.raw.la5_alto, "alto");
                addQuestion("LA5 bajo", R.raw.la5_afinado, R.raw.la5_bajo, "bajo");
                addQuestion("LA5 afi", R.raw.la5_afinado, R.raw.la5_afinado, "igual");

                //LA#SI5 escala 5
                addQuestion( "LA#SI5 alto", R.raw.lasi5_afinado, R.raw.lasi5_alto, "alto");
                addQuestion("LA#SI5 bajo", R.raw.lasi5_afinado, R.raw.lasi5_bajo, "bajo");
                addQuestion("LA#SI5 afi", R.raw.lasi5_afinado, R.raw.lasi5_afinado, "igual");

                //SI5 escala 5
                addQuestion( "SI5 alto", R.raw.si5_afinado, R.raw.si5_alto, "alto");
                addQuestion("SI5 bajo", R.raw.si5_afinado, R.raw.si5_bajo, "bajo");
                addQuestion("SI5 afi", R.raw.si5_afinado, R.raw.si5_afinado, "igual");

                //DO6 escala 6
                addQuestion( "DO6 alto", R.raw.do6_afinado, R.raw.do6_alto, "alto");
                addQuestion("DO6 bajo", R.raw.do6_afinado, R.raw.do6_bajo, "bajo");
                addQuestion("DO6 afi", R.raw.do6_afinado, R.raw.do6_afinado, "igual");

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

        // Inicialización de TextViews
        questionCounter = findViewById(R.id.questionCounter);
        scoreCounter = findViewById(R.id.scoreCounter);

        // Inicializar contador de preguntas y puntaje
        updateQuestionCounter();
        updateScoreCounter();
    }

    private void updateScoreCounter() {
        scoreCounter.setText(" " + puntajeActual);
    }

    private void updateQuestionCounter() {
        TextView questionCounter = findViewById(R.id.questionCounter);
        questionCounter.setText(String.format("%d/10", exerciseasy));
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

    // Método para actualizar el puntaje
    private void updateScore(int points) {
        String currentScoreText = scoreCounter.getText().toString();
        // Elimina cualquier texto adicional y deja solo el número
        String scoreText = currentScoreText.replaceAll("\\D+", "");
        int currentScore = Integer.parseInt(scoreText);
        currentScore += points; // Suma los puntos al puntaje actual
        scoreCounter.setText("0"); // Establece el puntaje inicial a 0
        scoreCounter.setText(String.valueOf(currentScore)); // Actualiza el TextView del puntaje
    }


    @SuppressLint("ResourceAsColor")
    public void exercise(int primary, int secondary, String ml, String response) {
        exerciseasy++; // Incrementa el contador de preguntas
        updateQuestionCounter(); // Actualiza el contador de preguntas
        // exerciseasy=exerciseasy + 1;
        // cambiar esto solo verifico si funciona xddd
        if (exerciseasy >= 10) {
            Toast.makeText(this, "completado" + puntajeActual, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Nveles_Activity.this, MainActivity.class);
            startActivity(intent);
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
                    updateScore(10); // Suma 10 puntos al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Buen trabajo siguiente nivel", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Entrena tu oido", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Entrena tu oido", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
        } else if (response.equals("bajo")) {
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Entrena tu oido", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(10); // Suma 10 puntos al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Buen trabajo siguiente nivel", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Entrena tu oido", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
        } else {
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Entrena tu oido", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy >= 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Entrena tu oido", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(10); // Suma 10 puntos al puntaje
                    if (exerciseasy > 1 && exerciseasy <= 9){
                        Toast.makeText(getApplicationContext(), "Buen trabajo siguiente nivel", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
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