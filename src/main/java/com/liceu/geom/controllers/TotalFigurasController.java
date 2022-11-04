package com.liceu.geom.controllers;

import com.liceu.geom.model.Figura;
import com.liceu.geom.model.Message;
import com.liceu.geom.services.FiguraService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/totalFigures")
public class TotalFigurasController extends HttpServlet {

    FiguraService figuraService = new FiguraService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Figura> figures =figuraService.getFigures();

        req.setAttribute("figures",figures);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/totalFigures.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/totalFigures.jsp");
        dispatcher.forward(req, resp);
    }
}
