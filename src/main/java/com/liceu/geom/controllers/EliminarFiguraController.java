package com.liceu.geom.controllers;

import com.liceu.geom.model.Figura;
import com.liceu.geom.services.FiguraService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/eliminarFigura")
public class EliminarFiguraController extends HttpServlet {
    FiguraService figureService = new FiguraService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int idFigura = Integer.parseInt(req.getParameter("idFigura"));
        int idSession=(int) session.getAttribute("id");
        Figura figura = figureService.getMeFigura(idFigura);

        if (figura.getIdUsuario() == idSession) {
            figureService.removeFigura(figura);
            resp.sendRedirect("/totalFigures");

            return;
        }

        resp.getWriter().println("no pots eliminar una figura que no es teva figura");
        resp.setHeader("Refresh", "4; URL=/ventanaPrincipal");
    }
}