package com.example.parcial_cuantosabesdefutbol;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoApuestas {

    Context context;

    private static String fileLogin = "Apuestas.txt";
    FileInputStream fis;
    FileOutputStream fos;

    public ArchivoApuestas(Context ctx) {
        this.context = ctx;
    }

    public void escribir(String text) throws IOException {
        fos = context.openFileOutput(fileLogin, context.MODE_APPEND);
        fos.write(text.getBytes());
        fos.write('\n');
        fos.close();
    }

    public ArrayList<Apuestas> leer() throws IOException {
        ArrayList<Apuestas> lista = new ArrayList<>();
        int i = 2, cont = 0;
        String apost = "", eq1 = "", eq2 = "", eqGan = "", fPart = "", fApues = "", cantApues, lectura = "";
        char caracter;
        fis = context.openFileInput("Apuestas.txt");
        while (i > 0) {
            i = fis.read();
            caracter = (char) i;
            lectura += caracter;
            if (i == '\n') {
                switch (cont) {
                    case 0:
                        apost = lectura.trim();
                        break;
                    case 1:
                        eq1 = lectura.trim();
                        break;
                    case 2:
                        eq2 = lectura.trim();
                        break;
                    case 3:
                        eqGan = lectura.trim();
                        break;
                    case 4:
                        fPart = lectura.trim();
                        break;
                    case 5:
                        fApues = lectura.trim();
                        break;
                    case 6:
                        cantApues = lectura.trim();
                        Apuestas p = new Apuestas(apost, eq1, eq2, eqGan, fPart, fApues, cantApues);
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
