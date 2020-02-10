package com.example.alea_recursivo;

public class Jugador {

    private int intentos;
    private int puntos;

    public Jugador(int intentos){
        intentos = 0;
        puntos = 0;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void sumarPuntos(int cantidad){
        puntos += cantidad;
    }

    public void sumarIntentos(){
        intentos++;
    }
}
