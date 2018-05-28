/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import org.sanmarcux.dao.CartaDAO;
import org.sanmarcux.util.PolleriaUtil;

import java.util.List;


/**
 * @author cesardl
 */
public class CartaDAOImpl implements CartaDAO {

    @Override
    public List<Entity> getCartas() {
        final Query q = new Query(KIND_CARTA);

        PreparedQuery pq = PolleriaUtil.getDatastoreService().prepare(q);
        return pq.asList(FetchOptions.Builder.withDefaults());
    }
}
