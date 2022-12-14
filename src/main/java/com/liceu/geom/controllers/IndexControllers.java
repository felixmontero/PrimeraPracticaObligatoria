package com.liceu.geom.controllers;

import com.liceu.geom.model.Message;
import com.liceu.geom.services.TextService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class IndexControllers extends HttpServlet {
    TextService textService = new TextService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messages = textService.getAllMessages();
        req.setAttribute("messages", messages);
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getParameter("borrarFigura");
        String text = req.getParameter("text");
        textService.newText(text);
        resp.sendRedirect("/index");
    }
}
