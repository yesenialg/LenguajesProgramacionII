package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginAdmin extends AppCompatActivity {

    Button btnIngresar, btnRegistrar;
    EditText tvUsuario, tvContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        conectar();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Administrador.class);
                startActivity(i);
            }
        });
    }

    private void conectar() {
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvUsuario = findViewById(R.id.tvUsuario);
        tvContrasena = findViewById(R.id.tvContrasena);
    }
}
