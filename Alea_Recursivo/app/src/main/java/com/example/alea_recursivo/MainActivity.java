package com.example.alea_recursivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btnGenerar, btnIntentos, txtNumeros, btnPuntos;
    int numeros [] = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Conectar();
        btnGenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aleatorios();
                mostrar();
            }
        });
    }

    private void Conectar() {
        btnGenerar =  findViewById(R.id.btnGenerar);
        btnIntentos = findViewById(R.id.btnIntentos);
        btnPuntos = findViewById(R.id.btnPuntos);
        txtNumeros = findViewById(R.id.txtNumeros);
    }


    private void aleatorios() {
        Random r = new Random();
        for (int i = 0; i < 5; i++){
            numeros[i] = 100 + r.nextInt(999 - 100 + 1);
        }
    }

    private void mostrar() {
        String mostrarNum = "";
        for (int i = 0; i<5; i++){
            mostrarNum = mostrarNum + " " + numeros [i];
        }
        txtNumeros.setText(mostrarNum);
    }

}
