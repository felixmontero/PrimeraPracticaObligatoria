package com.liceu.geom.DAO;

import com.liceu.geom.model.Figura;
import com.liceu.geom.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO{

    static List<Usuario> usuarioList = new ArrayList<>();


    @Override
    public void save(Usuario m) {
        usuarioList.add(m);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioList;
    }
}
