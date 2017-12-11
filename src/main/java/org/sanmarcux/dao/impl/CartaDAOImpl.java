/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import org.sanmarcux.dao.CartaDAO;
import org.sanmarcux.domain.Carta;
import org.sanmarcux.util.PolleriaUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author cesardl
 */
public class CartaDAOImpl implements CartaDAO {

    @Override
    public List<Carta> getCartas() {
        EntityManager entityManager = PolleriaUtil.getEntityManagerFactory().createEntityManager();
        return entityManager.createNamedQuery("Carta.findAll").getResultList();
    }
}
