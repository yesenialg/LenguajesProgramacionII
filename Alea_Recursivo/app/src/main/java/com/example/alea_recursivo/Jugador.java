package com.example.alea_recursivo;

public class Jugador {

    private int intentos;
    private int puntos;

    public Jugador(){
        intentos = 0;
        puntos = 0;
    }

    public String getIntentos() {
        return intentos + "";
    }

    public void setIntentos(int intentos) {
        this.intentos += intentos;
    }

    public String getPuntos() {
        return puntos+"";
    }

    public int getPuntosint() {
        return puntos;
    }
    public void setPuntos(int puntos) {
        this.puntos += puntos;
    }
}
