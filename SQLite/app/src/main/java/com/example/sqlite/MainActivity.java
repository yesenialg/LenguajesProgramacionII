package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnInsertar, btnConsultar;

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

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), MostrarActivity.class);
                startActivity(I);
            }
        });
    }

    private void conectar() {
        btnInsertar = findViewById(R.id.btnAgregar);
        btnConsultar = findViewById(R.id.btnConsultar);
    }
}
