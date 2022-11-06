package com.liceu.geom.model;

public class Figura {
    String nombreFigura;
    String tipo;
    int xCord;
    int yCord;
    int size;
    String color;
    int idFigura;
    int idUsuario;
public Figura(){}
    public Figura(String nombreFigura,String tipo,int xCord,int yCord,int size,String color,int idUsuario) {
        this.nombreFigura=nombreFigura;
        this.tipo= tipo;
        this.xCord=xCord;
        this.yCord=yCord;
        this.size=size;
        this.color=color;
        this.idUsuario=idUsuario;
    }

    public String getNombreFigura() {
        return nombreFigura;
    }

    public void setNombreFigura(String nombreFigura) {
        this.nombreFigura = nombreFigura;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdFigura() {
        return idFigura;
    }

    public void setIdFigura(int idFigura) {
        this.idFigura = idFigura;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
