package com.example.parcial_cuantosabesdefutbol;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArchivoPartidos {

    Context context;

    private static String filePartidos = "Partidos.txt";
    FileInputStream fis;
    FileOutputStream fos;

    public ArchivoPartidos ( Context ctx){
        this.context = ctx;
    }

    public void escribir(String text) throws IOException {
            fos = context.openFileOutput(filePartidos, context.MODE_APPEND);
            fos.write('\n');
            fos.write(text.getBytes());
            fos.close();

    }
}
