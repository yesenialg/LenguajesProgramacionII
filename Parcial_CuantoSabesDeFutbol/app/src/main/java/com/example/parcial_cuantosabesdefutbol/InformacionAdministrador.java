package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class InformacionAdministrador extends AppCompatActivity {

    TextView tvValorAcumulado, tvGanancias, tvApostadoresPartido, tvValorPartido, tvGanadoresSemana;
    Spinner spPartidos, spSemanas;
    Button btnProv;
    DatePicker dpCalendario;

    SpinnerAdapter adapter;
    ArchivoApuestas ArchivoApuestas;
    ArchivoMarcadores ArchivoMarcadores;
    ArrayList<Apuestas> listaApuestas;
    ArrayList<Marcadores> listaMarcadores;
    ArchivoLogin ArchivoLogin;
    ArrayList<Usuarios> listaLogin;
    ArchivoPartidos ArchivoPartidos;
    ArrayList<Partidos> listaPartidos;
    ArrayList<String> part;
    ArrayList<String> semana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_administrador);
        conectar();
        leer();
        lists();
        llenar();
        acumApostado();
        calcularGanancias();

        btnProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numapostadores();
                valorApostado();
                ganadoresSemana();
            }
        });
    }

    private void ganadoresSemana() {

    }

    private void calcularGanancias() {
        Calendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formatteDate = df.format(date);
        int diaFor = dia(formatteDate);
        int mesFor = mes(formatteDate);

        int ingresos = 0, egresos = 0, ganancia;
        for (int i = 0; i < listaApuestas.size(); i++){
            String apuestaEq1 = listaApuestas.get(i).getEquipo1();
            String apuestaEq2 = listaApuestas.get(i).getEquipo2();
            String apuestaEqGan = listaApuestas.get(i).getEquipoGanador();
            String apuestaFecha = listaApuestas.get(i).getFechaPartido();

            for (int j = 0; j < listaMarcadores.size(); j++){
                String marcadorEq1 = listaMarcadores.get(j).getEquipo1();
                String marcadorEq2 = listaMarcadores.get(j).getEquipo2();
                String marcadorEqGan = listaMarcadores.get(j).getEquipoGanador();
                String marcadorFecha = listaMarcadores.get(j).getFecha();

                int diaPart = dia(marcadorFecha);
                int mesPart = mes(marcadorFecha);

                if(apuestaEq1.equals(marcadorEq1) && apuestaEq2.equals(marcadorEq2)
                        && apuestaFecha.equals(marcadorFecha)
                        && diaPart < diaFor && mesPart <= mesFor){

                    if(apuestaEqGan.equals(marcadorEqGan)){
                        egresos += Integer.parseInt(listaApuestas.get(i).getCantApuesta());
                    }else{
                        ingresos += Integer.parseInt(listaApuestas.get(i).getCantApuesta());
                    }
                }
            }
        }
        ganancia = ingresos - egresos;

        if(ganancia > 0){
            tvGanancias.setText("\n" + "La ganancia es de " + ganancia);
        }else{
            tvGanancias.setText("\n" + "La perdida es de " + (ganancia*(-1)));
        }

    }

    private int mes(String formatteDate) {
        String a = formatteDate.charAt(3) + formatteDate.charAt(4) + "";
        int mes = Integer.parseInt(a);
        return mes;
    }

    private int dia(String formatteDate) {
        String a = formatteDate.charAt(0) + formatteDate.charAt(1) + "";
        int dia = Integer.parseInt(a);
        return dia;
    }

    private void acumApostado() {
        int cant = 0;
        for(int i = 0; i < listaApuestas.size(); i++){
                cant += Integer.parseInt(listaApuestas.get(i).getCantApuesta());
        }
        tvValorAcumulado.setText("\n" + cant + "");
    }

    private void valorApostado() {
        int cant = 0;
        for(int i = 0; i < listaApuestas.size(); i++){
            if(listaApuestas.get(i).getFechaPartido().equals(spPartidos.getSelectedItem().toString())){
                cant += Integer.parseInt(listaApuestas.get(i).getCantApuesta());
            }
        }
        tvValorPartido.setText("\n" + cant + "");
    }

    private void lists() {
        part = new ArrayList();
        for (int i = 0; i < listaPartidos.size(); i++) {
            String p = listaPartidos.get(i).getFechaPartido().trim();
            part.add(p);
        }
        for (int i = 0; i < part.size(); i++){
            String current = part.get(i);
            int cont = 0;
            for(int j = 0; j < part.size(); j++){
                if(current.compareTo(part.get(j)) == 0){
                    cont++;
                    if(cont > 1){
                        part.remove(j);
                    }
                }
            }
        }
    }

    private void numapostadores() {
        int cant = 0;
        for(int i = 0; i < listaApuestas.size(); i++){
            if(listaApuestas.get(i).getFechaPartido().equals(spPartidos.getSelectedItem().toString())){
                cant++;
            }
        }
        tvApostadoresPartido.setText("\n" + cant + "");
    }

    private void llenar() {
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,part);
        spPartidos.setAdapter(adapter);

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
        tvValorAcumulado = findViewById(R.id.tvValorAcumulado);
        tvGanancias = findViewById(R.id.tvGanancias);
        tvApostadoresPartido = findViewById(R.id.tvApostadoresPartido);
        tvValorPartido = findViewById(R.id.tvValorApostadoPartido);
        tvGanadoresSemana = findViewById(R.id.tvGanadoresSemana);
        spPartidos = findViewById(R.id.spPartidos);
        btnProv = findViewById(R.id.btnProv);
        dpCalendario = findViewById(R.id.dpCalendario);
    }
}
