package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InformacionAposrtador extends AppCompatActivity {

    TextView lvGanCategoria, lvGanCuanto;
    Spinner spPartidos;

    SpinnerAdapter adapter;
    String Usuario;
    ArchivoApuestas ArchivoApuestas;
    ArchivoMarcadores ArchivoMarcadores;
    ArrayList<Apuestas> listaApuestas;
    ArrayList<Marcadores> listaMarcadores;
    ArchivoPartidos ArchivoPartidos;
    ArrayList<Partidos> listaPartidos;
    ArrayList<String> part;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_aposrtador);
        conectar();
        Bundle recuperar = getIntent().getExtras();
        Usuario = recuperar.getString("Usuario");
        leer();
        Ganado();
        llenarPart();
    }

    //revisa si el apostador a ganado en alguna categoria
    private void Ganado() {
        int apuesta = 0;
        int cont = 0;
        int gano = 0;

        for(int j = 0; j < listaApuestas.size(); j++){

            String equ1 = listaApuestas.get(j).getEquipo1();
            String eq2 = listaApuestas.get(j).getEquipo2();
            String eqGan = listaApuestas.get(j).getEquipoGanador();
            String fechaApues = listaApuestas.get(j).getFechaPartido();

            if(listaApuestas.get(j).getApostador().equals(Usuario)){

                for (int k = 0; k < listaMarcadores.size(); k++){

                    if(equ1.equals(listaMarcadores.get(k).getEquipo1())
                            && eq2.equals(listaMarcadores.get(k).getEquipo2())
                            && eqGan.equals(listaMarcadores.get(k).getEquipoGanador())
                            && listaMarcadores.get(k).getFecha().equals(fechaApues)){
                        apuesta += Integer.parseInt(listaApuestas.get(j).getCantApuesta());
                        cont++;
                    }
                }
            }
        }

        if(cont == 3){
            gano = apuesta*25;
            lvGanCategoria.setText("\n" + "3 apuestas de partidos acertadas");
        }else if (cont == 4){
            gano = apuesta*40;
            lvGanCategoria.setText("\n" + "4 apuestas de partidos acertadas");
        }else if(cont == 5){
            gano = apuesta*100;
            lvGanCategoria.setText("\n" + "5 apuestas de partidos acertadas");
        }
        lvGanCuanto.setText("\n" + gano);
    }

    //crea la lista para llenar el Spinner y lo llena
    private void llenarPart() {
        part = new ArrayList();

        for (int i = 0; i < listaMarcadores.size(); i++) {

            String p = listaMarcadores.get(i).getEquipo1().trim() + " - " + listaMarcadores.get(i).getEquipo2() + "\n" +
                    "GANADOR: " + listaMarcadores.get(i).getEquipoGanador() + "\n" + listaMarcadores.get(i).getFecha()+ "\n" ;
            part.add(p);
        }
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,part);
        spPartidos.setAdapter(adapter);
    }

    //lee los archivos planos necesarios
    private void leer() {
        try {
            ArchivoApuestas = new ArchivoApuestas(this);
            listaApuestas = ArchivoApuestas.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ArchivoPartidos = new ArchivoPartidos(this);
            listaPartidos = ArchivoPartidos.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ArchivoMarcadores = new ArchivoMarcadores(this);
            listaMarcadores = ArchivoMarcadores.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void conectar() {
        lvGanCategoria = findViewById(R.id.tvCategoriaGanada);
        lvGanCuanto = findViewById(R.id.tvValorGanado);
        spPartidos = findViewById(R.id.spPartidos);
    }
}
