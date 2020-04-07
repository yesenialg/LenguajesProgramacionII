package com.example.habitathorizontal_bdt1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ConsultarActivity extends AppCompatActivity {

    TextView tvNumRecibidas, tvNumDisponibles, tvNumArrendadas, tvMejorCliente, tvValorProm, tvTipoComun;
    DatePicker dp;
    Button btnBuscar;
    ListView lvMostrar;

    ArrayList<String> listado;
    String Fechadp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        conectar();
        mejorCliente();
        arrendadas();
        disponibles();
        recibidas();
        comun();
        valorPromedio();
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnUnDia();
            }
        });
    }

    private void EnUnDia() {
        escribirFecha();
        listado = ListaViviendas();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, listado);
        lvMostrar.setAdapter(adapter);
    }

    private void escribirFecha() {
        String day, month;
        if(dp.getDayOfMonth() < 10){
            day = "0" + dp.getDayOfMonth();
        }else{
            day = dp.getDayOfMonth() + "";
        }
        if((dp.getMonth()+1) < 10){
            month = "0" + (dp.getMonth()+1);
        }else{
            month = (dp.getMonth()+1) + "";
        }
        Fechadp = day + "/" + month + "/" + dp.getYear();
    }

    private ArrayList<String> ListaViviendas() {
        ArrayList<String> datos = new ArrayList<>();
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "select id, tipo, direccion, nombreProp from Viviendas where fechaRecep = '" + Fechadp + "' and arrendada = '" + "SI" + "'";
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

    private void mejorCliente() {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "SELECT NombreProp, COUNT( NombreProp) maximo FROM Viviendas GROUP BY NombreProp ORDER BY maximo DESC LIMIT 1";
        Cursor c = db.rawQuery(SQL, null);
        String disp = "";

        if(c.moveToFirst()){
            do{
                disp = c.getString(0);
            }while(c.moveToNext());
        }
        db.close();
        tvMejorCliente.setText(disp);
    }

    private void arrendadas() {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "select count(*) from Viviendas where arrendada  = '" + "SI" + "'";
        Cursor c = db.rawQuery(SQL, null);
        String arrend = "";

        if(c.moveToFirst()){
            do{
                arrend = c.getString(0);
            }while(c.moveToNext());
        }
        db.close();
        tvNumArrendadas.setText(arrend);
    }

    private void disponibles() {

        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "select count(*) from Viviendas where arrendada  = '" + "NO" + "'";
        Cursor c = db.rawQuery(SQL, null);
        String disp = "";

        if(c.moveToFirst()){
            do{
                disp = c.getString(0);
            }while(c.moveToNext());
        }
        db.close();
        tvNumDisponibles.setText(disp);
    }

    private void recibidas() {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "select count(*) from Viviendas";
        Cursor c = db.rawQuery(SQL, null);
        String disp = "";

        if(c.moveToFirst()){
            do{
                disp = c.getString(0);
            }while(c.moveToNext());
        }
        db.close();
        tvNumRecibidas.setText(disp);
    }

    private void comun() {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "SELECT Tipo, COUNT( Tipo) maximo FROM Viviendas GROUP BY Tipo ORDER BY maximo DESC LIMIT 1";
        Cursor c = db.rawQuery(SQL, null);
        String disp = "";

        if(c.moveToFirst()){
            do{
                disp = c.getString(0);
            }while(c.moveToNext());
        }
        db.close();
        tvTipoComun.setText(disp);
    }

    private void valorPromedio() {
        DbHelper helper = new DbHelper(this, "BD", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "SELECT AVG(Precio) FROM Viviendas WHERE Arrendada = \"SI\";";
        Cursor c = db.rawQuery(SQL, null);
        String disp = "";

        if(c.moveToFirst()){
            do{
                disp = c.getString(0);
            }while(c.moveToNext());
        }
        db.close();
        tvValorProm.setText(disp);
    }

    private void conectar() {
        tvMejorCliente = findViewById(R.id.tvMejorCliente);
        tvNumArrendadas = findViewById(R.id.tvNumeroArrendadas);
        tvNumDisponibles = findViewById(R.id.tvNumeroDisponibles);
        tvNumRecibidas = findViewById(R.id.tvNumeroRecibidas);
        tvTipoComun = findViewById(R.id.tvViviendaComun);
        tvValorProm = findViewById(R.id.tvPromedioArrendos);
        dp = findViewById(R.id.dpFecha);
        btnBuscar = findViewById(R.id.btnBuscar);
        lvMostrar = findViewById(R.id.lvEnDia);
    }
}
