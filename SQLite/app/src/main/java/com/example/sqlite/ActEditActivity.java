package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActEditActivity extends AppCompatActivity {

    Button btnActualizar, btnEliminar, btnMostrar;
    EditText txtNombre, txtTelefono;
    int Id;
    String strNombre, strTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_edit);
        conectar();
        Bundle b = getIntent().getExtras();
        if(b != null){
            Id = b.getInt("Id");
            strNombre = b.getString("Nombre");
            strTelefono = b.getString("Telefono");
            txtNombre.setText(strNombre);
            txtTelefono.setText(strTelefono);
        }
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editar(Id, txtNombre.getText().toString(), txtTelefono.getText().toString());
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar(Id);
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent (getApplicationContext(), MostrarActivity.class);
                startActivity(I);
            }
        });
    }

    private void Editar(int id, String Nombre, String Telefono){
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Update Contactos set Nombre = '" + Nombre + "', Telefono = '" + Telefono + "' Where Id = " + id;
        Toast.makeText(getApplicationContext(), "Cambio realizado", Toast.LENGTH_LONG).show();
        db.execSQL(SQL);
        db.close();
    }

    private void Eliminar (int id){
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "delete from Contactos where Id = " + id;
        Toast.makeText(getApplicationContext(), "Eliminado correctamente", Toast.LENGTH_LONG).show();
        db.execSQL(SQL);
        db.close();
    }

    private void conectar() {
        btnActualizar = findViewById(R.id.btnActuali);
        btnEliminar = findViewById(R.id.btnElim);
        btnMostrar = findViewById(R.id.btnMost);
        txtNombre = findViewById(R.id.txtNom);
        txtTelefono = findViewById(R.id.txtTel);
    }
}
