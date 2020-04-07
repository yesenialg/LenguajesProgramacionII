package com.example.habitathorizontal_bdt1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    String Table = "create table Viviendas (Id Integer primary key, Tipo Text, Precio Text, Direccion Text," +
            "NombreProp Text, Telefono Text, FechaRecep Text, Arrendada Text)";

    public DbHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Viviendas");
        db.execSQL(Table);
    }
}

