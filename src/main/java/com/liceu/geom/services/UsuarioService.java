package com.liceu.geom.services;

import com.liceu.geom.DAO.FiguraDAO;
import com.liceu.geom.DAO.FiguraDAOImpl;
import com.liceu.geom.DAO.UsuarioDAO;
import com.liceu.geom.DAO.UsuarioDAOImpl;
import com.liceu.geom.model.Usuario;

public class UsuarioService {
    static int id = 1;
    UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
    public Usuario guardarUsuario(String nombre){
        Usuario u = new Usuario();
        u.setId(id);
        u.setNombre(nombre);
        usuarioDAO.save(u);
        id++;
        return u;

    }
}
