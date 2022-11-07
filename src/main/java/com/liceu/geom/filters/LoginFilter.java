package com.liceu.geom.filters;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = { "/ventanaPrincipal","/totalFigures","/verFigures","/meFigures" }) // "/verFigures","/ventanaPrincipal","/totalFigures","/meFigures","/eliminarFigura"})
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if(session.getAttribute("id") == null ) {

            res.setStatus(401);
            PrintWriter pw = res.getWriter();
            pw.print("no autoritzat dins filtre");
            RequestDispatcher dispatcher =
                    req.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(req, res);

        }
        // doFilter(req,res,chain);
        chain.doFilter(req,res);
    }
}


