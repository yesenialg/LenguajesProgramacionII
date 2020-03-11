package com.example.parcial_cuantosabesdefutbol;

public class Partidos {

    String equipo1, equipo2, fechaPartido;

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

    public String getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public Partidos(String eq1, String eq2, String fecha){
        equipo1 = eq1;
        equipo2 = eq2;
        fechaPartido = fecha;
    }
}
