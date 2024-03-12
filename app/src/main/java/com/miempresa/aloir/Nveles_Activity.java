package com.miempresa.aloir;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Nveles_Activity extends AppCompatActivity {

    Button Abandonar;
    TextView difi, music, questionCounter, scoreCounter;
    String bundle;
    int exerciseasy =-1;
    private MediaPlayer reproductorAudio, reproductorAudio2;
    private SeekBar seekBar, seekBar2;
    private Button playButton, playButton2, Alto, Bajo, Igual;
    private ImageView musicview;
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
        questions.clear();
        difi.setText(bundle);
        switch (bundle) {
            case "Nivel 1":
                //DO
                addQuestion( "DO alto", R.drawable.dos, R.raw.do_afinado, R.raw.do_alto, "alto");
                addQuestion("DO bajo",R.drawable.dos, R.raw.do_afinado, R.raw.do_bajo, "bajo");
                addQuestion("DO afi",R.drawable.dos, R.raw.do_afinado, R.raw.do_afinado, "igual");
                //DO#REb
                addQuestion( "DO#REb alto",R.drawable.doreb, R.raw.dossreb_afinado, R.raw.dossreb_alto, "alto");
                addQuestion("DO#REb bajo",R.drawable.doreb, R.raw.dossreb_afinado, R.raw.dossreb_bajo, "bajo");
                addQuestion("DO#REb afi",R.drawable.doreb, R.raw.dossreb_afinado, R.raw.dossreb_afinado, "igual");
                //RE
                addQuestion( "RE alto",R.drawable.re, R.raw.re_afinado, R.raw.re_alto, "alto");
                addQuestion("RE bajo",R.drawable.re, R.raw.re_afinado, R.raw.re_bajo, "bajo");
                addQuestion("RE afi",R.drawable.re, R.raw.re_afinado, R.raw.re_afinado, "igual");
                //RE#MIb
                addQuestion( "RE#MIb alto",R.drawable.remib, R.raw.remib_afinado, R.raw.remib_alto, "alto");
                addQuestion("RE#MIb bajo",R.drawable.remib, R.raw.remib_afinado, R.raw.remib_bajo, "bajo");
                addQuestion("RE#MIb afi",R.drawable.remib, R.raw.remib_afinado, R.raw.remib_afinado, "igual");
                //MI
                addQuestion( "MI alto",R.drawable.mi, R.raw.mi_afinado, R.raw.mi_alto, "alto");
                addQuestion("MI bajo",R.drawable.mi, R.raw.mi_afinado, R.raw.mi_bajo, "bajo");
                addQuestion("MI afi",R.drawable.mi, R.raw.mi_afinado, R.raw.mi_afinado, "igual");
                //FA
                addQuestion( "FA alto",R.drawable.fa, R.raw.fa_afinado, R.raw.fa_alto, "alto");
                addQuestion("FA bajo",R.drawable.fa, R.raw.fa_afinado, R.raw.fa_bajo, "bajo");
                addQuestion("FA afi",R.drawable.fa, R.raw.fa_afinado, R.raw.fa_afinado, "igual");
                //FA#SOLb
                addQuestion( "FA#SOLb alto",R.drawable.fasolb, R.raw.fasolb_afinado, R.raw.fasolb_alto, "alto");
                addQuestion("FA#SOLb bajo",R.drawable.fasolb, R.raw.fasolb_afinado, R.raw.fasolb_bajo, "bajo");
                addQuestion("FA#SOLb afi",R.drawable.fasolb, R.raw.fasolb_afinado, R.raw.fasolb_afinado, "igual");
                //SOL
                addQuestion( "SOL alto",R.drawable.sol, R.raw.sol_afinado, R.raw.sol_alto, "alto");
                addQuestion("SOL bajo",R.drawable.sol, R.raw.sol_afinado, R.raw.sol_bajo, "bajo");
                addQuestion("SOL afi",R.drawable.sol, R.raw.sol_afinado, R.raw.sol_afinado, "igual");
                //SOL#LAb
                addQuestion( "SOL#LAb alto",R.drawable.solab, R.raw.sollab_afinado, R.raw.sollab_alto, "alto");
                addQuestion("SOL#LAb bajo",R.drawable.solab, R.raw.sollab_afinado, R.raw.sollab_bajo, "bajo");
                addQuestion("SOL#LAb afi",R.drawable.solab, R.raw.sollab_afinado, R.raw.sollab_afinado, "igual");
                //LA
                addQuestion( "LA alto",R.drawable.la, R.raw.la_afinado, R.raw.la_alto, "alto");
                addQuestion("LA bajo",R.drawable.la, R.raw.la_afinado, R.raw.la_bajo, "bajo");
                addQuestion("LA afi",R.drawable.la, R.raw.la_afinado, R.raw.la_afinado, "igual");
                //LA#SIb
                addQuestion( "LA#SIb alto",R.drawable.lasib, R.raw.lasib_afinado, R.raw.lasib_alto, "alto");
                addQuestion("LA#SIb bajo",R.drawable.lasib, R.raw.lasib_afinado, R.raw.lasib_bajo, "bajo");
                addQuestion("LA#SIb afi",R.drawable.lasib, R.raw.lasib_afinado, R.raw.lasib_afinado, "igual");
                //SI
                addQuestion( "SI alto",R.drawable.si, R.raw.si_afinado, R.raw.si_alto, "alto");
                addQuestion("SI bajo",R.drawable.si, R.raw.si_afinado, R.raw.si_bajo, "bajo");
                addQuestion("SI afi",R.drawable.si, R.raw.si_afinado, R.raw.si_afinado, "igual");

                //DO4 escala 4
                addQuestion( "DO4 alto",R.drawable.do4, R.raw.do4_afinado, R.raw.do4_alto, "alto");
                addQuestion("DO4 bajo",R.drawable.do4, R.raw.do4_afinado, R.raw.do4_bajo, "bajo");
                addQuestion("DO4 afi",R.drawable.do4, R.raw.do4_afinado, R.raw.do4_afinado, "igual");

                //DO#RE4 escala 4
                addQuestion( "DO#RE4 alto",R.drawable.doreb4, R.raw.doreb4_afinado, R.raw.doreb4_alto, "alto");
                addQuestion("DO#RE4 bajo",R.drawable.doreb4, R.raw.doreb4_afinado, R.raw.doreb4_bajo, "bajo");
                addQuestion("DO#RE4 afi",R.drawable.doreb4, R.raw.doreb4_afinado, R.raw.doreb4_afinado, "igual");

                //RE4 escala 4
                addQuestion( "RE4 alto",R.drawable.re4, R.raw.re4_afinado, R.raw.re4_alto, "alto");
                addQuestion("RE4 bajo",R.drawable.re4, R.raw.re4_afinado, R.raw.re4_bajo, "bajo");
                addQuestion("RE4 afi",R.drawable.re4, R.raw.re4_afinado, R.raw.re4_afinado, "igual");

                //RE#MI4 escala 4
                addQuestion( "RE#MI4 alto",R.drawable.remib4, R.raw.re4_afinado, R.raw.re4_alto, "alto");
                addQuestion("RE#MI4 bajo",R.drawable.remib4, R.raw.re4_afinado, R.raw.re4_bajo, "bajo");
                addQuestion("RE#MI4 afi",R.drawable.remib4, R.raw.re4_afinado, R.raw.re4_afinado, "igual");

                //MI4 escala 4
                addQuestion( "MI4 alto",R.drawable.mi4, R.raw.mi4_afinado, R.raw.mi4_alto, "alto");
                addQuestion("MI4 bajo",R.drawable.mi4, R.raw.mi4_afinado, R.raw.mi4_bajo, "bajo");
                addQuestion("MI4 afi",R.drawable.mi4, R.raw.mi4_afinado, R.raw.mi4_afinado, "igual");

                //FA4 escala 4
                addQuestion( "FA4 alto",R.drawable.fa4, R.raw.fa4_afinado, R.raw.fa4_alto, "alto");
                addQuestion("FA4 bajo",R.drawable.fa4, R.raw.fa4_afinado, R.raw.fa4_bajo, "bajo");
                addQuestion("FA4 afi",R.drawable.fa4, R.raw.fa4_afinado, R.raw.fa4_afinado, "igual");

                //FA#SOL4 escala 4
                addQuestion( "FA#SOL4 alto",R.drawable.fasolb4, R.raw.fasol4_afinado, R.raw.fasol4_alto, "alto");
                addQuestion("FA#SOL4 bajo",R.drawable.fasolb4, R.raw.fasol4_afinado, R.raw.fasol4_bajo, "bajo");
                addQuestion("FA#SOL4 afi",R.drawable.fasolb4, R.raw.fasol4_afinado, R.raw.fasol4_afinado, "igual");

                //SOL4 escala 4
                addQuestion( "SOL4 alto",R.drawable.sol4, R.raw.sol4_afinado, R.raw.sol4_alto, "alto");
                addQuestion("SOL4 bajo",R.drawable.sol4, R.raw.sol4_afinado, R.raw.sol4_bajo, "bajo");
                addQuestion("SOL4 afi",R.drawable.sol4, R.raw.sol4_afinado, R.raw.sol4_afinado, "igual");

                //SOL#LA4 escala 4
                addQuestion( "SOL#LA4 alto",R.drawable.solab4, R.raw.solla4_afinado, R.raw.solla4_alto, "alto");
                addQuestion("SOL#LA4 bajo",R.drawable.solab4, R.raw.solla4_afinado, R.raw.solla4_bajo, "bajo");
                addQuestion("SOL#LA4 afi",R.drawable.solab4, R.raw.solla4_afinado, R.raw.solla4_afinado, "igual");

                //LA4 escala 4
                addQuestion( "LA4 alto",R.drawable.la4, R.raw.la4_afinado, R.raw.la4_alto, "alto");
                addQuestion("LA4 bajo",R.drawable.la4, R.raw.la4_afinado, R.raw.la4_bajo, "bajo");
                addQuestion("LA4 afi",R.drawable.la4, R.raw.la4_afinado, R.raw.la4_afinado, "igual");

                //LA#SI4 escala 4
                addQuestion( "LA#SI4 alto",R.drawable.lasib4, R.raw.lasi4_afinado, R.raw.lasi4_alto, "alto");
                addQuestion("LA#SI4 bajo",R.drawable.lasib4, R.raw.lasi4_afinado, R.raw.lasi4_bajo, "bajo");
                addQuestion("LA#SI4 afi",R.drawable.lasib4, R.raw.lasi4_afinado, R.raw.lasi4_afinado, "igual");

                //SI4 escala 4
                addQuestion( "SI4 alto",R.drawable.si4, R.raw.si4_afinado, R.raw.si4_alto, "alto");
                addQuestion("SI4 bajo",R.drawable.si4, R.raw.si4_afinado, R.raw.si4_bajo, "bajo");
                addQuestion("SI4 afi",R.drawable.si4, R.raw.si4_afinado, R.raw.si4_afinado, "igual");

                //DO5 escala 5
                addQuestion( "DO5 alto",R.drawable.do5, R.raw.do5_afinado, R.raw.do5_alto, "alto");
                addQuestion("DO5 bajo",R.drawable.do5, R.raw.do5_afinado, R.raw.do5_bajo, "bajo");
                addQuestion("DO5 afi",R.drawable.do5, R.raw.do5_afinado, R.raw.do5_afinado, "igual");

                //DO#RE5 escala 5
                addQuestion( "DO#RE5 alto",R.drawable.doreb5, R.raw.dore5_afinado, R.raw.dore5_alto, "alto");
                addQuestion("DO#RE5 bajo",R.drawable.doreb5, R.raw.dore5_afinado, R.raw.dore5_bajo, "bajo");
                addQuestion("DO#RE5 afi",R.drawable.doreb5, R.raw.dore5_afinado, R.raw.dore5_afinado, "igual");

                //RE5 escala 5
                addQuestion( "RE5 alto",R.drawable.re5, R.raw.re5_afinado, R.raw.re5_alto, "alto");
                addQuestion("RE5 bajo",R.drawable.re5, R.raw.re5_afinado, R.raw.re5_bajo, "bajo");
                addQuestion("RE5 afi",R.drawable.re5, R.raw.re5_afinado, R.raw.re5_afinado, "igual");

                //RE#MI5 escala 5
                addQuestion( "RE#MI5 alto",R.drawable.remib5, R.raw.remi5_afinado, R.raw.remi5_alto, "alto");
                addQuestion("RE#MI5 bajo",R.drawable.remib5, R.raw.remi5_afinado, R.raw.remi5_bajo, "bajo");
                addQuestion("RE#MI5 afi",R.drawable.remib5, R.raw.remi5_afinado, R.raw.remi5_afinado, "igual");

                //MI5 escala 5
                addQuestion( "MI5 alto",R.drawable.mi5, R.raw.mi5_afinado, R.raw.mi5_alto, "alto");
                addQuestion("MI5 bajo",R.drawable.mi5, R.raw.mi5_afinado, R.raw.mi5_bajo, "bajo");
                addQuestion("MI5 afi",R.drawable.mi5, R.raw.mi5_afinado, R.raw.mi5_afinado, "igual");

                //FA5 escala 5
                addQuestion( "FA5 alto",R.drawable.fa5, R.raw.fa5_afinado, R.raw.fa5_alto, "alto");
                addQuestion("FA5 bajo",R.drawable.fa5, R.raw.fa5_afinado, R.raw.fa5_bajo, "bajo");
                addQuestion("FA5 afi",R.drawable.fa5, R.raw.fa5_afinado, R.raw.fa5_afinado, "igual");

                //FA#SOL5 escala 5
                addQuestion( "FA#SOL5 alto",R.drawable.fasolb5, R.raw.fasol5_afinado, R.raw.fasol5_alto, "alto");
                addQuestion("FA#SOL5 bajo",R.drawable.fasolb5, R.raw.fasol5_afinado, R.raw.fasol5_bajo, "bajo");
                addQuestion("FA#SOL5 afi",R.drawable.fasolb5, R.raw.fasol5_afinado, R.raw.fasol5_afinado, "igual");

                //SOL5 escala 5
                addQuestion( "SOL5 alto",R.drawable.sol5, R.raw.sol5_afinado, R.raw.sol5_alto, "alto");
                addQuestion("SOL5 bajo",R.drawable.sol5, R.raw.sol5_afinado, R.raw.sol5_bajo, "bajo");
                addQuestion("SOL5 afi",R.drawable.sol5, R.raw.sol5_afinado, R.raw.sol5_afinado, "igual");

                //SOL#LA5 escala 5
                addQuestion( "SOL#LA5 alto",R.drawable.solab5, R.raw.solla5_afinado, R.raw.solla5_alto, "alto");
                addQuestion("SOL#LA5 bajo",R.drawable.solab5, R.raw.solla5_afinado, R.raw.solla5_bajo, "bajo");
                addQuestion("SOL#LA5 afi",R.drawable.solab5, R.raw.solla5_afinado, R.raw.solla5_afinado, "igual");

                //LA5 escala 5
                addQuestion( "LA5 alto",R.drawable.la5, R.raw.la5_afinado, R.raw.la5_alto, "alto");
                addQuestion("LA5 bajo",R.drawable.la5, R.raw.la5_afinado, R.raw.la5_bajo, "bajo");
                addQuestion("LA5 afi",R.drawable.la5, R.raw.la5_afinado, R.raw.la5_afinado, "igual");

                //LA#SI5 escala 5
                addQuestion( "LA#SI5 alto",R.drawable.lasib5, R.raw.lasi5_afinado, R.raw.lasi5_alto, "alto");
                addQuestion("LA#SI5 bajo",R.drawable.lasib5, R.raw.lasi5_afinado, R.raw.lasi5_bajo, "bajo");
                addQuestion("LA#SI5 afi",R.drawable.lasib5, R.raw.lasi5_afinado, R.raw.lasi5_afinado, "igual");

                //SI5 escala 5
                addQuestion( "SI5 alto",R.drawable.si5, R.raw.si5_afinado, R.raw.si5_alto, "alto");
                addQuestion("SI5 bajo",R.drawable.si5, R.raw.si5_afinado, R.raw.si5_bajo, "bajo");
                addQuestion("SI5 afi",R.drawable.si5, R.raw.si5_afinado, R.raw.si5_afinado, "igual");

                //DO6 escala 6
                addQuestion( "DO6 alto",R.drawable.do6, R.raw.do6_afinado, R.raw.do6_alto, "alto");
                addQuestion("DO6 bajo",R.drawable.do6, R.raw.do6_afinado, R.raw.do6_bajo, "bajo");
                addQuestion("DO6 afi",R.drawable.do6, R.raw.do6_afinado, R.raw.do6_afinado, "igual");

                next(questions);

                break;
            case "Nivel 2":
                //DO3
                addQuestion( "DO3 alto",R.drawable.do6, R.raw.n2_do3_afinado, R.raw.n2_do4_alto, "alto");
                addQuestion("DO3 bajo",R.drawable.do6, R.raw.n2_do3_afinado, R.raw.n2_do4_bajo, "bajo");
                addQuestion("DO3 afi",R.drawable.do6, R.raw.n2_do3_afinado, R.raw.n2_do4_afinado, "igual");

                //DO4
                addQuestion( "DO4 alto",R.drawable.do6, R.raw.n2_do4_afinado, R.raw.n2_do4_alto, "alto");
                addQuestion("DO4 bajo",R.drawable.do6, R.raw.n2_do4_afinado, R.raw.n2_do4_bajo, "bajo");
                addQuestion("DO4 afi",R.drawable.do6, R.raw.n2_do4_afinado, R.raw.n2_do4_afinado, "igual");

                //DO5
                addQuestion( "DO5 alto",R.drawable.do6, R.raw.n2_do5_afinado, R.raw.n2_do5_alto, "alto");
                addQuestion("DO5 bajo",R.drawable.do6, R.raw.n2_do5_afinado, R.raw.n2_do5_bajo, "bajo");
                addQuestion("DO5 afi",R.drawable.do6, R.raw.n2_do5_afinado, R.raw.n2_do5_afinado, "igual");

                //DO6
                addQuestion( "DO6 alto",R.drawable.do6, R.raw.n2_do6_afinado, R.raw.n2_do6_alto, "alto");
                addQuestion("DO6 bajo",R.drawable.do6, R.raw.n2_do6_afinado, R.raw.n2_do6_bajo, "bajo");
                addQuestion("DO6 afi",R.drawable.do6, R.raw.n2_do6_afinado, R.raw.n2_do6_afinado, "igual");

                //DOREB3
                addQuestion( "DOREB3 alto",R.drawable.do6, R.raw.n2_doreb3_afinado, R.raw.n2_doreb3_alto, "alto");
                addQuestion("DOREB3 bajo",R.drawable.do6, R.raw.n2_doreb3_afinado, R.raw.n2_doreb3_bajo, "bajo");
                addQuestion("DOREB3 afi",R.drawable.do6, R.raw.n2_doreb3_afinado, R.raw.n2_doreb3_afinado, "igual");

                //DOREB4
                addQuestion( "DOREB4 alto",R.drawable.do6, R.raw.n2_doreb4_afinado, R.raw.n2_doreb4_alto, "alto");
                addQuestion("DOREB4 bajo",R.drawable.do6, R.raw.n2_doreb4_afinado, R.raw.n2_doreb4_bajo, "bajo");
                addQuestion("DOREB4 afi",R.drawable.do6, R.raw.n2_doreb4_afinado, R.raw.n2_doreb4_afinado, "igual");

                //DOREB5
                addQuestion( "DOREB5 alto",R.drawable.do6, R.raw.n2_doreb5_afinado, R.raw.n2_doreb5_alto, "alto");
                addQuestion("DOREB5 bajo",R.drawable.do6, R.raw.n2_doreb5_afinado, R.raw.n2_doreb5_bajo, "bajo");
                addQuestion("DOREB5 afi",R.drawable.do6, R.raw.n2_doreb5_afinado, R.raw.n2_doreb5_afinado, "igual");

                //FA3
                addQuestion( "FA3 alto",R.drawable.do6, R.raw.n2_fa3_afinado, R.raw.n2_fa3_alto, "alto");
                addQuestion("FA3 bajo",R.drawable.do6, R.raw.n2_fa3_afinado, R.raw.n2_fa3_bajo, "bajo");
                addQuestion("FA3 afi",R.drawable.do6, R.raw.n2_fa3_afinado, R.raw.n2_fa3_afinado, "igual");

                //FA4
                addQuestion( "FA4 alto",R.drawable.do6, R.raw.n2_fa4_afinado, R.raw.n2_fa4_alto, "alto");
                addQuestion("FA4 bajo",R.drawable.do6, R.raw.n2_fa4_afinado, R.raw.n2_fa4_bajo, "bajo");
                addQuestion("FA4 afi",R.drawable.do6, R.raw.n2_fa4_afinado, R.raw.n2_fa4_afinado, "igual");

                //FA5
                addQuestion( "FA5 alto",R.drawable.do6, R.raw.n2_fa5_afinado, R.raw.n2_fa5_alto, "alto");
                addQuestion("FA5 bajo",R.drawable.do6, R.raw.n2_fa5_afinado, R.raw.n2_fa5_bajo, "bajo");
                addQuestion("FA5 afi",R.drawable.do6, R.raw.n2_fa5_afinado, R.raw.n2_fa5_afinado, "igual");

                //FASOLB3
                addQuestion( "FASOLB3 alto",R.drawable.do6, R.raw.n2_fasolb3_afinado, R.raw.n2_fasolb3_alto, "alto");
                addQuestion("FASOLB3 bajo",R.drawable.do6, R.raw.n2_fasolb3_afinado, R.raw.n2_fasolb3_bajo, "bajo");
                addQuestion("FASOLB3 afi",R.drawable.do6, R.raw.n2_fasolb3_afinado, R.raw.n2_fasolb3_afinado, "igual");

                //FASOLB4
                addQuestion( "FASOLB4 alto",R.drawable.do6, R.raw.n2_fasolb4_afinado, R.raw.n2_fasolb4_alto, "alto");
                addQuestion("FASOLB4 bajo",R.drawable.do6, R.raw.n2_fasolb4_afinado, R.raw.n2_fasolb4_bajo, "bajo");
                addQuestion("FASOLB4 afi",R.drawable.do6, R.raw.n2_fasolb4_afinado, R.raw.n2_fasolb4_afinado, "igual");

                //FASOLB5
                addQuestion( "FASOLB5 alto",R.drawable.do6, R.raw.n2_fasolb5_afinado, R.raw.n2_fasolb5_alto, "alto");
                addQuestion("FASOLB5 bajo",R.drawable.do6, R.raw.n2_fasolb5_afinado, R.raw.n2_fasolb5_bajo, "bajo");
                addQuestion("FASOLB5 afi",R.drawable.do6, R.raw.n2_fasolb5_afinado, R.raw.n2_fasolb5_afinado, "igual");

                //LA3
                addQuestion( "LA3 alto",R.drawable.do6, R.raw.n2_la3_afinado, R.raw.n2_la3_alto, "alto");
                addQuestion("LA3 bajo",R.drawable.do6, R.raw.n2_la3_afinado, R.raw.n2_la3_bajo, "bajo");
                addQuestion("LA3 afi",R.drawable.do6, R.raw.n2_la3_afinado, R.raw.n2_la3_afinado, "igual");

                //LA4
                addQuestion( "LA4 alto",R.drawable.do6, R.raw.n2_la4_afinado, R.raw.n2_la4_alto, "alto");
                addQuestion("LA4 bajo",R.drawable.do6, R.raw.n2_la4_afinado, R.raw.n2_la4_bajo, "bajo");
                addQuestion("LA4 afi",R.drawable.do6, R.raw.n2_la4_afinado, R.raw.n2_la4_afinado, "igual");

                //LA5
                addQuestion( "LA5 alto",R.drawable.do6, R.raw.n2_la5_afinado, R.raw.n2_la5_alto, "alto");
                addQuestion("LA5 bajo",R.drawable.do6, R.raw.n2_la5_afinado, R.raw.n2_la5_bajo, "bajo");
                addQuestion("LA5 afi",R.drawable.do6, R.raw.n2_la5_afinado, R.raw.n2_la5_afinado, "igual");

                //LASIB3
                addQuestion( "LASIB3 alto",R.drawable.do6, R.raw.n2_lasib3_afinado, R.raw.n2_lasib3_alto, "alto");
                addQuestion("LASIB3 bajo",R.drawable.do6, R.raw.n2_lasib3_afinado, R.raw.n2_lasib3_bajo, "bajo");
                addQuestion("LASIB3 afi",R.drawable.do6, R.raw.n2_lasib3_afinado, R.raw.n2_lasib3_afinado, "igual");

                //LASIB4
                addQuestion( "LASIB4 alto",R.drawable.do6, R.raw.n2_lasib4_afinado, R.raw.n2_lasib4_alto, "alto");
                addQuestion("LASIB4 bajo",R.drawable.do6, R.raw.n2_lasib4_afinado, R.raw.n2_lasib4_bajo, "bajo");
                addQuestion("LASIB4 afi",R.drawable.do6, R.raw.n2_lasib4_afinado, R.raw.n2_lasib4_afinado, "igual");

                //LASIB5
                addQuestion( "LASIB5 alto",R.drawable.do6, R.raw.n2_lasib5_afinado, R.raw.n2_lasib5_alto, "alto");
                addQuestion("LASIB5 bajo",R.drawable.do6, R.raw.n2_lasib5_afinado, R.raw.n2_lasib5_bajo, "bajo");
                addQuestion("LASIB5 afi",R.drawable.do6, R.raw.n2_lasib5_afinado, R.raw.n2_lasib5_afinado, "igual");

                //MI3
                addQuestion( "MI3 alto",R.drawable.do6, R.raw.n2_mi3_afinado, R.raw.n2_mi3_alto, "alto");
                addQuestion("MI3 bajo",R.drawable.do6, R.raw.n2_mi3_afinado, R.raw.n2_mi3_bajo, "bajo");
                addQuestion("MI3 afi",R.drawable.do6, R.raw.n2_mi3_afinado, R.raw.n2_mi3_afinado, "igual");

                //MI4
                addQuestion( "MI4 alto",R.drawable.do6, R.raw.n2_mi4_afinado, R.raw.n2_mi4_alto, "alto");
                addQuestion("MI4 bajo",R.drawable.do6, R.raw.n2_mi4_afinado, R.raw.n2_mi4_bajo, "bajo");
                addQuestion("MI4 afi",R.drawable.do6, R.raw.n2_mi4_afinado, R.raw.n2_mi4_afinado, "igual");

                //MI5
                addQuestion( "MI5 alto",R.drawable.do6, R.raw.n2_mi5_afinado, R.raw.n2_mi5_alto, "alto");
                addQuestion("MI5 bajo",R.drawable.do6, R.raw.n2_mi5_afinado, R.raw.n2_mi5_bajo, "bajo");
                addQuestion("MI5 afi",R.drawable.do6, R.raw.n2_mi5_afinado, R.raw.n2_mi5_afinado, "igual");

                //RE3
                addQuestion( "RE3 alto",R.drawable.do6, R.raw.n2_re3_afinado, R.raw.n2_re3_alto, "alto");
                addQuestion("RE3 bajo",R.drawable.do6, R.raw.n2_re3_afinado, R.raw.n2_re3_bajo, "bajo");
                addQuestion("RE3 afi",R.drawable.do6, R.raw.n2_re3_afinado, R.raw.n2_re3_afinado, "igual");

                //RE4
                addQuestion( "RE4 alto",R.drawable.do6, R.raw.n2_re4_afinado, R.raw.n2_re4_alto, "alto");
                addQuestion("RE4 bajo",R.drawable.do6, R.raw.n2_re4_afinado, R.raw.n2_re4_bajo, "bajo");
                addQuestion("RE4 afi",R.drawable.do6, R.raw.n2_re4_afinado, R.raw.n2_re4_afinado, "igual");

                //RE5
                addQuestion( "RE5 alto",R.drawable.do6, R.raw.n2_re5_afinado, R.raw.n2_re5_alto, "alto");
                addQuestion("RE5 bajo",R.drawable.do6, R.raw.n2_re5_afinado, R.raw.n2_re5_bajo, "bajo");
                addQuestion("RE5 afi",R.drawable.do6, R.raw.n2_re5_afinado, R.raw.n2_re5_afinado, "igual");

                //REMIB3
                addQuestion( "REMIB3 alto",R.drawable.do6, R.raw.n2_remib3_afinado, R.raw.n2_remib3_alto, "alto");
                addQuestion("REMIB3 bajo",R.drawable.do6, R.raw.n2_remib3_afinado, R.raw.n2_remib3_bajo, "bajo");
                addQuestion("REMIB3 afi",R.drawable.do6, R.raw.n2_remib3_afinado, R.raw.n2_remib3_afinado, "igual");

                //REMIB4
                addQuestion( "REMIB4 alto",R.drawable.do6, R.raw.n2_remib4_afinado, R.raw.n2_remib4_alto, "alto");
                addQuestion("REMIB4 bajo",R.drawable.do6, R.raw.n2_remib4_afinado, R.raw.n2_remib4_bajo, "bajo");
                addQuestion("REMIB4 afi",R.drawable.do6, R.raw.n2_remib4_afinado, R.raw.n2_remib4_afinado, "igual");

                //REMIB5
                addQuestion( "REMIB5 alto",R.drawable.do6, R.raw.n2_remib5_afinado, R.raw.n2_remib5_alto, "alto");
                addQuestion("REMIB5 bajo",R.drawable.do6, R.raw.n2_remib5_afinado, R.raw.n2_remib5_bajo, "bajo");
                addQuestion("REMIB5 afi",R.drawable.do6, R.raw.n2_remib5_afinado, R.raw.n2_remib5_afinado, "igual");

                //SI3
                addQuestion( "SI3 alto",R.drawable.do6, R.raw.n2_si3_afinado, R.raw.n2_si3_alto, "alto");
                addQuestion("SI3 bajo",R.drawable.do6, R.raw.n2_si3_afinado, R.raw.n2_si3_bajo, "bajo");
                addQuestion("SI3 afi",R.drawable.do6, R.raw.n2_si3_afinado, R.raw.n2_si3_afinado, "igual");

                //SI4
                addQuestion( "SI4 alto",R.drawable.do6, R.raw.n2_si4_afinado, R.raw.n2_si4_alto, "alto");
                addQuestion("SI4 bajo",R.drawable.do6, R.raw.n2_si4_afinado, R.raw.n2_si4_bajo, "bajo");
                addQuestion("SI4 afi",R.drawable.do6, R.raw.n2_si4_afinado, R.raw.n2_si4_afinado, "igual");

                //SI5
                addQuestion( "SI5 alto",R.drawable.do6, R.raw.n2_si5_afinado, R.raw.n2_si5_alto, "alto");
                addQuestion("SI5 bajo",R.drawable.do6, R.raw.n2_si5_afinado, R.raw.n2_si5_bajo, "bajo");
                addQuestion("SI5 afi",R.drawable.do6, R.raw.n2_si5_afinado, R.raw.n2_si5_afinado, "igual");

                //SOL3
                addQuestion( "SOL3 alto",R.drawable.do6, R.raw.n2_sol3_afinado, R.raw.n2_sol3_alto, "alto");
                addQuestion("SOL3 bajo",R.drawable.do6, R.raw.n2_sol3_afinado, R.raw.n2_sol3_bajo, "bajo");
                addQuestion("SOL3 afi",R.drawable.do6, R.raw.n2_sol3_afinado, R.raw.n2_sol3_afinado, "igual");

                //SOL4
                addQuestion( "SOL4 alto",R.drawable.do6, R.raw.n2_sol4_afinado, R.raw.n2_sol4_alto, "alto");
                addQuestion("SOL4 bajo",R.drawable.do6, R.raw.n2_sol4_afinado, R.raw.n2_sol4_bajo, "bajo");
                addQuestion("SOL4 afi",R.drawable.do6, R.raw.n2_sol4_afinado, R.raw.n2_sol4_afinado, "igual");

                //SOL5
                addQuestion( "SOL5 alto",R.drawable.do6, R.raw.n2_sol5_afinado, R.raw.n2_sol5_alto, "alto");
                addQuestion("SOL5 bajo",R.drawable.do6, R.raw.n2_sol5_afinado, R.raw.n2_sol5_bajo, "bajo");
                addQuestion("SOL5 afi",R.drawable.do6, R.raw.n2_sol5_afinado, R.raw.n2_sol5_afinado, "igual");

                //SOLLAB3
                addQuestion( "SOLLAB3 alto",R.drawable.do6, R.raw.n2_sollab3_afinado, R.raw.n2_sollab3_alto, "alto");
                addQuestion("SOLLAB3 bajo",R.drawable.do6, R.raw.n2_sollab3_afinado, R.raw.n2_sollab3_bajo, "bajo");
                addQuestion("SOLLAB3 afi",R.drawable.do6, R.raw.n2_sollab3_afinado, R.raw.n2_sollab3_afinado, "igual");

                //SOLLAB4
                addQuestion( "SOLLAB4 alto",R.drawable.do6, R.raw.n2_sollab4_afinado, R.raw.n2_sollab4_alto, "alto");
                addQuestion("SOLLAB4 bajo",R.drawable.do6, R.raw.n2_sollab4_afinado, R.raw.n2_sollab4_bajo, "bajo");
                addQuestion("SOLLAB4 afi",R.drawable.do6, R.raw.n2_sollab4_afinado, R.raw.n2_sollab4_afinado, "igual");

                //SOLLAB5
                addQuestion( "SOLLAB5 alto",R.drawable.do6, R.raw.n2_sollab5_afinado, R.raw.n2_sollab5_alto, "alto");
                addQuestion("SOLLAB5 bajo",R.drawable.do6, R.raw.n2_sollab5_afinado, R.raw.n2_sollab5_bajo, "bajo");
                addQuestion("SOLLAB5 afi",R.drawable.do6, R.raw.n2_sollab5_afinado, R.raw.n2_sollab5_afinado, "igual");

                next(questions);
                break;
            case  "Nivel 3":

                //DO3
                addQuestion( "DO3 alto",R.drawable.do6, R.raw.n3_do3_afinado, R.raw.n3_do3_alto, "alto");
                addQuestion("DO3 bajo",R.drawable.do6, R.raw.n3_do3_afinado, R.raw.n3_do3_bajo, "bajo");
                addQuestion("DO3 afi",R.drawable.do6, R.raw.n3_do3_afinado, R.raw.n3_do3_afinado, "igual");

                //DO4
                addQuestion( "DO4 alto",R.drawable.do6, R.raw.n3_do4_afinado, R.raw.n3_do4_alto, "alto");
                addQuestion("DO4 bajo",R.drawable.do6, R.raw.n3_do4_afinado, R.raw.n3_do4_bajo, "bajo");
                addQuestion("DO4 afi",R.drawable.do6, R.raw.n3_do4_afinado, R.raw.n3_do4_afinado, "igual");

                //DO5
                addQuestion( "DO5 alto",R.drawable.do6, R.raw.n3_do5_afinado, R.raw.n3_do5_alto, "alto");
                addQuestion("DO5 bajo",R.drawable.do6, R.raw.n3_do5_afinado, R.raw.n3_do5_bajo, "bajo");
                addQuestion("DO5 afi",R.drawable.do6, R.raw.n3_do5_afinado, R.raw.n3_do5_afinado, "igual");

                //DO6
                addQuestion( "DO6 alto",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_alto, "alto");
                addQuestion("DO6 bajo",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_bajo, "bajo");
                addQuestion("DO6 afi",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_afinado, "igual");

                //DOREB3
                addQuestion( "DOREB3 alto",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_alto, "alto");
                addQuestion("DOREB3 bajo",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_bajo, "bajo");
                addQuestion("DOREB3 afi",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_afinado, "igual");

                //DOREB4
                addQuestion( "DOREB4 alto",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_alto, "alto");
                addQuestion("DOREB4 bajo",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_bajo, "bajo");
                addQuestion("DOREB4 afi",R.drawable.do6, R.raw.n3_do6_afinado, R.raw.n3_do6_afinado, "igual");

                //DOREB5
                addQuestion( "DOREB5 alto",R.drawable.do6, R.raw.n3_do5_afinado, R.raw.n3_do5_alto, "alto");
                addQuestion("DOREB5 bajo",R.drawable.do6, R.raw.n3_do5_afinado, R.raw.n3_do5_bajo, "bajo");
                addQuestion("DOREB5 afi",R.drawable.do6, R.raw.n3_do5_afinado, R.raw.n3_do5_afinado, "igual");

                //FA3
                addQuestion( "FA3 alto",R.drawable.do6, R.raw.n3_fa3_afinado, R.raw.n3_fa3_alto, "alto");
                addQuestion("FA3 bajo",R.drawable.do6, R.raw.n3_fa3_afinado, R.raw.n3_fa3_bajo, "bajo");
                addQuestion("FA3 afi",R.drawable.do6, R.raw.n3_fa3_afinado, R.raw.n3_fa3_afinado, "igual");

                //FA4
                addQuestion( "FA4 alto",R.drawable.do6, R.raw.n3_fa4_afinado, R.raw.n3_fa4_alto, "alto");
                addQuestion("FA4 bajo",R.drawable.do6, R.raw.n3_fa4_afinado, R.raw.n3_fa4_bajo, "bajo");
                addQuestion("FA4 afi",R.drawable.do6, R.raw.n3_fa4_afinado, R.raw.n3_fa4_afinado, "igual");

                //FA5
                addQuestion( "FA5 alto",R.drawable.do6, R.raw.n3_fa5_afinado, R.raw.n3_fa5_alto, "alto");
                addQuestion("FA5 bajo",R.drawable.do6, R.raw.n3_fa5_afinado, R.raw.n3_fa5_bajo, "bajo");
                addQuestion("FA5 afi",R.drawable.do6, R.raw.n3_fa5_afinado, R.raw.n3_fa5_afinado, "igual");

                //FASOLB3
                addQuestion( "FASOLB3 alto",R.drawable.do6, R.raw.n3_fasolb3_afinado, R.raw.n3_fasolb3_alto, "alto");
                addQuestion("FASOLB3 bajo",R.drawable.do6, R.raw.n3_fasolb3_afinado, R.raw.n3_fasolb3_bajo, "bajo");
                addQuestion("FASOLB3 afi",R.drawable.do6, R.raw.n3_fasolb3_afinado, R.raw.n3_fasolb3_afinado, "igual");

                //FASOLB4
                addQuestion( "FASOLB4 alto",R.drawable.do6, R.raw.n3_fasolb4_afinado, R.raw.n3_fasolb4_alto, "alto");
                addQuestion("FASOLB4 bajo",R.drawable.do6, R.raw.n3_fasolb4_afinado, R.raw.n3_fasolb4_bajo, "bajo");
                addQuestion("FASOLB4 afi",R.drawable.do6, R.raw.n3_fasolb4_afinado, R.raw.n3_fasolb4_afinado, "igual");

                //FASOLB5
                addQuestion( "FASOLB5 alto",R.drawable.do6, R.raw.n3_fasolb5_afinado, R.raw.n3_fasolb5_alto, "alto");
                addQuestion("FASOLB5 bajo",R.drawable.do6, R.raw.n3_fasolb5_afinado, R.raw.n3_fasolb5_bajo, "bajo");
                addQuestion("FASOLB5 afi",R.drawable.do6, R.raw.n3_fasolb5_afinado, R.raw.n3_fasolb5_afinado, "igual");

                //LA3
                addQuestion( "LA3 alto",R.drawable.do6, R.raw.n3_la3_afinado, R.raw.n3_la3_alto, "alto");
                addQuestion("LA3 bajo",R.drawable.do6, R.raw.n3_la3_afinado, R.raw.n3_la3_bajo, "bajo");
                addQuestion("LA3 afi",R.drawable.do6, R.raw.n3_la3_afinado, R.raw.n3_la3_afinado, "igual");

                //LA4
                addQuestion( "LA4 alto",R.drawable.do6, R.raw.n3_la4_afinado, R.raw.n3_la4_alto, "alto");
                addQuestion("LA4 bajo",R.drawable.do6, R.raw.n3_la4_afinado, R.raw.n3_la4_bajo, "bajo");
                addQuestion("LA4 afi",R.drawable.do6, R.raw.n3_la4_afinado, R.raw.n3_la4_afinado, "igual");

                //LA5
                addQuestion( "LA5 alto",R.drawable.do6, R.raw.n3_la5_afinado, R.raw.n3_la5_alto, "alto");
                addQuestion("LA5 bajo",R.drawable.do6, R.raw.n3_la5_afinado, R.raw.n3_la5_bajo, "bajo");
                addQuestion("LA5 afi",R.drawable.do6, R.raw.n3_la5_afinado, R.raw.n3_la5_afinado, "igual");

                //LASIB3
                addQuestion( "LASIB3 alto",R.drawable.do6, R.raw.n3_lasib3_afinado, R.raw.n3_lasib3_alto, "alto");
                addQuestion("LASIB3 bajo",R.drawable.do6, R.raw.n3_lasib3_afinado, R.raw.n3_lasib3_bajo, "bajo");
                addQuestion("LASIB3 afi",R.drawable.do6, R.raw.n3_lasib3_afinado, R.raw.n3_lasib3_afinado, "igual");

                //LASIB4
                addQuestion( "LASIB4 alto",R.drawable.do6, R.raw.n3_lasib4_afinado, R.raw.n3_lasib4_alto, "alto");
                addQuestion("LASIB4 bajo",R.drawable.do6, R.raw.n3_lasib4_afinado, R.raw.n3_lasib4_bajo, "bajo");
                addQuestion("LASIB4 afi",R.drawable.do6, R.raw.n3_lasib4_afinado, R.raw.n3_lasib4_afinado, "igual");

                //LASIB5
                addQuestion( "LASIB5 alto",R.drawable.do6, R.raw.n3_lasib5_afinado, R.raw.n3_lasib5_alto, "alto");
                addQuestion("LASIB5 bajo",R.drawable.do6, R.raw.n3_lasib5_afinado, R.raw.n3_lasib5_bajo, "bajo");
                addQuestion("LASIB5 afi",R.drawable.do6, R.raw.n3_lasib5_afinado, R.raw.n3_lasib5_afinado, "igual");

                //MI3
                addQuestion( "MI3 alto",R.drawable.do6, R.raw.n3_mi3_afinado, R.raw.n3_mi3_alto, "alto");
                addQuestion("MI3 bajo",R.drawable.do6, R.raw.n3_mi3_afinado, R.raw.n3_mi3_bajo, "bajo");
                addQuestion("MI3 afi",R.drawable.do6, R.raw.n3_mi3_afinado, R.raw.n3_mi3_afinado, "igual");

                //MI4
                addQuestion( "MI4 alto",R.drawable.do6, R.raw.n3_mi4_afinado, R.raw.n3_mi4_alto, "alto");
                addQuestion("MI4 bajo",R.drawable.do6, R.raw.n3_mi4_afinado, R.raw.n3_mi4_bajo, "bajo");
                addQuestion("MI4 afi",R.drawable.do6, R.raw.n3_mi4_afinado, R.raw.n3_mi4_afinado, "igual");

                //MI5
                addQuestion( "MI5 alto",R.drawable.do6, R.raw.n3_mi5_afinado, R.raw.n3_mi5_alto, "alto");
                addQuestion("MI5 bajo",R.drawable.do6, R.raw.n3_mi5_afinado, R.raw.n3_mi5_bajo, "bajo");
                addQuestion("MI5 afi",R.drawable.do6, R.raw.n3_mi5_afinado, R.raw.n3_mi5_afinado, "igual");

                //RE3
                addQuestion( "RE3 alto",R.drawable.do6, R.raw.n3_re3_afinado, R.raw.n3_re3_alto, "alto");
                addQuestion("RE3 bajo",R.drawable.do6, R.raw.n3_re3_afinado, R.raw.n3_re3_bajo, "bajo");
                addQuestion("RE3 afi",R.drawable.do6, R.raw.n3_re3_afinado, R.raw.n3_re3_afinado, "igual");

                //RE4
                addQuestion( "RE4 alto",R.drawable.do6, R.raw.n3_re4_afinado, R.raw.n3_re4_alto, "alto");
                addQuestion("RE4 bajo",R.drawable.do6, R.raw.n3_re4_afinado, R.raw.n3_re4_bajo, "bajo");
                addQuestion("RE4 afi",R.drawable.do6, R.raw.n3_re4_afinado, R.raw.n3_re4_afinado, "igual");

                //RE5
                addQuestion( "RE5 alto",R.drawable.do6, R.raw.n3_re5_afinado, R.raw.n3_re5_alto, "alto");
                addQuestion("RE5 bajo",R.drawable.do6, R.raw.n3_re5_afinado, R.raw.n3_re5_bajo, "bajo");
                addQuestion("RE5 afi",R.drawable.do6, R.raw.n3_re5_afinado, R.raw.n3_re5_afinado, "igual");

                //REMIB3
                addQuestion( "REMIB3 alto",R.drawable.do6, R.raw.n3_remib3_afinado, R.raw.n3_remib3_alto, "alto");
                addQuestion("REMIB3 bajo",R.drawable.do6, R.raw.n3_remib3_afinado, R.raw.n3_remib3_bajo, "bajo");
                addQuestion("REMIB3 afi",R.drawable.do6, R.raw.n3_remib3_afinado, R.raw.n3_remib3_afinado, "igual");

                //REMIB4
                addQuestion( "REMIB4 alto",R.drawable.do6, R.raw.n3_remib4_afinado, R.raw.n3_remib4_alto, "alto");
                addQuestion("REMIB4 bajo",R.drawable.do6, R.raw.n3_remib4_afinado, R.raw.n3_remib4_bajo, "bajo");
                addQuestion("REMIB4 afi",R.drawable.do6, R.raw.n3_remib4_afinado, R.raw.n3_remib4_afinado, "igual");

                //REMIB5
                addQuestion( "REMIB5 alto",R.drawable.do6, R.raw.n3_remib5_afinado, R.raw.n3_remib5_alto, "alto");
                addQuestion("REMIB5 bajo",R.drawable.do6, R.raw.n3_remib5_afinado, R.raw.n3_remib5_bajo, "bajo");
                addQuestion("REMIB5 afi",R.drawable.do6, R.raw.n3_remib5_afinado, R.raw.n3_remib5_afinado, "igual");

                //SI3
                addQuestion( "SI3 alto",R.drawable.do6, R.raw.n3_si3_afinado, R.raw.n3_si3_alto, "alto");
                addQuestion("SI3 bajo",R.drawable.do6, R.raw.n3_si3_afinado, R.raw.n3_si3_bajo, "bajo");
                addQuestion("SI3 afi",R.drawable.do6, R.raw.n3_si3_afinado, R.raw.n3_si3_afinado, "igual");

                //SI4
                addQuestion( "SI4 alto",R.drawable.do6, R.raw.n3_si4_afinado, R.raw.n3_si4_alto, "alto");
                addQuestion("SI4 bajo",R.drawable.do6, R.raw.n3_si4_afinado, R.raw.n3_si4_bajo, "bajo");
                addQuestion("SI4 afi",R.drawable.do6, R.raw.n3_si4_afinado, R.raw.n3_si4_afinado, "igual");

                //SI5
                addQuestion( "SI5 alto",R.drawable.do6, R.raw.n3_si5_afinado, R.raw.n3_si5_alto, "alto");
                addQuestion("SI5 bajo",R.drawable.do6, R.raw.n3_si5_afinado, R.raw.n3_si5_bajo, "bajo");
                addQuestion("SI5 afi",R.drawable.do6, R.raw.n3_si5_afinado, R.raw.n3_si5_afinado, "igual");

                //SOL3
                addQuestion( "SOL3 alto",R.drawable.do6, R.raw.n3_sol3_afinado, R.raw.n3_sol3_alto, "alto");
                addQuestion("SOL3 bajo",R.drawable.do6, R.raw.n3_sol3_afinado, R.raw.n3_sol3_bajo, "bajo");
                addQuestion("SOL3 afi",R.drawable.do6, R.raw.n3_sol3_afinado, R.raw.n3_sol3_afinado, "igual");

                //SOL4
                addQuestion( "SOL4 alto",R.drawable.do6, R.raw.n3_sol4_afinado, R.raw.n3_sol4_alto, "alto");
                addQuestion("SOL4 bajo",R.drawable.do6, R.raw.n3_sol4_afinado, R.raw.n3_sol4_bajo, "bajo");
                addQuestion("SOL4 afi",R.drawable.do6, R.raw.n3_sol4_afinado, R.raw.n3_sol4_afinado, "igual");

                //SOL5
                addQuestion( "SOL5 alto",R.drawable.do6, R.raw.n3_sol5_afinado, R.raw.n3_sol5_alto, "alto");
                addQuestion("SOL5 bajo",R.drawable.do6, R.raw.n3_sol5_afinado, R.raw.n3_sol5_bajo, "bajo");
                addQuestion("SOL5 afi",R.drawable.do6, R.raw.n3_sol5_afinado, R.raw.n3_sol5_afinado, "igual");

                //SOLLAB3
                addQuestion( "SOLLAB3 alto",R.drawable.do6, R.raw.n3_sollab3_afinado, R.raw.n3_sollab3_alto, "alto");
                addQuestion("SOLLAB3 bajo",R.drawable.do6, R.raw.n3_sollab3_afinado, R.raw.n3_sollab3_bajo, "bajo");
                addQuestion("SOLLAB3 afi",R.drawable.do6, R.raw.n3_sollab3_afinado, R.raw.n3_sollab3_afinado, "igual");

                //SOLLAB4
                addQuestion( "SOLLAB4 alto",R.drawable.do6, R.raw.n3_sollab4_afinado, R.raw.n3_sollab4_alto, "alto");
                addQuestion("SOLLAB4 bajo",R.drawable.do6, R.raw.n3_sollab4_afinado, R.raw.n3_sollab4_bajo, "bajo");
                addQuestion("SOLLAB4 afi",R.drawable.do6, R.raw.n3_sollab4_afinado, R.raw.n3_sollab4_afinado, "igual");

                //SOLLAB5
                addQuestion( "SOLLAB5 alto",R.drawable.do6, R.raw.n3_sollab5_afinado, R.raw.n3_sollab5_alto, "alto");
                addQuestion("SOLLAB5 bajo",R.drawable.do6, R.raw.n3_sollab5_afinado, R.raw.n3_sollab5_bajo, "bajo");
                addQuestion("SOLLAB5 afi",R.drawable.do6, R.raw.n3_sollab5_afinado, R.raw.n3_sollab5_afinado, "igual");

                next(questions);
                break;
        }

        time = new Timer();
        Abandonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFinishing()) { // Verificar si la actividad aún está en un estado válido
                    new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("¿Seguro que quieres abandonar?")
                            .setContentText("Se perderá el progreso.")
                            .setConfirmText("Si")
                            .setCancelText("No")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    // Si el usuario hace clic en "Si", finaliza la actividad y realiza la transición de cierre
                                    finish();
                                    overridePendingTransition(R.anim.radial_transition, 0);
                                    sweetAlertDialog.dismissWithAnimation(); // Cierra la alerta con una animación
                                }
                            })
                            .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    // Si el usuario hace clic en "No", simplemente cierra la alerta
                                    sweetAlertDialog.dismissWithAnimation(); // Cierra la alerta con una animación
                                }
                            })
                            .show();
                }
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
    public static void addQuestion(String lettermusic, int music , int bar1, int bar2, String correct) {
        Map<String, Object> questionMap = new HashMap<>();
        questionMap.put("lettermusic", lettermusic);
        questionMap.put("music", music);
        questionMap.put("bar1", bar1);
        questionMap.put("bar2", bar2);
        questionMap.put("correct", correct);
        questions.add(questionMap);
    }
    public void next(List<Map<String, Object>> qqs) {
        Random random = new Random();
        int randomIndex = random.nextInt(qqs.size());
        Map<String, Object> randomQuestion = qqs.get(randomIndex);
        int viewmusic = (int) randomQuestion.get("music");
        int principalsound = (int) randomQuestion.get("bar1");
        int secundarysound = (int) randomQuestion.get("bar2");
        String mletter = (String) randomQuestion.get("lettermusic");
        String rpta = (String) randomQuestion.get("correct");
        System.out.println(qqs.size() + ": este es el tamaño");
        System.out.println(mletter + ": este es la nota y esta es la respuesta: " + rpta);
        exercise(viewmusic,principalsound, secundarysound, mletter,rpta);
    }

    // Método para actualizar el puntaje
    private void updateScore(int points) {
        String currentScoreText = scoreCounter.getText().toString();
        // Elimina cualquier texto adicional y deja solo el número
        String scoreText = currentScoreText.replaceAll("\\D+", "");
        int currentScore = Integer.parseInt(scoreText);
        currentScore += points; // Suma los puntos al puntaje actual
        puntajeActual += points;
        scoreCounter.setText("0"); // Establece el puntaje inicial a 0
        scoreCounter.setText(String.valueOf(currentScore)); // Actualiza el TextView del puntaje
    }

    public void exercise(int view, int primary, int secondary, String ml, String response) {
        exerciseasy++; // Incrementa el contador de preguntas
        updateQuestionCounter(); // Actualiza el contador de preguntas
        if (exerciseasy >= 10) {
            // Mostrar resultado durante 3 segundos antes de pasar a la siguiente actividad
            Alto.setEnabled(false);
            Igual.setEnabled(false);
            Bajo.setEnabled(false);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Nveles_Activity.this, Details_Activity.class);
                    intent.putExtra("puntos", puntajeActual);
                    startActivity(intent);
                    finish(); // Finalizar la actividad actual
                    questions.clear();
                    overridePendingTransition(R.anim.radial_transition, 0);
                }
            }, 2000); // 3000 milisegundos = 3 segundos
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
        musicview = findViewById(R.id.imagemusic);
        music.setText(ml);
        musicview.setImageResource(view);

        Alto = findViewById(R.id.btnAlto);
        Bajo = findViewById(R.id.btnBajo);
        Igual = findViewById(R.id.btnIgual);

        Alto.setBackground(getDrawable(R.drawable.ic_arriba));
        Bajo.setBackground(getDrawable(R.drawable.ic_abajo));
        Igual.setBackground(getDrawable(R.drawable.ic_igual));

        if (response.equals("alto")){
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(10); // Suma 10 puntos al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9) {
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Buen trabajo")
                                .setContentText("+10 puntos")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Entrena tu oido")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Entrena tu oido")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
        } else if (response.equals("bajo")) {
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Entrena tu oido")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(10); // Suma 10 puntos al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Buen trabajo")
                                .setContentText("+10 puntos")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                        //Toast.makeText(getApplicationContext(), "Buen trabajo siguiente nivel", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Entrena tu oido")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
        } else {
            Alto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Entrena tu oido")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Bajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(0); // no suma al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.ERROR_TYPE)
                                .setTitleText("Entrena tu oido")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                        //Toast.makeText(getApplicationContext(), "Entrena tu oido", Toast.LENGTH_SHORT).show();
                    }
                    next(questions); // Pasar a la siguiente pregunta
                }
            });
            Igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    updateScore(10); // Suma 10 puntos al puntaje
                    if (exerciseasy >= 0 && exerciseasy <= 9){
                        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(Nveles_Activity.this, SweetAlertDialog.SUCCESS_TYPE)
                                .setTitleText("Buen trabajo")
                                .setContentText("+10 puntos")
                                .showCancelButton(false)
                                .setCancelClickListener(null)
                                .setConfirmClickListener(null);

                        // Ocultar el botón de confirmación
                        sweetAlertDialog.hideConfirmButton();
                        sweetAlertDialog.show();

                        // Programar la desaparición de la alerta después de 1 segundo
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                sweetAlertDialog.dismiss();
                            }
                        }, 1000); // 1000 milisegundos = 1 segundo
                        //Toast.makeText(getApplicationContext(), "Buen trabajo siguiente nivel", Toast.LENGTH_SHORT).show();
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
                playButton.setText("Play");
            } else {
                player.start();
                startUpdatingSeekBar(player, seekBar);
                playButton.setText("Stop");
            }
        });

        player.setOnCompletionListener(mp -> {
            seekBar.setProgress(0);
            stopUpdatingSeekBar(player);
            playButton.setText("Play");
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