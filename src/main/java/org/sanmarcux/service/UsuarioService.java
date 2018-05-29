/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.service;

import org.sanmarcux.dao.UsuarioDAO;
import org.sanmarcux.dao.impl.UsuarioDAOImpl;
import org.sanmarcux.domain.Usuario;

/**
 * @author Cesardl
 */
public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService() {
        dao = new UsuarioDAOImpl();
    }

    public Usuario validarUsuario(String username, String password) {
        return dao.getUsuario(username, password);
    }
}
