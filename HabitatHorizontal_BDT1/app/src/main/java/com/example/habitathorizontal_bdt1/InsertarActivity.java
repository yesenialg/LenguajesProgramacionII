package com.example.habitathorizontal_bdt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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

public class InsertarActivity extends AppCompatActivity {

    Spinner spTipo, spArrendado;
    Button btnInser;
    EditText txtPrecio, txtDireccion, txtNombreProp, txtTelefonoProp;
    String FechaRecepcion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        conectar();
        String[] valores = {"NO", "SI"};
        spArrendado.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        String[] Tipos = {"Casa", "Apartamento", "Finca"};
        spTipo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Tipos));

        btnInser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fecha();
                if(txtTelefonoProp.getText().toString().equals("") || txtNombreProp.getText().toString().equals("") ||
                        txtDireccion.getText().toString().equals("") || txtPrecio.getText().toString().equals("")) {
                    mensaje();
                }else{
                    Guardar(spTipo.getSelectedItem().toString(), txtPrecio.getText().toString(), txtDireccion.getText().toString(),
                            txtNombreProp.getText().toString(), txtTelefonoProp.getText().toString(), FechaRecepcion, spArrendado.getSelectedItem().toString());
                }
            }
        });
    }

    private void mensaje() {
        Toast.makeText(this, "Llene todos los campos", Toast.LENGTH_LONG).show();
    }

    private void Guardar(String tipo, String precio, String direccion, String nombreProp, String telefonoProp, String fechaRecepcion, String arrendado) {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put("Tipo", tipo);
            cv.put("Precio", precio);
            cv.put("Direccion", direccion);
            cv.put("NombreProp", nombreProp);
            cv.put("Telefono", telefonoProp);
            cv.put("FechaRecep", fechaRecepcion);
            cv.put("Arrendada", arrendado);
            db.insert("Viviendas", null, cv);
            db.close();
            Toast.makeText(this, "Registro Insertado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
        Intent I = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(I);
    }

    private void fecha() {
        Calendar cal = new GregorianCalendar();
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        FechaRecepcion = df.format(date);
    }


    private void conectar() {
        spArrendado = findViewById(R.id.spArrendado);
        spTipo = findViewById(R.id.spTipo);
        txtDireccion = findViewById(R.id.etDireccion);
        txtNombreProp = findViewById(R.id.etPropietario);
        txtPrecio = findViewById(R.id.etPrecio);
        txtTelefonoProp = findViewById(R.id.etTelefono);
        btnInser = findViewById(R.id.btnInsert);
    }
}
