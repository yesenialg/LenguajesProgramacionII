package com.example.parcial_cuantosabesdefutbol;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
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
    Spinner spPartidos;
    Button btnProv;

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_administrador);
        conectar();
        leer();
        lists();
        llenar();
        acumApostado();
        ganadores();

        btnProv.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                numapostadores();
                valorApostado();
                leer();
            }
        });
    }

    //Revisa que apostadores han ganado
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void ganadores() {
        String Ganadores3 = "\n" + "LOS GANADORES DE 3 APUESTAS SON: " + "\n";
        String Ganadores4 = "\n" + "LOS GANADORES DE 4 APUESTAS SON: " + "\n";
        String Ganadores5 = "\n" + "LOS GANADORES DE 5 APUESTAS SON: " + "\n";
        int apuesta = 0;
        int egresos = 0;
        int ingresos = 0;
        int ganancia;
        for(int i = 0; i < listaLogin.size(); i++){
            int cont = 0;

            if(listaLogin.get(i).getTipo().equals("apostador")) {
                String apost = listaLogin.get(i).getUsuario();

                for(int j = 0; j < listaApuestas.size(); j++){

                    String equ1 = listaApuestas.get(j).getEquipo1();
                    String eq2 = listaApuestas.get(j).getEquipo2();
                    String eqGan = listaApuestas.get(j).getEquipoGanador();
                    String fechaApues = listaApuestas.get(j).getFechaPartido();


                    if(listaApuestas.get(j).getApostador().equals(apost)){

                        for (int k = 0; k < listaMarcadores.size(); k++){

                            if(equ1.equals(listaMarcadores.get(k).getEquipo1()) && eq2.equals(listaMarcadores.get(k).getEquipo2())
                            && eqGan.equals(listaMarcadores.get(k).getEquipoGanador()) && listaMarcadores.get(k).getFecha().equals(fechaApues)){
                                apuesta += Integer.parseInt(listaApuestas.get(j).getCantApuesta());
                                cont++;
                            }
                        }
                    }
                }
            }
            if(cont > -1 && cont < 3){
                ingresos += apuesta;
            }else if(cont == 3){
                Ganadores3 += listaLogin.get(i).getUsuario() + " Gana " + (apuesta*25) + "\n";
                egresos += apuesta*25;
            }else if (cont == 4){
                Ganadores4 += listaLogin.get(i).getUsuario() + " Gana " + (apuesta*40) + "\n";
                egresos += apuesta*40;
            }else if(cont == 5){
                Ganadores5 += listaLogin.get(i).getUsuario() + " Gana " + (apuesta*100) + "\n";
                egresos += apuesta*100;
            }
        }

        ganancia = ingresos - egresos;

        if(ganancia > 0){
            tvGanancias.setText("\n" + "La ganancia es de " + ganancia);
        }else{
            tvGanancias.setText("\n" + "La perdida es de " + (ganancia*(-1)));
        }

        tvGanadoresSemana.setText(Ganadores3 + Ganadores4 + Ganadores5);
    }

    //calcula el valor apostado en todos los partidos
    private void acumApostado() {
        int cant = 0;
        for(int i = 0; i < listaApuestas.size(); i++){
                cant += Integer.parseInt(listaApuestas.get(i).getCantApuesta());
        }
        tvValorAcumulado.setText("\n" + cant + "");
    }

    //calcula el valor apostado por partido
    private void valorApostado() {
        int cant = 0;
        for(int i = 0; i < listaApuestas.size(); i++){
            if(listaApuestas.get(i).getFechaPartido().equals(spPartidos.getSelectedItem().toString())){
                cant += Integer.parseInt(listaApuestas.get(i).getCantApuesta());
            }
        }
        tvValorPartido.setText("\n" + cant + "");
    }

    //crea la lista con la que se llena el Spinner
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

    //revisa cuantos apostadores hay
    private void numapostadores() {
        int cant = 0;
        for(int i = 0; i < listaApuestas.size(); i++){
            if(listaApuestas.get(i).getFechaPartido().equals(spPartidos.getSelectedItem().toString())){
                cant++;
            }
        }
        tvApostadoresPartido.setText("\n" + cant + "");
    }

    //llena el Spinner
    private void llenar() {
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,part);
        spPartidos.setAdapter(adapter);

    }

    //lee informacion de archivos planos
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
    }
}
