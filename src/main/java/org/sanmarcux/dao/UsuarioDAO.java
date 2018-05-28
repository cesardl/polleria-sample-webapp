/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao;

import com.google.appengine.api.datastore.Entity;
import org.sanmarcux.domain.Usuario;

/**
 * @author root
 */
public interface UsuarioDAO {

    String KIND_USUARIO = Usuario.class.getCanonicalName();

    Entity getUsuario(String username, String password);
}
