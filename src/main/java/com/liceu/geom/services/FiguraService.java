package com.liceu.geom.services;

import com.liceu.geom.DAO.FiguraDAO;
import com.liceu.geom.DAO.FiguraDAOImpl;
import com.liceu.geom.model.Figura;
import com.liceu.geom.model.Usuario;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class FiguraService {
    static int id = 1;
    FiguraDAO figuraDAO = new FiguraDAOImpl();
    //FiguraService figuraService = new FiguraService();

    public void guardarFigura(String nombreFigura, String tipo, String fecha, String xCord, String yCord, String size, String color, int idUsuario, HttpServletRequest req) {
        boolean apto = true;
        HttpSession session = req.getSession();
        String errorMessage = "";
        Figura f = new Figura();
        if (!convertToNumberTest(String.valueOf(xCord))) {
            errorMessage = "La coordenada X ha de ser un nombre";
            session.setAttribute("errorMessage", errorMessage);
            apto = false;
        } else if (!convertToNumberTest(String.valueOf(yCord))) {
            errorMessage = "La coordenada Y ha de ser un nombre";
            session.setAttribute("errorMessage", errorMessage);
            apto = false;

        } else if (!convertToNumberTest(String.valueOf(size))) {
            errorMessage = "La grandària ha de ser un numero";
            session.setAttribute("errorMessage", errorMessage);
            apto = false;
        }
        if (apto) {

            int size1 = Integer.parseInt(size);
            int xCord1 = Integer.parseInt(xCord);
            int yCord1 = Integer.parseInt(yCord);
            Figura figura = new Figura();
            figura.setIdFigura(id);
            figura.setNombreFigura(nombreFigura);
            figura.setFecha(fecha);
            figura.setColor(color);
            figura.setTipo(tipo);
            figura.setSize(size1);
            figura.setxCord(xCord1);
            figura.setyCord(yCord1);
            figura.setIdUsuario(idUsuario);
            figuraDAO.save(figura);
            id++;
        }

    }

    boolean convertToNumberTest(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public List<Figura> getFigures() {

        return figuraDAO.getAllFiguras();
    }

    public List<Figura> getMeFigures(int idSession) {
        List<Figura> misFiguras = figuraDAO.getAllFiguras();
        for (Figura figura : misFiguras) {
            //if (figuraDAO.getAllMeFiguras().size() > 0) {
            figuraDAO.getAllMeFiguras().remove(figura);
        }
        for (Figura figura : figuraDAO.getAllFiguras()) {
            if (figura.getIdUsuario() == idSession) {
                figuraDAO.saveMe(figura);
            }
        }
        return figuraDAO.getAllMeFiguras();
    }

    public boolean comprobacionNombre(String nombreFigura, int idSession) {
        List<Figura> misFiguras = figuraDAO.getAllFiguras();

        for (Figura figura : misFiguras) {
            if (figura.getIdUsuario() == idSession) {
                if (nombreFigura.equals(figura.getNombreFigura())) {
                    return true;
                }
            }
        }
        return false;
    }

    public Figura getMeFigura(int idFigura) {
        List<Figura> misFiguras = figuraDAO.getAllFiguras();

        for (Figura figura : misFiguras) {
            if (figura.getIdFigura() == idFigura) {

                return figura;

            }
        }
        return null;
    }

    public void removeFigura(Figura figura) {

        figuraDAO.deleteFiguras(figura);

    }
}
