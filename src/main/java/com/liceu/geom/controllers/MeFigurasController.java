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
import java.util.List;
@WebServlet("/meFigures")
public class MeFigurasController extends HttpServlet {
    FiguraService figuraService = new FiguraService();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.getAttribute("id");
        int sessionId = (int) session.getAttribute("id");
        List<Figura> figures = figuraService.getMeFigures(sessionId);

       req.setAttribute("figures",figures);

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/meFigures.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/verFigures.jsp");
        dispatcher.forward(req, resp);
    }
}
