package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class InformacionAdministrador extends AppCompatActivity {

    TextView tvNumeroApostadores, tvNumeroGanadores, tvGanancia, tvApostadoFecha;

    ArchivoApuestas ArchivoApuestas;
    ArrayList<Apuestas> listaApuestas;
    ArchivoLogin ArchivoLogin;
    ArrayList<Usuarios> listaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_administrador);
        conectar();
        llenar();
        numapostadores();
        apostadoPorFecha();
    }

    private void apostadoPorFecha() {
        String apuestas = "";
        while (listaApuestas.size() > 0){
            String fecha = listaApuestas.get(0).getFechaPartido();
            int ApuestaFecha = 0;
            for (int i = 0; i < listaApuestas.size(); i++){
                int apuesta = 0;
                if(listaApuestas.get(i).getFechaPartido().equals(fecha)){
                    apuesta += Integer.parseInt(listaApuestas.get(i).getCantApuesta());
                    listaApuestas.remove(i);
                }
                ApuestaFecha = apuesta;
            }
            apuestas += fecha + " = " + ApuestaFecha + "\n" ;
        }
        tvApostadoFecha.setText(apuestas);
    }

    private void numapostadores() {
        int cant = 0;
        for(int i = 0; i < listaLogin.size(); i++){
            if(listaLogin.get(i).getTipo().equals("apostador")){
                cant++;
            }
        }
        tvNumeroApostadores.setText("\n" + cant + "");
    }

    private void llenar() {
        leer();
    }

    private void leer() {
        try {
            ArchivoApuestas = new ArchivoApuestas(this);
            listaApuestas = ArchivoApuestas.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ArchivoLogin = new ArchivoLogin(this);
            listaLogin = ArchivoLogin.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void conectar() {
        tvNumeroApostadores = findViewById(R.id.ApostRegistrados);
        tvNumeroGanadores = findViewById(R.id.Ganadores);
        tvGanancia = findViewById(R.id.Ganancia);
        tvApostadoFecha = findViewById(R.id.ApostadosFecha);
    }
}
