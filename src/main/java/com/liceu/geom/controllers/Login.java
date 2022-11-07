package com.liceu.geom.controllers;

import com.liceu.geom.model.Usuario;
import com.liceu.geom.services.UsuarioService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    UsuarioService usuarioService = new UsuarioService();

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(req, resp);
        }
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/figures.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombreUsuario = (String) req.getParameter("user");
        Usuario usuario = usuarioService.guardarUsuario(nombreUsuario);
        if (usuario != null) {
            HttpSession session = req.getSession();
            session.setAttribute("id", usuario.getId());
            resp.sendRedirect("/ventanaPrincipal");
            return;
        }
        req.setAttribute("message", "Usuari i/o password no correctes");
        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }
}
