/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import com.google.appengine.api.datastore.*;
import org.sanmarcux.dao.UsuarioDAO;
import org.sanmarcux.domain.Usuario;
import org.sanmarcux.util.PolleriaUtil;

import java.util.Base64;
import java.util.Map;

/**
 * @author cesardl
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario getUsuario(String username, String password) {
        final Query q = new Query(KIND_USUARIO)
                .setFilter(new Query.FilterPredicate(Usuario.USUARIO, Query.FilterOperator.EQUAL, username))
                .setFilter(new Query.FilterPredicate(Usuario.CLAVE, Query.FilterOperator.EQUAL, password));

        PreparedQuery pq = PolleriaUtil.getDatastoreService().prepare(q);
        Entity entity = pq.asSingleEntity();

        if (entity == null) {
            return null;
        }

        return new Usuario.Builder()
                .idUsuario(Integer.valueOf(entity.getProperty(Usuario.ID_USUARIO).toString()))
                .usuario(entity.getProperty(Usuario.USUARIO).toString())
                .nombres(entity.getProperty(Usuario.NOMBRES).toString())
                .apellidos(entity.getProperty(Usuario.APELLIDOS).toString())
                .clave(entity.getProperty(Usuario.CLAVE).toString())
                .build();
    }

    public String saveUsuario(Map<String, Object> userContent) throws DatastoreFailureException {
        Entity user = new Entity(KIND_USUARIO); // create a new entity
        user.setProperty(Usuario.ID_USUARIO, userContent.get(Usuario.ID_USUARIO));
        user.setProperty(Usuario.USUARIO, userContent.get(Usuario.USUARIO));
        user.setProperty(Usuario.NOMBRES, userContent.get(Usuario.NOMBRES));
        user.setProperty(Usuario.APELLIDOS, userContent.get(Usuario.APELLIDOS));
        user.setProperty(Usuario.CLAVE, userContent.get(Usuario.CLAVE));

        Key key = PolleriaUtil.getDatastoreService().put(user); // store the entity;

        return Base64.getUrlEncoder().encodeToString(String.valueOf(KeyFactory.keyToString(key)).getBytes());
    }
}
