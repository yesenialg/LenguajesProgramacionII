package com.example.parcial_cuantosabesdefutbol;

public class Marcadores {

    String equipo1, equipo2, equipoGanador, fecha;

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Marcadores(String eq1, String eq2, String eqgan, String fechaPart){
        equipo1 = eq1;
        equipo2 = eq2;
        equipoGanador = eqgan;
        fecha = fechaPart;
    }
}
