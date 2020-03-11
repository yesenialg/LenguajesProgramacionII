package com.example.parcial_cuantosabesdefutbol;

public class Usuarios {

    String tipo, usuario, contrasena;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Usuarios (String t, String u, String c){
        tipo = t;
        usuario = u;
        contrasena = c;
    }
}
