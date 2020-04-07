package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarActivity extends AppCompatActivity {

    ListView lvContactos;
    ArrayList<String> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        lvContactos = findViewById(R.id.lvMostrar);
        Mostrar();
        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String item = lvContactos.getItemAtPosition(i).toString();
                int clave = Integer.valueOf(item.split(" ") [0]);
                String nombre = item.split(" ") [1];
                String telefono = item.split(" ") [2];
                Intent I = new Intent (getApplicationContext(), ActEditActivity.class);
                I.putExtra("Id", clave);
                I.putExtra("Nombre", nombre);
                I.putExtra("Telefono", telefono);
                startActivity(I);

            }
        });
    }

    private void Mostrar() {
        listado = ListaContactos();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listado);
        lvContactos.setAdapter(adapter);
    }

    private ArrayList<String> ListaContactos() {
        ArrayList<String> datos = new ArrayList<>();
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "select id, nombre, telefono from Contactos";
        Cursor c = db.rawQuery(SQL, null);

        if(c.moveToFirst()){
            do{
                String linea = c.getInt(0) + " " + c.getString(1) + " " + c.getString(2);
                datos.add(linea);
            }while(c.moveToNext());
        }
        db.close();
        return datos;
    }
}
