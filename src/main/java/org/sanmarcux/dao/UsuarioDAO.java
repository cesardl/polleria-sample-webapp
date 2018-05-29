/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao;

import org.sanmarcux.domain.Usuario;

import java.util.Map;

/**
 * @author root
 */
public interface UsuarioDAO {

    String KIND_USUARIO = Usuario.class.getCanonicalName();

    Usuario getUsuario(String username, String password);

    String saveUsuario(Map<String, Object> userContent);
}
