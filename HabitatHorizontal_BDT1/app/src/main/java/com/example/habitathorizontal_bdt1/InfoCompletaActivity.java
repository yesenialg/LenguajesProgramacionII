package com.example.habitathorizontal_bdt1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoCompletaActivity extends AppCompatActivity {

    ListView lvMostrar;
    ArrayList<String> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_completa);
        lvMostrar = findViewById(R.id.lvInfo);
        Mostrar();
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
        String SQL = "select id, tipo, direccion, nombreProp, telefono, precio, arrendada from Viviendas";
        Cursor c = db.rawQuery(SQL, null);

        if(c.moveToFirst()){
            do{
                String linea = "\n ID: " + c.getInt(0) + "\n TIPO: " + c.getString(1) + "\n DIRECCION: " + c.getString(2) + "\n PROPIETARIO: " + c.getString(3)+ "\n TELEFONO PROPIETARIO: " + c.getString(4)+ "\n PRECIO: " + c.getString(5)+ "\n ARRENDADA: " + c.getString(6) + "\n";
                datos.add(linea);
            }while(c.moveToNext());
        }
        db.close();
        return datos;
    }
}
