package com.example.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {

    String Table = "create table Contactos (Id Integer primary key, Nombre Text, Telefono Text)";

    public DbHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Contactos");
        db.execSQL(Table);
    }
}
