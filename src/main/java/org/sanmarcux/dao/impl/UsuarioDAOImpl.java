/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import org.sanmarcux.dao.UsuarioDAO;
import org.sanmarcux.domain.Usuario;

/**
 * @author cesardl
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario getUsuario(Usuario usuario) {
        if ("admin".equals(usuario.getClave())) {
            usuario.setIdUsuario(1);
            usuario.setNombres("Cesar");
            usuario.setApellidos("Diaz");
            return usuario;
        }
        return null;
    }
}
