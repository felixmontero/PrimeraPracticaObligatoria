package com.liceu.geom.services;

public class Circulo {

        public double radio;

        public Circulo(double radio) {
            radio = this.radio;
        }

        public void setRadio(double añadirRadio){
            radio = añadirRadio;
        }
        public double getRadio(){
            return radio;
        }
        public double areaCirculo(){
            double area;
            area = Math.PI *(radio*radio);
            return area;
        }
        public double longitud(){
            double longitud;
            longitud = 2 * Math.PI * radio;
            return longitud;
        }
    }

