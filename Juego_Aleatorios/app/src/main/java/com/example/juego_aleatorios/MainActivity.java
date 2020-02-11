package com.example.juego_aleatorios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnG1, btnG2, btnG3;
    EditText txtNum;
    TextView tvPuntos;
    int numeros [] = new int[3];
    int  inten = 0;
    int punt = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Conectar();
            btnG1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //while (Integer.parseInt(txtNum.toString()) < 100 || Integer.parseInt(txtNum.toString()) > 999){
                        //Toast.makeText(getApplicationContext(), "EL NUMERO " + txtNum.toString() + " NO ES VALIDO", Toast.LENGTH_LONG);
                        //txtNum.setHint("INGRESE UN NUMERO DE TRES CIFRAS");
                    //}
                    aleatorios();
                    mostrar();
                    //igual();
                    //diferencia();
                    //promedio();
                    mostrarPuntos();
                    Intentos();
                }
            });
            btnG2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    aleatorios();
                    mostrar();
                    //igual();
                    //diferencia();
                    //promedio();
                    mostrarPuntos();
                    Intentos();
                }
            });
        btnG3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aleatorios();
                mostrar();
                //igual();
                //diferencia();
                //promedio();
                mostrarPuntos();
                Intentos();
            }
        });
    }

    private void Conectar() {
        btnG1 = findViewById(R.id.btnGenerar1);
        btnG2 = findViewById(R.id.btnGenerar2);
        btnG3 = findViewById(R.id.btnGenerar3);
        txtNum = findViewById(R.id.txtNumero);
        tvPuntos = findViewById(R.id.tvPuntos);
    }

    private void aleatorios() {
        Random r = new Random();
        for (int i = 0; i < 3; i++){
            numeros[i] = 100 + r.nextInt(999 - 100 + 1);
        }

    }

    private void mostrar() {
        btnG1.setText(numeros[0] + "");
        btnG2.setText(numeros[1] + "");
        btnG3.setText(numeros[2] + "");
    }


    private void igual() {
        for(int i = 0; i < 3; i++){
            if(Integer.parseInt(txtNum.toString()) == numeros[i]){
                punt += 1000;
            }
        }
    }


    private void diferencia() {
        if(Integer.parseInt(txtNum.toString()) - numeros[0] < 10){
            punt += 100;
        }
        if(Integer.parseInt(txtNum.toString()) - numeros[1] < 10){
            punt += 100;
        }
        if(Integer.parseInt(txtNum.toString()) - numeros[2] < 10){
            punt += 100;
        }
    }

    private void promedio() {
        double promedio = (numeros[0] + numeros [1] + numeros [2]) / 3;
        int mayor = Integer.parseInt(txtNum.toString()) + 10;
        int menor = Integer.parseInt(txtNum.toString()) - 10;
        if(promedio > menor && promedio < mayor){
            punt += 200;
        }
    }

    private void mostrarPuntos() {
        String puntosm = punt + "";
        tvPuntos.setText(puntosm);
    }


    private void Intentos() {
        inten++;
        if(inten >= 10){
            btnG1.setText("JUEGO TERMINADO");
            btnG2.setText("JUEGO TERMINADO");
            btnG3.setText("JUEGO TERMINADO");
            btnG1.setEnabled(false);
            btnG2.setEnabled(false);
            btnG3.setEnabled(false);
        }
    }

}
