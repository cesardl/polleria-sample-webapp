/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import org.sanmarcux.dao.UsuarioDAO;
import org.sanmarcux.util.PolleriaUtil;

import java.util.Optional;

/**
 * @author cesardl
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Entity getUsuario(String username, String password) {
        final Query q = new Query(KIND_USUARIO)
                .setFilter(new Query.FilterPredicate("usuario", Query.FilterOperator.EQUAL, username))
                .setFilter(new Query.FilterPredicate("clave", Query.FilterOperator.EQUAL, password));

        PreparedQuery pq = PolleriaUtil.getDatastoreService().prepare(q);
        return pq.asSingleEntity();
    }
}
