package com.example.practica1_pregculturageneral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class IniciarJuego extends AppCompatActivity {

    Button btnIniciar;
    final int pregunta = 0;
    final int turno = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_juego2);
        conectar();
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), MainActivity.class);
                I.putExtra("pregunta", 0);
                I.putExtra("turno", turno);
                I.putExtra("correcto", 0);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnIniciar = findViewById(R.id.btnIniciar);
    }
}
