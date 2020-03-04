package com.example.practica1_pregculturageneral;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ArchivoPlano {


    Context cxt;
    FileOutputStream fos;
    FileInputStream fis;

    public ArchivoPlano(Context ctx){ this.cxt = ctx; }

    public ArrayList<Pregunta>  Leer(){
        try {
            ArrayList<Pregunta> lista = new ArrayList<>();
            int i = 2, puntaje, cont = 0;
            String preg="", op1="", op2="", op3="", correcta="", lectura = "";
            char caracter;
            fis = cxt.openFileInput("Preguntas.txt");
            while(i>0){
                i = fis.read();
                caracter = (char)i;
                lectura += caracter;
                if(i=='\n'){
                    switch (cont){
                        case 0:
                            preg = lectura;
                            break;
                        case 1:
                            op1 = lectura;
                            break;
                        case 2:
                            op2 = lectura;
                            break;
                        case 3:
                            op3 = lectura;
                            break;
                        case 4:
                            correcta = lectura;
                            break;
                        case 5:
                            puntaje = Integer.parseInt(lectura.trim());
                            Pregunta p = new Pregunta (preg, op1, op2, op3, correcta, puntaje);
                            lista.add(p);
                            cont = -1;
                            break;
                    }
                    lectura="";
                    cont++;
                }
            }
            return lista;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
