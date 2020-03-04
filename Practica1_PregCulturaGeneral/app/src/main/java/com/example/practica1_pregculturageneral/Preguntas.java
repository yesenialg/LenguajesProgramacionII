package com.example.practica1_pregculturageneral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {

    TextView tvPregunta, tvPuntos;
    RadioButton RbtnRespuesta1, RbtnRespuesta2, RbtnRespuesta3;
    Button btnEnviar;
    ArrayList<Pregunta> lista;
    ArchivoPlano Archivo;
    int pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        Conectar();
        Bundle recup = getIntent().getExtras();
        int pregunta = recup.getInt("pregunta");
        Archivo = new ArchivoPlano(getApplicationContext());
        llenarLista();
        Cargar();
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int correcto = verificar();
                Intent I = new Intent (getApplicationContext(), MainActivity.class);
                I.putExtra("correcto", correcto);
                startActivity(I);
            }
        });
    }

    private int verificar() {
        if(RbtnRespuesta1.isChecked() && RbtnRespuesta1.toString() == lista.get(pregunta).respuestaCorrecta){
            return lista.get(pregunta).puntaje;
        }else if (RbtnRespuesta2.isChecked() && RbtnRespuesta2.toString() == lista.get(pregunta).respuestaCorrecta){
            return lista.get(pregunta).puntaje;
        }else if (RbtnRespuesta3.isChecked() && RbtnRespuesta3.toString() == lista.get(pregunta).respuestaCorrecta){
            return lista.get(pregunta).puntaje;
        }else{
            return 0;
        }
    }

    private void Cargar() {
        tvPregunta.setText(lista.get(pregunta).pregunta);
        RbtnRespuesta1.setText(lista.get(pregunta).respuesta1);
        RbtnRespuesta2.setText(lista.get(pregunta).respuesta2);
        RbtnRespuesta3.setText(lista.get(pregunta).respuesta3);
        tvPuntos.setText("El puntaje de esta pregunta es: " + lista.get(pregunta).puntaje);
    }

    private void llenarLista() {
        lista = Archivo.Leer();
    }

    private void Conectar() {
        tvPregunta = findViewById(R.id.tvPregunta);
        tvPuntos = findViewById(R.id.tvPuntos);
        RbtnRespuesta1 = findViewById(R.id.RbtnRespuesta1);
        RbtnRespuesta2 = findViewById(R.id.RbtnRespuesta2);
        RbtnRespuesta3 = findViewById(R.id.RbtnRespuesta3);
        btnEnviar = findViewById(R.id.btnEnvioRespuesta);
    }
}
