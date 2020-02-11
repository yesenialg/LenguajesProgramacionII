package com.example.alea_recursivo;

public class Jugador {

    private int intentos;
    private int puntos;

    public Jugador(){
        intentos = 0;
        puntos = 0;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int inte) {
        intentos = inte;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int punt) {
        this.puntos = punt;
    }

    public void sumarPuntos(int cantidad){
        puntos += cantidad;
    }

    public void sumarIntentos(){
        intentos++;
    }
}
