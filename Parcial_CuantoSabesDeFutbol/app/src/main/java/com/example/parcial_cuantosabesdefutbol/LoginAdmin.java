package com.example.parcial_cuantosabesdefutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class LoginAdmin extends AppCompatActivity {

    Button btnIngresar, btnRegistrar;
    EditText tvUsuario, tvContrasena;

    ArchivoLogin Archivo;
    ArrayList<Usuarios> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        conectar();
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //existe();
                Intent a = new Intent(getApplicationContext(), Administrador.class);
                startActivity(a);
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noExiste();
            }
        });
    }

    private void noExiste() {
        try {
            Archivo = new ArchivoLogin(this);
            lista = Archivo.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).tipo == "admin" && tvUsuario.getText().toString() == lista.get(i).usuario){
                Toast.makeText(getApplicationContext(), "El usuario ya existe", Toast.LENGTH_LONG).show();
            }else{
                Archivo = new ArchivoLogin(this);
                String esc = "admin" + "\n" + tvUsuario.getText().toString() + "\n" + tvContrasena.getText().toString();
                try {
                    Archivo.escribir(esc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Usuario creado", Toast.LENGTH_LONG).show();

            }
        }
    }

    private void existe() {
        try {
            Archivo = new ArchivoLogin(this);
            lista = Archivo.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).tipo == "admin" && tvUsuario.getText().toString() == lista.get(i).usuario && tvContrasena.getText().toString() == lista.get(i).contrasena){
                Intent a = new Intent(getApplicationContext(), Administrador.class);
                startActivity(a);
            }else{
                Toast.makeText(getApplicationContext(), "usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();

            }
        }
    }

    private void conectar() {
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvUsuario = findViewById(R.id.tvUsuario);
        tvContrasena = findViewById(R.id.tvContrasena);
    }
}
