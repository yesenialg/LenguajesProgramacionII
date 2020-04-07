package com.example.habitathorizontal_bdt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MostrarEmpty extends AppCompatActivity {

    ListView lvMostrar;
    ArrayList<String> listado;
    String id, tipo, direccion, nombre, precio, telefono, arrendada;
    Button btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_empty);
        lvMostrar = findViewById(R.id.lvMostrar);
        btnMenu = findViewById(R.id.btnMenu);
        Mostrar();
        lvMostrar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String item = lvMostrar.getItemAtPosition(i).toString();
                int clave = Integer.valueOf(item.split(" ") [0]);
                info(clave);
                Intent I = new Intent (getApplicationContext(), ElimEditActivity.class);
                I.putExtra("Id", clave);
                I.putExtra("Tipo", tipo);
                I.putExtra("Direccion", direccion);
                I.putExtra("Nombre", nombre);
                I.putExtra("Telefono", telefono);
                I.putExtra("Precio", precio);
                I.putExtra("Arrendada", arrendada);
                startActivity(I);

            }
        });
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(I);
            }
        });
    }

    private void info(int clave) {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "select id, tipo, precio, direccion, nombreProp, telefono, arrendada from Viviendas where id = '" + clave + "'";
        Cursor c = db.rawQuery(SQL, null);

        if(c.moveToFirst()){
            do{
                id = c.getString(0);
                tipo = c.getString(1);
                precio = c.getString(2);
                direccion = c.getString(3);
                nombre = c.getString(4);
                telefono = c.getString(5);
                arrendada = c.getString(6);
            }while(c.moveToNext());
        }
        db.close();
    }

    private void Mostrar() {
        listado = ListaViviendas();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listado);
        lvMostrar.setAdapter(adapter);
    }

    private ArrayList<String> ListaViviendas() {
        ArrayList<String> datos = new ArrayList<>();
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "select id, tipo, direccion, nombreProp from Viviendas";
        Cursor c = db.rawQuery(SQL, null);

        if(c.moveToFirst()){
            do{
                String linea = c.getInt(0) + " - " + c.getString(1) + " - " + c.getString(2) + " - " + c.getString(3);
                datos.add(linea);
            }while(c.moveToNext());
        }
        db.close();
        return datos;
    }
}
