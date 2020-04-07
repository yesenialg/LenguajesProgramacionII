package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button admin, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        //Dirige al activity LoginAdmin
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginAdmin.class);
                startActivity(i);
            }
        });

        //Dirige al activity LoginUsuario
        usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginUsuario.class);
                startActivity(i);
            }
        });
    }

    private void conectar() {
        admin = findViewById(R.id.btnAdmin);
        usuario = findViewById(R.id.btnUsuario);
    }
}
