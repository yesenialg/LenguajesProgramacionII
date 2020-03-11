package com.example.juegopreg_practicai;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout linearButtons;
    Button btnA1, btnA2, btnA3, btnA4, btnA5, btnB1, btnB2, btnB3, btnB4, btnB5, btnC1,
            btnC2, btnC3, btnC4, btnC5, btnD1, btnD2, btnD3, btnD4, btnD5, btnE1, btnE2,
            btnE3, btnE4, btnE5, btnIndJugador1, btnIndJugador2, pres;
    int turno = 1,puntaje1, puntaje2, preg = 34;
    TextView tvPregunta, tvPuntos;
    RadioButton RbtnRespuesta1, RbtnRespuesta2, RbtnRespuesta3;
    Button btnEnviar;
    ArrayList<Pregunta> lista;
    ArchivoPlano Archivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        limpiarCampos();
        Conectar();
        Archivo = new ArchivoPlano(getApplicationContext());
        llenarLista();
        btnIndJugador2.setEnabled(false);

        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnA1;
            }
        });

        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnA2;
            }
        });

        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnA3;
            }
        });

        btnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnA4;
            }
        });

        btnA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnA5;
            }
        });

        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnB1;
            }
        });

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnB2;
            }
        });

        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnB3;
            }
        });

        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnB4;
            }
        });

        btnB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnB5;
            }
        });

        btnC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnC1;
            }
        });

        btnC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnC2;
            }
        });

        btnC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnC3;
            }
        });

        btnC4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnC4;
            }
        });

        btnC5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnC5;
            }
        });

        btnD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnD1;
            }
        });

        btnD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnD2;
            }
        });

        btnD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnD3;
            }
        });

        btnD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnD4;
            }
        });

        btnD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnD5;
            }
        });

        btnE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnE1;
            }
        });

        btnE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnE2;
            }
        });

        btnE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnE3;
            }
        });

        btnE4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnE4;
            }
        });

        btnE5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cargar();
                deshabilitar();
                pres = btnE5;
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                int puntos = verificar();
                if(turno % 2 == 0){
                    puntaje1 += puntos;
                    if(puntos != 0){
                        pres.setBackground(getDrawable(R.drawable.verde));

                    }
                }else if(turno % 2 != 0){
                    puntaje2 += puntos;
                    if(puntos != 0){
                        pres.setBackground(getDrawable(R.drawable.yellow));

                    }
                }
                turnColor();
                limpiarCampos();
                habilitar();
                revGanar();
                turno++;
                preg--;
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void turnColor() {
        if(turno % 2 == 0){
            btnIndJugador1.setEnabled(true);
            btnIndJugador2.setEnabled(false);
        }else{
            btnIndJugador2.setEnabled(true);
            btnIndJugador1.setEnabled(false);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void revGanar() {
        if(btnA1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnA2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnA3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnA4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnA5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnA2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnA3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnA4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnA5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnB1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnB1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnC1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnC1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnD1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnD1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnE1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnE1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();


        }else if(btnA1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }

        else if(btnA1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnB2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnC3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnD4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())
                && btnE5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) {
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 2");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }else if(btnA1.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnB2.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnC3.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnD4.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())
                && btnE5.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState())){
            deshabilitar();
            tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO", Toast.LENGTH_LONG).show();
        }
    }

    private void limpiarCampos() {
        tvPregunta.setText("");
        RbtnRespuesta1.setText("");
        RbtnRespuesta2.setText("");
        RbtnRespuesta3.setText("");
        tvPuntos.setText("");
        btnEnviar.setEnabled(false);
    }

    private ArrayList<Button> llenar(){
        ArrayList<Button> butt = new ArrayList<>();

        butt.add(btnA1);
        butt.add(btnA2);
        butt.add(btnA3);
        butt.add(btnA4);
        butt.add(btnA5);
        butt.add(btnB1);
        butt.add(btnB2);
        butt.add(btnB3);
        butt.add(btnB4);
        butt.add(btnB5);
        butt.add(btnC1);
        butt.add(btnC2);
        butt.add(btnC3);
        butt.add(btnC4);
        butt.add(btnC5);
        butt.add(btnD1);
        butt.add(btnD2);
        butt.add(btnD3);
        butt.add(btnD4);
        butt.add(btnD5);
        butt.add(btnE1);
        butt.add(btnE2);
        butt.add(btnE3);
        butt.add(btnE4);
        butt.add(btnE5);
        return butt;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void habilitar() {
        ArrayList<Button> butt = llenar();
        int cantidad = 0;

        for (int i = 0; i<25; i++){

            if((butt.get(i).getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.verde).getConstantState())) ||
                    (butt.get(i).getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.yellow).getConstantState()))){
                butt.get(i).setEnabled(false);

            }else{
                butt.get(i).setEnabled(true);
                cantidad++;
            }
        }

        if(preg == 0 || cantidad == 0){
            deshabilitar();
            limpiarCampos();
            btnIndJugador1.setEnabled(true);
            btnIndJugador2.setEnabled(true);
            btnIndJugador1.setText("Jugador 1: " + puntaje1);
            btnIndJugador2.setText("Jugador 2: " + puntaje2);
            Toast.makeText(getApplicationContext(), "JUEGO TERMINADO: NO HAY MAS CASILLAS Y/O PREGUNTAS", Toast.LENGTH_LONG).show();

            if(puntaje1 > puntaje2){
                tvPregunta.setText("EL GANADOR ES EL JUGADOR 1");
            }else if(puntaje1 < puntaje2){
                tvPregunta.setText("EL GANADOR ES EL JUGADR 2");
            }else{
                tvPregunta.setText("EMPATE");
            }

        }
    }

    private void deshabilitar() {

        btnA1.setEnabled(false);
        btnA2.setEnabled(false);
        btnA3.setEnabled(false);
        btnA4.setEnabled(false);
        btnA5.setEnabled(false);
        btnB1.setEnabled(false);
        btnB2.setEnabled(false);
        btnB3.setEnabled(false);
        btnB4.setEnabled(false);
        btnB5.setEnabled(false);
        btnC1.setEnabled(false);
        btnC2.setEnabled(false);
        btnC3.setEnabled(false);
        btnC4.setEnabled(false);
        btnC5.setEnabled(false);
        btnD1.setEnabled(false);
        btnD2.setEnabled(false);
        btnD3.setEnabled(false);
        btnD4.setEnabled(false);
        btnD5.setEnabled(false);
        btnE1.setEnabled(false);
        btnE2.setEnabled(false);
        btnE3.setEnabled(false);
        btnE4.setEnabled(false);
        btnE5.setEnabled(false);
    }

    private int verificar() {
        if(RbtnRespuesta1.isChecked() && RbtnRespuesta1.getText().toString().equals(lista.get(preg).respuestaCorrecta)){
            return lista.get(preg).puntaje;
        }else if (RbtnRespuesta2.isChecked() && RbtnRespuesta2.getText().toString().equals(lista.get(preg).respuestaCorrecta)){
            return lista.get(preg).puntaje;
        }else if (RbtnRespuesta3.isChecked() && RbtnRespuesta3.getText().toString().equals(lista.get(preg).respuestaCorrecta)){
            return lista.get(preg).puntaje;
        }else{
            return 0;
        }

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
        tvPregunta = findViewById(R.id.tvPregunta);
        tvPuntos = findViewById(R.id.tvPuntos);
        RbtnRespuesta1 = findViewById(R.id.RbtnRespuesta1);
        RbtnRespuesta2 = findViewById(R.id.RbtnRespuesta2);
        RbtnRespuesta3 = findViewById(R.id.RbtnRespuesta3);
        btnEnviar = findViewById(R.id.btnEnvioRespuesta);
        linearButtons = findViewById(R.id.LinearButtons);
    }

    private void Cargar() {
        tvPregunta.setText(lista.get(preg).pregunta);
        RbtnRespuesta1.setText(lista.get(preg).respuesta1);
        RbtnRespuesta2.setText(lista.get(preg).respuesta2);
        RbtnRespuesta3.setText(lista.get(preg).respuesta3);
        tvPuntos.setText("El puntaje de esta pregunta es: " + lista.get(preg).puntaje);
        btnEnviar.setEnabled(true);
    }

    private void llenarLista() {
        lista = Archivo.Leer();
    }
}
