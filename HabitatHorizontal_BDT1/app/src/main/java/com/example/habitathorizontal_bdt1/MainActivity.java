package com.example.habitathorizontal_bdt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnConsulta, btnInsertar, btnEliEdi, btnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), InsertarActivity.class);
                startActivity(I);
            }
        });
        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), ConsultarActivity.class);
                startActivity(I);
            }
        });
        btnEliEdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), MostrarEmpty.class);
                startActivity(I);
            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), InfoCompletaActivity.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnConsulta = findViewById(R.id.btnConsultar);
        btnEliEdi = findViewById(R.id.btnActEl);
        btnInsertar = findViewById(R.id.btnInsertar);
        btnInfo = findViewById(R.id.btnInfoCom);
    }
}
