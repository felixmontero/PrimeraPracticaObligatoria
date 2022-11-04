package com.liceu.geom.DAO;

import com.liceu.geom.model.Figura;
import com.liceu.geom.model.Usuario;

import java.util.List;

public interface UsuarioDAO {

    void save (Usuario m);

    List<Usuario> getAllUsuarios();
}
