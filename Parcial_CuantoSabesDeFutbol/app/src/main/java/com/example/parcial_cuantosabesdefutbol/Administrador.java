package com.example.parcial_cuantosabesdefutbol;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import java.util.Calendar;

public class Administrador extends AppCompatActivity {

    ArrayAdapter adapter;
    Button btnAgregar;
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
                fecha = dp.getDayOfMonth() + " / " + (dp.getMonth()+1) + " / " + dp.getYear();
                if(lvEquipo1.getSelectedItem().toString() == lvEquipo2.getSelectedItem().toString()) {
                    Toast.makeText(getApplicationContext(), "Elija equipos diferentes", Toast.LENGTH_LONG).show();
                }else{
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
    }

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
    }
}
