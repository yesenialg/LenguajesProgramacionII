package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Telephony;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class InformacionAdministrador extends AppCompatActivity {

    TextView tvNumeroApostadores, tvNumeroGanadores, tvGanancia, tvApostadoFecha;
    Spinner fechas;
    Button btnRevisarFecha;

    SpinnerAdapter adapter;
    ArchivoApuestas ArchivoApuestas;
    ArrayList<Apuestas> listaApuestas;
    ArchivoLogin ArchivoLogin;
    ArrayList<Usuarios> listaLogin;
    ArchivoPartidos ArchivoPartidos;
    ArrayList<Partidos> listaPartidos;
    ArrayList<String> part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_administrador);
        //listPart();
        conectar();
        llenar();
    }

    private void listPart() {
         part = new ArrayList();
        for (int i = 0; i < listaPartidos.size(); i++) {
            String p = listaPartidos.get(i).fechaPartido;
            part.add(p);
        }
    }

    private void apostadoPorFecha(){

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
        //adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,part);
        //fechas.setAdapter(adapter);
        numapostadores();
        //apostadoPorFecha();
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
        /*try {
            ArchivoPartidos = new ArchivoPartidos(this);
            listaPartidos = ArchivoPartidos.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    private void conectar() {
        tvNumeroApostadores = findViewById(R.id.ApostRegistrados);
        tvNumeroGanadores = findViewById(R.id.Ganadores);
        tvGanancia = findViewById(R.id.Ganancia);
        tvApostadoFecha = findViewById(R.id.ApostadosFecha);
        fechas = findViewById(R.id.spFechas);
    }
}
