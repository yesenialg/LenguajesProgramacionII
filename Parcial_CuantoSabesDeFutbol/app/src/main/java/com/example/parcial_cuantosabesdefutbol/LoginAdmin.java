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
                if(tvUsuario.getText().toString().equals("") || tvContrasena.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Asegurese de llenar todos los campos", Toast.LENGTH_LONG).show();
                }else {
                    existe();
                }
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvUsuario.getText().toString().equals("") || tvContrasena.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Asegurese de llenar todos los campos", Toast.LENGTH_LONG).show();
                }else {
                    noExiste();
                }
            }
        });
    }

    //crea un administrador escribiendo en archivo plano
    private void noExiste() {
        try {
            Archivo = new ArchivoLogin(this);
            lista = Archivo.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean existe = false;
        for (int i = 0; i < lista.size(); i++){
            if(lista.get(i).getTipo().trim().equals("admin") && tvUsuario.getText().toString().equals(lista.get(i).getUsuario().trim())){
                existe = true;
                Toast.makeText(getApplicationContext(), "El usuario ya existe", Toast.LENGTH_LONG).show();
                break;
            }
        }
            if(existe == false) {
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

    //si el administrador existe, ingresa al activity administrador
    private void existe() {
        try {
            Archivo = new ArchivoLogin(this);
            lista = Archivo.leer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean existe = false;
        for (int i = 0; i < lista.size(); i++){

            if(lista.get(i).tipo.equals("admin") && tvUsuario.getText().toString().equals(lista.get(i).getUsuario().trim()) && tvContrasena.getText().toString().equals(lista.get(i).getContrasena().trim())) {
                existe = true;
                Intent a = new Intent(getApplicationContext(), Administrador.class);
                startActivity(a);
            }else if(lista.get(i).tipo.equals("admin") && tvUsuario.getText().toString().equals(lista.get(i).getUsuario().trim())){
                Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                existe = true;
            }
        }
        if(existe == false){
            Toast.makeText(getApplicationContext(), "El usuario no existe", Toast.LENGTH_LONG).show();
        }
    }

    private void conectar() {
        btnIngresar = findViewById(R.id.btnIngresar);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        tvUsuario = findViewById(R.id.tvUsuario);
        tvContrasena = findViewById(R.id.tvContrasena);
    }
}
