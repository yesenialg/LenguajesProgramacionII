package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Apostador extends AppCompatActivity {

    Spinner spPartidos, spCantApuesta;
    RadioButton RbtnEquipo1, RbtnEquipo2;
    Button btnApostar, btnGanador, btnGanancias;
    ArrayAdapter adapter, adapt;
    ArrayList<Partidos> lista;
    ArchivoPartidos Archivo;
    ArrayList<Apuestas> listaApuesta;
    ArchivoApuestas ArchivoApuesta;
    ArrayList<Partidos> part;
    String [] apuesta = {"50000", "100000", "200000", "300000", "400000", "500000"};
    String ganador, Usuario, fechaPartido;
    ArrayList<String> listAdapter;
    ArchivoApuestas arc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apostador);
        Bundle recuperar = getIntent().getExtras();
        Usuario = recuperar.getString("Usuario");
        conectar();
        leer();
        llenarPart();
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,listAdapter);
        spPartidos.setAdapter(adapter);
        adapt = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,apuesta);
        spCantApuesta.setAdapter(adapt);

        //habilita y deshabilita
        btnGanador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spPartidos.setEnabled(false);
                RbtnEquipo1.setEnabled(true);
                RbtnEquipo2.setEnabled(true);
                btnApostar.setEnabled(true);

                llenarRbtn();
            }
        });

        //lleva al activity de informacionApostador
        btnGanancias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), InformacionAposrtador.class);
                a.putExtra("Usuario", Usuario);
                startActivity(a);
            }
        });

        btnApostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean apuesta = apuestaExistente();
                if(!(RbtnEquipo1.isChecked() || RbtnEquipo2.isChecked())){
                    Toast.makeText(getApplicationContext(), "Seleccione un equipo como ganador", Toast.LENGTH_LONG).show();
                }else if(apuesta == true) {
                    Toast.makeText(getApplicationContext(), "No puedes apostar dos veces en un partido", Toast.LENGTH_LONG).show();
                    spPartidos.setEnabled(true);
                    RbtnEquipo1.setEnabled(false);
                    RbtnEquipo2.setEnabled(false);
                    btnApostar.setEnabled(false);
                }else{
                        if(RbtnEquipo1.isChecked()){
                            ganador = RbtnEquipo1.getText().toString();
                        }else{
                            ganador = RbtnEquipo2.getText().toString();
                        }
                        spPartidos.setEnabled(true);
                        RbtnEquipo1.setEnabled(false);
                        RbtnEquipo2.setEnabled(false);
                        btnApostar.setEnabled(false);
                    escribir();
                        Toast.makeText(getApplicationContext(), "La apuesta es de: " +
                                spCantApuesta.getSelectedItem().toString() + " con la victoria de " +
                                ganador, Toast.LENGTH_LONG).show();
                    }
                leer();
                }
        });


    }

    //revisa si ya hay una apuesta por este partido del mismo apostador
    private boolean apuestaExistente() {
        boolean existe = false;
        for (int i = 0; i < listaApuesta.size(); i++){
            if(listaApuesta.get(i).getEquipo1().equals(RbtnEquipo1.getText().toString()) &&
            listaApuesta.get(i).getEquipo2().equals(RbtnEquipo2.getText().toString()) &&
            listaApuesta.get(i).getApostador().equals(Usuario)){
                existe = true;
            }
        }
        return existe;
    }

    //manda a la clase ArchivoApuestas la informacion para guardar en el archivo plano
    private void escribir() {
        Calendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formatteDate = df.format(date);

        arc = new ArchivoApuestas(this);
        String esc = Usuario + "\n" + RbtnEquipo1.getText().toString() + "\n" + RbtnEquipo2.getText().toString()
                + "\n" + ganador + "\n" + fechaPartido + "\n" + formatteDate + "\n" + spCantApuesta.getSelectedItem().toString();
        try {
            arc.escribir(esc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //llena los RadioButtons
    private void llenarRbtn() {
        int ind = spPartidos.getSelectedItemPosition();
        RbtnEquipo1.setText(part.get(ind).equipo1.trim());
        RbtnEquipo2.setText(part.get(ind).equipo2.trim());
        fechaPartido = part.get(ind).fechaPartido.trim();
    }

    //lleva la lista que se utiliza para llenar el Spinner
    private void llenarPart() {
        Calendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formatteDate = df.format(date);


        part = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            int daypart = dia(lista.get(i).getFechaPartido());
            int monthpart = mes(lista.get(i).getFechaPartido());
            int dayForm = dia(formatteDate);
            int montuForm = mes(formatteDate);
            if(daypart > dayForm && monthpart >= montuForm) {
                String eq1 = lista.get(i).getEquipo1().trim();
                String eq2 = lista.get(i).getEquipo2().trim();
                String fecha = lista.get(i).getFechaPartido().trim();
                Partidos p = new Partidos(eq1, eq2, fecha);
                part.add(p);
            }
        }

        listAdapter = new ArrayList<>();
        for (int i = 0; i < part.size(); i++) {
            String p = part.get(i).getEquipo1() + " - " + part.get(i).getEquipo2() + "\n" + part.get(i).getFechaPartido();
            listAdapter.add(p);
        }
    }

    //extrae el mes del String fecha
    private int mes(String formatteDate) {
        String a = formatteDate.charAt(3) + "" + formatteDate.charAt(4) + "";
        int mes = Integer.parseInt(a);
        return mes;
    }

    //extrae el dia del String fecha
    private int dia(String formatteDate) {
        String a = formatteDate.charAt(0) + "" + formatteDate.charAt(1) + "";
        int dia = Integer.parseInt(a);
        return dia;
    }

    //lee los archivos planos necesarios
    private void leer() {
        try {
            Archivo = new ArchivoPartidos(this);
            lista = Archivo.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ArchivoApuesta = new ArchivoApuestas(this);
            listaApuesta = ArchivoApuesta.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void conectar() {
        spPartidos = findViewById(R.id.spPartidos);
        spCantApuesta = findViewById(R.id.spCantidadApuesta);
        RbtnEquipo1 = findViewById(R.id.RbtnEquipo1);
        RbtnEquipo2 = findViewById(R.id.RbtnEquipo2);
        btnApostar = findViewById(R.id.btnApostar);
        btnGanador = findViewById(R.id.btnGanador);
        btnGanancias = findViewById(R.id.btnGanancias);
    }
}
