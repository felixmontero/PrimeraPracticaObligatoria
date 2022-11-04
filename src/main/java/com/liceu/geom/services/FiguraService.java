package com.liceu.geom.services;

import com.liceu.geom.DAO.FiguraDAO;
import com.liceu.geom.DAO.FiguraDAOImpl;
import com.liceu.geom.model.Figura;
import com.liceu.geom.model.Usuario;

import java.util.List;

public class FiguraService {
    static int id = 1;
    FiguraDAO figuraDAO = new FiguraDAOImpl();
    public Figura guardarFigura(String nombreFigura,String tipo,int xCord,int yCord, int size, String color,int idUsuario){

        Figura figura = new Figura();
        figura.setIdFigura(id);
        figura.setNombreFigura(nombreFigura);
        figura.setColor(color);
        figura.setTipo(tipo);
        figura.setSize(size);
        figura.setxCord(xCord);
        figura.setyCord(yCord);
        figura.setIdUsuario(idUsuario);
        figuraDAO.save(figura);
        id++;
        return figura;

    }


    public List<Figura> getFigures() {

        return figuraDAO.getAllFiguras();
    }

    public List<Figura> getMeFigures(int idSession){
        for (Figura figura:figuraDAO.getAllFiguras()) {
            if (figura.getIdUsuario() == idSession){
                figuraDAO.saveMe(figura);
            }
        }
        return figuraDAO.getAllMeFiguras();
    }
}
