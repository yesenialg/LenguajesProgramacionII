package com.example.habitathorizontal_bdt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ElimEditActivity extends AppCompatActivity {

    Spinner spTipo, spArrendado;
    Button btnEliminar, btnActualizar;
    EditText txtPrecio, txtDireccion, txtNombreProp, txtTelefonoProp, txtTipo;
    String tipo, direccion, nombre, precio, telefono, arrendada;
    String ActPrecio, ActPropietario, ActTelefono, ActArrendada, ActFecha;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elim_edit);
        conectar();
        Bundle b = getIntent().getExtras();
        if(b != null){
            id = b.getInt("Id");
            nombre = b.getString("Nombre");
            telefono = b.getString("Telefono");
            tipo = b.getString("Tipo");
            direccion = b.getString("Direccion");
            arrendada = b.getString("Arrendada");
            precio = b.getString("Precio");
        }

        txtDireccion.setText(direccion);
        txtNombreProp.setText(nombre);
        txtPrecio.setText(precio);
        txtTelefonoProp.setText(telefono);
        txtTipo.setText(tipo);

        if(arrendada.equals("NO")) {
            String[] valores = {"NO", "SI"};
            spArrendado.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, valores));
        }else{
            String[] valores = {"SI", "NO"};
            spArrendado.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, valores));
        }

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecha();
                if(txtTelefonoProp.getText().toString().equals("") || txtNombreProp.getText().toString().equals("") ||
                        txtDireccion.getText().toString().equals("") || txtPrecio.getText().toString().equals("")) {
                    mensaje();
                }else {
                    eliminar();
                }
            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActPrecio = txtPrecio.getText().toString();
                ActPropietario = txtNombreProp.getText().toString();
                ActTelefono = txtTelefonoProp.getText().toString();
                ActArrendada = spArrendado.getSelectedItem().toString();
                fecha();
                fecha();
                if(txtTelefonoProp.getText().toString().equals("") || txtNombreProp.getText().toString().equals("") ||
                        txtDireccion.getText().toString().equals("") || txtPrecio.getText().toString().equals("")) {
                    mensaje();
                }else {
                    actualizar();
                }
            }
        });
    }

    private void mensaje() {
        Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_LONG).show();
    }

    private void fecha() {
        Calendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ActFecha = df.format(date);
    }

    private void actualizar() {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Update Viviendas set NombreProp = '" + ActPropietario + "', Telefono = '" + ActTelefono +
                "', Precio = '" + ActPrecio + "', Arrendada = '" + ActArrendada + "', " +
                "FechaRecep = '" + ActFecha + "' Where Id = " + id;
        Toast.makeText(getApplicationContext(), "Cambio realizado", Toast.LENGTH_LONG).show();
        db.execSQL(SQL);
        db.close();
        Intent I = new Intent (getApplicationContext(), MostrarEmpty.class);
        startActivity(I);
    }

    private void eliminar() {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "delete from Viviendas where Id = " + id;
        Toast.makeText(getApplicationContext(), "Eliminado correctamente", Toast.LENGTH_LONG).show();
        db.execSQL(SQL);
        db.close();
        Intent I = new Intent (getApplicationContext(), MostrarEmpty.class);
        startActivity(I);
    }

    private void conectar() {
        spArrendado = findViewById(R.id.spArrendado);
        spTipo = findViewById(R.id.spTipo);
        txtDireccion = findViewById(R.id.etDireccion);
        txtNombreProp = findViewById(R.id.etPropietario);
        txtPrecio = findViewById(R.id.etPrecio);
        txtTelefonoProp = findViewById(R.id.etTelefono);
        txtTipo = findViewById(R.id.etTipo);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnActualizar = findViewById(R.id.btnActualizar);
    }
    }
