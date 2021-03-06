package com.example.alea_recursivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btnGenerar, btnIntentos, txtNumeros, btnPuntos;
    int numeros [] = new int[5];
    int sumaDigitos [] = new int[5];
    Jugador jugador = new Jugador();

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
                jugador.setIntentos(1);
                revisar555();
                sumaCifras();
                escapicua();
                mostrarPuntosIntentos();
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
            if(i == 0){
                mostrarNum = mostrarNum + numeros[i];
            }else {
                mostrarNum = mostrarNum + " - " + numeros[i];
            }
        }
        txtNumeros.setText(mostrarNum);
    }

    private void revisar555() {
        int contador = 0;
        for (int i = 0; i < 5; i++){
            if(numeros[i] == 555){
                contador++;
            }
        }
        jugador.setPuntos(contador);
    }

    private void sumaCifras() {
        int puntosSuma = 0;
        for(int i = 0; i < 5; i++){
            sumaDigitos [i] = sumaRecursiva(numeros [i]);
            if(sumaDigitos [i] > 12){
                puntosSuma += 3;
            }
        }
        jugador.setPuntos(puntosSuma);
    }

    private int sumaRecursiva(int num){
        if(num==0){
            return 0;
        } else {
            return sumaRecursiva(num/10) + num%10;
        }
    }

    private void escapicua() {
        int puntosCapicua = 0;
        for(int i = 0; i < 5; i++){
            boolean EsCapi = Capicua(numeros[i]);
            if(EsCapi){
                puntosCapicua += 5;
            }
        }
        jugador.setPuntos(puntosCapicua);

    }

    private boolean Capicua(int num){
        int reves = 0;
        int r;
        int aux = num;
        int numero = num;
        boolean esCapi;
        while (numero > 0){
            r = numero % 10;
            reves = reves * 10 + r;
            numero = numero/10;
        }
        if(reves == aux){
            esCapi = true;
        }else{
            esCapi = false;
        }
        return esCapi;
    }

    private void mostrarPuntosIntentos() {
        if(Integer.parseInt(jugador.getPuntos()) < 20) {
            btnPuntos.setText(jugador.getPuntos());
            btnIntentos.setText(jugador.getIntentos());
        }else{
            btnPuntos.setText(jugador.getPuntos());
            btnIntentos.setText(jugador.getIntentos());
            btnGenerar.setText("JUEGO TERMINADO");
            btnGenerar.setEnabled(false);
        }
    }


}
