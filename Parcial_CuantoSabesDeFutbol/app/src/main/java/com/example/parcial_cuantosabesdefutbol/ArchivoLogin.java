package com.example.parcial_cuantosabesdefutbol;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoLogin {

    Context context;

    private static String fileLogin = "Login.txt";
    FileInputStream fis;
    FileOutputStream fos;

    public ArchivoLogin(Context ctx) {
        this.context = ctx;
    }

    public void escribir(String text) throws IOException {
        fos = context.openFileOutput(fileLogin, context.MODE_APPEND);
        fos.write(text.getBytes());
        fos.write('\n');
        fos.close();
    }

    public ArrayList<Usuarios> leer() throws IOException {
        ArrayList<Usuarios> lista = new ArrayList<>();
        int i = 2, cont = 0;
        String t = "", u = "", c = "", lectura = "";
        char caracter;
        fis = context.openFileInput("Login.txt");
        while (i > 0) {
            i = fis.read();
            caracter = (char) i;
            lectura += caracter;
            if (i == '\n') {
                switch (cont) {
                    case 0:
                        t = lectura.trim();
                        break;
                    case 1:
                        u = lectura.trim();
                        break;
                    case 2:
                        c = lectura.trim();
                        Usuarios p = new Usuarios(t, u, c);
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
