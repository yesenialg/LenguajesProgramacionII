package com.example.parcial_cuantosabesdefutbol;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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
            fos.write(text.getBytes());
            fos.write('\n');
            fos.close();
    }

    public ArrayList<Partidos> leer() throws IOException {
        ArrayList<Partidos> lista = new ArrayList<>();
        int i = 2, cont = 0;
        String equi1 = "", equi2 = "", fecha = "", lectura = "";
        char caracter;
        fis = context.openFileInput("Partidos.txt");
        while (i>0){
            i = fis.read();
            caracter = (char)i;
            lectura += caracter;
            if(i == '\n'){
                switch (cont) {
                    case 0:
                        equi1 = lectura;
                        break;
                    case 1:
                        equi2 = lectura;
                        break;
                    case 2:
                        fecha = lectura;
                        Partidos p = new Partidos(equi1, equi2, fecha);
                        lista.add(p);
                        cont = -1;
                        break;
                }
                lectura = "";
                cont++;
            }
        }
        return lista;
    }
}
