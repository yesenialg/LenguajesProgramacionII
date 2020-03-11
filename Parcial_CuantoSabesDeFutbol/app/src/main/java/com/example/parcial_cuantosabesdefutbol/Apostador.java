package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Apostador extends AppCompatActivity {

    Spinner spPartidos, spCantApuesta;
    RadioButton RbtnEquipo1, RbtnEquipo2;
    Button btnApostar, btnGanador;
    ArrayAdapter adapter, adapt;
    ArrayList<Partidos> lista;
    ArchivoPartidos Archivo;
    ArrayList<String> part;
    String [] apuesta = {"50000", "10000", "200000", "300000", "400000", "500000"};
    String ganador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apostador);
        conectar();
        leer();
        llenarPart();
        adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,part);
        spPartidos.setAdapter(adapter);
        adapt = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1,apuesta);
        spCantApuesta.setAdapter(adapt);
        btnGanador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spPartidos.setEnabled(false);
                RbtnEquipo1.setEnabled(true);
                RbtnEquipo2.setEnabled(true);
                llenarRbtn();
            }
        });
        btnApostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(RbtnEquipo1.isChecked() || RbtnEquipo2.isChecked())){
                    Toast.makeText(getApplicationContext(), "Seleccione un equipo como ganador", Toast.LENGTH_LONG).show();
                }else{
                    if(RbtnEquipo1.isChecked()){
                        ganador = RbtnEquipo1.getText().toString();
                    }else{
                        ganador = RbtnEquipo2.getText().toString();
                    }
                    spPartidos.setEnabled(true);
                    RbtnEquipo1.setEnabled(false);
                    RbtnEquipo2.setEnabled(false);
                    Toast.makeText(getApplicationContext(), "La apuesta es de: " + spCantApuesta.getSelectedItem().toString() + " con la victoria de " + ganador, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void llenarRbtn() {
        int ind = spPartidos.getSelectedItemPosition();
        RbtnEquipo1.setText(lista.get(ind).equipo1.trim());
        RbtnEquipo2.setText(lista.get(ind).equipo2.trim());
    }

    private void llenarPart() {
        part = new ArrayList();
        for (int i = 0; i < lista.size(); i++){
            String p = lista.get(i).equipo1.trim() + " - " + lista.get(i).equipo2 + lista.get(i).fechaPartido;
            part.add(p);
        }
    }

    private void leer() {
        try {
            Archivo = new ArchivoPartidos(this);
            lista = Archivo.leer();
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
    }
}
