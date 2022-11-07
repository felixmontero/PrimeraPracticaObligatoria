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

@WebServlet("/verFigures")
public class VerFiguraController extends HttpServlet {
    FiguraService figuraService = new FiguraService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        int idFigura = Integer.parseInt( req.getParameter("idFigura"));
        Figura figura=figuraService.getMeFigura(idFigura);
        req.setAttribute("figura",figura);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/verFigures.jsp");
        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/verFigures.jsp");
        dispatcher.forward(req, resp);
    }
}
