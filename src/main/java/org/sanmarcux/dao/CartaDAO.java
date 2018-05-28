/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao;

import com.google.appengine.api.datastore.Entity;
import org.sanmarcux.domain.Carta;

import java.util.List;

/**
 * @author cesardl
 */
public interface CartaDAO {

    String KIND_CARTA = Carta.class.getCanonicalName();

    List<Entity> getCartas();
}
