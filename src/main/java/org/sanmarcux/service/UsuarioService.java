/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.service;

import com.google.appengine.api.datastore.Entity;
import org.sanmarcux.dao.UsuarioDAO;
import org.sanmarcux.dao.impl.UsuarioDAOImpl;
import org.sanmarcux.domain.Usuario;

/**
 * @author root
 */
public class UsuarioService {

    private UsuarioDAO dao;

    public UsuarioService() {
        dao = new UsuarioDAOImpl();
    }

    public Usuario validarUsuario(String username, String password) {
        Entity entity = dao.getUsuario(username, password);
        if (entity == null) {
            return null;
        }

        return new Usuario.Builder()
                .nombres(entity.getProperty(Usuario.NOMBRES).toString())
                .apellidos(entity.getProperty(Usuario.APELLIDOS).toString())
                .build();
    }
}
