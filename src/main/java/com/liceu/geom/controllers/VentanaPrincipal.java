package com.liceu.geom.controllers;

import com.liceu.geom.services.FiguraService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ventanaPrincipal")
public class VentanaPrincipal extends HttpServlet {

    FiguraService figuraService = new FiguraService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figures.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String nombreFigura = req.getParameter("nombreFigura");

        int coordenadaX = Integer.parseInt(req.getParameter("xCord"));
        int coordenadaY = Integer.parseInt(req.getParameter("yCord"));
        String tipoFigura = req.getParameter("tipoFigura");
        int size = Integer.parseInt(req.getParameter("size"));
        String colorFigura = req.getParameter("color");
        boolean nombreRepetido = false;


        nombreRepetido = figuraService.comprobacionNombre(nombreFigura);

        if (nombreFigura.isEmpty() || nombreRepetido) {
            int numeroRandom = (int) (Math.random() * 10 + 1);
            nombreFigura = tipoFigura + numeroRandom;
        }


        figuraService.guardarFigura(nombreFigura, tipoFigura, coordenadaX, coordenadaY, size, tipoFigura, (int) session.getAttribute("id"));
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figures.jsp");
        dispatcher.forward(req, resp);

    }
}
