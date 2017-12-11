/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import org.sanmarcux.dao.VariedadesDAO;
import org.sanmarcux.domain.Carta;
import org.sanmarcux.domain.Variedades;
import org.sanmarcux.util.PolleriaUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * @author cesardl
 */
public class VariedadesDAOImpl implements VariedadesDAO {

    @Override
    public List<Variedades> getVariedadesByCarta(Carta carta) {
        EntityManager entityManager = PolleriaUtil.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery("SELECT v FROM Variedades v WHERE v.carta.idCarta = :id_carta").
                setParameter("id_carta", carta.getIdCarta());
        return query.getResultList();
    }
}
