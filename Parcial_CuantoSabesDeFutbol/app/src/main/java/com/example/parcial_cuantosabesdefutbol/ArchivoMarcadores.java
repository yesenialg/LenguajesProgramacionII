package com.example.parcial_cuantosabesdefutbol;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoMarcadores {

    Context context;
    FileInputStream fis;

    public ArchivoMarcadores(Context ctx) {
        this.context = ctx;
    }

    public ArrayList<Marcadores> leer() throws IOException {
        ArrayList<Marcadores> lista = new ArrayList<>();
        int i = 2, cont = 0;
        String eq1 = "", eq2 = "", eqGan = "", fPart, lectura = "";
        char caracter;
        fis = context.openFileInput("Marcadores.txt");
        while (i > 0) {
            i = fis.read();
            caracter = (char) i;
            lectura += caracter;
            if (i == '\n') {
                switch (cont) {
                    case 0:
                        eq1 = lectura.trim();
                        break;
                    case 1:
                        eq2 = lectura.trim();
                        break;
                    case 2:
                        eqGan = lectura.trim();
                        break;
                    case 3:
                        fPart = lectura.trim();
                        Marcadores p = new Marcadores(eq1, eq2, eqGan, fPart);
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
