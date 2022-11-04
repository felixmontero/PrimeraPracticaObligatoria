package com.liceu.geom.model;

public class Usuario {

    int idUsuario;
    String nombre;
    public Usuario(){}

    public Usuario(int id, String nombre){
        this.idUsuario=id;
        this.nombre=nombre;
    }

    public int getId() {
        return idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
