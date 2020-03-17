package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class InformacionAposrtador extends AppCompatActivity {

    ListView lvMarcadores, lvAcertadas, lvGanCategoria, lvGanCuanto, lvGanPartidos;

    String Usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_aposrtador);
        Bundle recuperar = getIntent().getExtras();
        Usuario = recuperar.getString("Usuario");
    }
}
