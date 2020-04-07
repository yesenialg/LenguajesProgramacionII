package com.example.parcial_cuantosabesdefutbol;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Administrador extends AppCompatActivity {

    ArrayAdapter adapter;
    Button btnAgregar, btnInformacion;
    Spinner lvEquipo1, lvEquipo2;
    DatePicker dp;
    String fecha;

    String [] equipos = {"America", "Nacional", "Medellin", "Junior", "Cali", "Millos", "Santafe", "Tolima", "Envigado", "Cucuta"};
    String equipo1, equipo2;
    ArchivoPartidos arc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        conectar();
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,equipos);
        lvEquipo1.setAdapter(adapter);
        lvEquipo2.setAdapter(adapter);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = new GregorianCalendar();
                Date date = cal.getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String formatteDate = df.format(date);
                int dayForm = dia(formatteDate);
                int montuForm = mes(formatteDate);

                escribirFecha();
                if(lvEquipo1.getSelectedItem().toString() == lvEquipo2.getSelectedItem().toString()) {
                    Toast.makeText(getApplicationContext(), "Seleccione equipos diferentes", Toast.LENGTH_LONG).show();
                }else if(dayForm >= dp.getDayOfMonth() && montuForm > dp.getMonth() ) {
                    Toast.makeText(getApplicationContext(), "Seleccione una fecha valida", Toast.LENGTH_LONG).show();
                }else {
                        Toast.makeText(getApplicationContext(), "Los equipos: " + lvEquipo1.getSelectedItem().toString() + " - " + lvEquipo2.getSelectedItem().toString() + " Juegan el " + fecha, Toast.LENGTH_LONG).show();
                        equipo1 = lvEquipo1.getSelectedItem().toString();
                        equipo2 = lvEquipo2.getSelectedItem().toString();
                        try {
                            Cargar();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        });

        //Dirige al activity de informacionAdministrador
        btnInformacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), InformacionAdministrador.class);
                startActivity(a);
            }
        });
    }

    //Extrae el mes del String fecha
    private int mes(String formatteDate) {
        String a = formatteDate.charAt(3) + "" + formatteDate.charAt(4) + "";
        int mes = Integer.parseInt(a);
        return mes;
    }

    //Extrae el dia del String fecha
    private int dia(String formatteDate) {
        String a = formatteDate.charAt(0) + "" + formatteDate.charAt(1) + "";
        int dia = Integer.parseInt(a);
        return dia;
    }

    //Cambia los dias y meses con un solo digito, a dos "3" --> "03"
    private void escribirFecha() {
        String day, month;
        if(dp.getDayOfMonth() < 10){
            day = "0" + dp.getDayOfMonth();
        }else{
            day = dp.getDayOfMonth() + "";
        }
        if((dp.getMonth()+1) < 10){
            month = "0" + (dp.getMonth()+1);
        }else{
            month = (dp.getMonth()+1) + "";
        }
        fecha = day + "/" + month + "/" + dp.getYear();
    }

    //Manda los equipos y la fecha seleccionada a la clase ArchivoPartido para guardar en el archivo plano
    private void Cargar() throws IOException {
        arc = new ArchivoPartidos(this);
        String esc = equipo1 + "\n" + equipo2 + "\n" + fecha;
        arc.escribir(esc);
    }

    private void conectar() {
        btnAgregar = findViewById(R.id.btnAgregarPartido);
        lvEquipo1 = findViewById(R.id.lvEquipo1);
        lvEquipo2 = findViewById(R.id.lvEquipo2);
        dp = findViewById(R.id.datePicker);
        btnInformacion = findViewById(R.id.btnInformacion);
    }
}
