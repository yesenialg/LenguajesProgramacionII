package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarActivity extends AppCompatActivity {

    EditText txtNombre, txtTelefono;
    Button btnInsertar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        conectar();
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Guardar(txtNombre.getText().toString(), txtTelefono.getText().toString());
            }
        });
    }

    private void Guardar(String Nombre, String Telefono) {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();

        try {
            ContentValues cv = new ContentValues();
            cv.put("Nombre", Nombre);
            cv.put("Telefono", Telefono);
            db.insert("Contactos", null, cv);
            db.close();
            Toast.makeText(this, "Registro Insertado", Toast.LENGTH_LONG).show();
        }
        catch (Exception ex){
            Toast.makeText(this, "Error" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void conectar() {
        txtNombre = findViewById(R.id.etNombre);
        txtTelefono = findViewById(R.id.etTelefono);
        btnInsertar = findViewById(R.id.btnInsertar);
    }
}
