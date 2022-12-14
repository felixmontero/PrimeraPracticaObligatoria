package com.liceu.geom.controllers;

import com.liceu.geom.model.Figura;
import com.liceu.geom.services.FiguraService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
        String coordenadaX = req.getParameter("xCord");
        String coordenadaY = req.getParameter("yCord");
        String tipoFigura = req.getParameter("tipoFigura");
        String size = req.getParameter("size");
        String colorFigura = req.getParameter("color");
        boolean nombreRepetido = false;


        session.getAttribute("id");
        int sessionId = (int) session.getAttribute("id");

        do {
            nombreRepetido = figuraService.comprobacionNombre(nombreFigura, sessionId);

            if (nombreFigura.isEmpty()) {
                int numeroRandom = (int) (Math.random() * 10 + 1);
                nombreFigura = tipoFigura + numeroRandom;
            } else if (nombreRepetido) {
                PrintWriter pw = resp.getWriter();
                pw.print("No pots crear 2 figures amb el mateix nom!!");
                resp.setHeader("Refresh", "4; URL=/ventanaPrincipal");
                return;
            }
            nombreRepetido = figuraService.comprobacionNombre(nombreFigura, sessionId);
        } while (nombreRepetido);


        DateFormat dateFormat = new SimpleDateFormat("d MMM yyyy, HH:mm:ss z");

        String date = dateFormat.format(new Date());

        figuraService.guardarFigura(nombreFigura, tipoFigura, date, coordenadaX, coordenadaY, size, tipoFigura, (int) session.getAttribute("id"), req);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figures.jsp");
        dispatcher.forward(req, resp);

    }
}
