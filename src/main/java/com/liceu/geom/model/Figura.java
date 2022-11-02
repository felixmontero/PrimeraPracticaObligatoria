package com.liceu.geom.model;

public class Figura {
    String tipo;
    int xCord;
    int yCord;
    int size;
    String color;
    public Figura( String tipo,int xCord,int yCord,int size,String color) {
        this.tipo= tipo;
        this.xCord=xCord;
        this.yCord=yCord;
        this.size=size;
        this.color=color;
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
