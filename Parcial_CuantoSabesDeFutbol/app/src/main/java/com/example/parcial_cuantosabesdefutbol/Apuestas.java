package com.example.parcial_cuantosabesdefutbol;

public class Apuestas {

    String apostador, equipo1, equipo2, equipoGanador, fechaPartido, fechaApuesta, cantApuesta;

    public String getApostador() {
        return apostador;
    }

    public void setApostador(String apostador) {
        this.apostador = apostador;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getFechaApuesta() {
        return fechaApuesta;
    }

    public void setFechaApuesta(String fechaApuesta) {
        this.fechaApuesta = fechaApuesta;
    }

    public String getCantApuesta() {
        return cantApuesta;
    }

    public void setCantApuesta(String cantApuesta) {
        this.cantApuesta = cantApuesta;
    }

    public Apuestas (String apost, String eq1, String eq2, String eqGan, String fechaPart, String fechaApues, String cantApues){
        apostador = apost;
        equipo1 = eq1;
        equipo2 = eq2;
        equipoGanador = eqGan;
        fechaPartido = fechaPart;
        fechaApuesta = fechaApues;
        cantApuesta = cantApues;
    }


}
