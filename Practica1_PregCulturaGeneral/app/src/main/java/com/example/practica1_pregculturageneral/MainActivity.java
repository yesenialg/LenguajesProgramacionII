
package com.example.practica1_pregculturageneral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnA1, btnA2, btnA3, btnA4, btnA5, btnB1, btnB2, btnB3, btnB4, btnB5, btnC1,
            btnC2, btnC3, btnC4, btnC5, btnD1, btnD2, btnD3, btnD4, btnD5, btnE1, btnE2,
            btnE3, btnE4, btnE5, btnIndJugador1, btnIndJugador2;
    int turno, pregunta, puntaje1, puntaje2, correcto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Conectar();
        Bundle recup = getIntent().getExtras();
        int puntaje = recup.getInt("correcto");

        if(turno % 2 != 0){
            btnIndJugador1.setBackgroundColor(Color.parseColor("#CDDC39"));
        }else{
            btnIndJugador1.setBackgroundColor(Color.parseColor("#FFCA28"));
        }

        if(turno % 2 != 0){
            puntaje1 += correcto;
            if(correcto != 0){
                //pres.setBackgroundColor(Color.parseColor("#CDDC39"));
            }
        }else{
            puntaje2 += correcto;
            if(correcto != 0){
                //pres.setBackgroundColor(Color.parseColor("#FFCA28"));
            }
        }

        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnA1;
                startActivity(I);
            }
        });

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnA2;
                startActivity(I);
            }
        });

        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnA3;
                startActivity(I);
            }
        });

        btnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnA4;
                startActivity(I);
            }
        });

        btnA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnA5;
                startActivity(I);
            }
        });

        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnB1;
                startActivity(I);
            }
        });

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnB2;
                startActivity(I);
            }
        });

        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnB3;
                startActivity(I);
            }
        });

        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnB4;
                startActivity(I);
            }
        });

        btnB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnB5;
                startActivity(I);
            }
        });

        btnC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnC1;
                startActivity(I);
            }
        });

        btnC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnC2;
                startActivity(I);
            }
        });

        btnC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnC3;
                startActivity(I);
            }
        });

        btnC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnC4;
                startActivity(I);
            }
        });

        btnC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnC5;
                startActivity(I);
            }
        });

        btnD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnD1;
                startActivity(I);
            }
        });

        btnD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnD2;
                startActivity(I);
            }
        });

        btnD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnD3;
                startActivity(I);
            }
        });

        btnD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnD4;
                startActivity(I);
            }
        });

        btnD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnD5;
                startActivity(I);
            }
        });

        btnE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnE1;
                startActivity(I);
            }
        });

        btnE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnE2;
                startActivity(I);
            }
        });

        btnE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnE3;
                startActivity(I);
            }
        });

        btnE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnE4;
                startActivity(I);
            }
        });

        btnE5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), Preguntas.class);
                I.putExtra("pregunta", pregunta);
                pres = btnE5;
                startActivity(I);
            }
        });
        turno++;
    }

    private void Conectar() {
        btnA1 = findViewById(R.id.btnA1);
        btnA2 = findViewById(R.id.btnA2);
        btnA3 = findViewById(R.id.btnA3);
        btnA4 = findViewById(R.id.btnA4);
        btnA5 = findViewById(R.id.btnA5);
        btnB1 = findViewById(R.id.btnB1);
        btnB2 = findViewById(R.id.btnB2);
        btnB3 = findViewById(R.id.btnB3);
        btnB4 = findViewById(R.id.btnB4);
        btnB5 = findViewById(R.id.btnB5);
        btnC1 = findViewById(R.id.btnC1);
        btnC2 = findViewById(R.id.btnC2);
        btnC3 = findViewById(R.id.btnC3);
        btnC4 = findViewById(R.id.btnC4);
        btnC5 = findViewById(R.id.btnC5);
        btnD1 = findViewById(R.id.btnD1);
        btnD2 = findViewById(R.id.btnD2);
        btnD3 = findViewById(R.id.btnD3);
        btnD4 = findViewById(R.id.btnD4);
        btnD5 = findViewById(R.id.btnD5);
        btnE1 = findViewById(R.id.btnE1);
        btnE2 = findViewById(R.id.btnE2);
        btnE3 = findViewById(R.id.btnE3);
        btnE4 = findViewById(R.id.btnE4);
        btnE5 = findViewById(R.id.btnE5);
        btnIndJugador1 = findViewById(R.id.btnIndJugador1);
        btnIndJugador2 = findViewById(R.id.btnIndJugador2);
    }
}
