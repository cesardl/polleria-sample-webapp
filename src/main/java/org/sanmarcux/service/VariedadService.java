/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.service;

import org.sanmarcux.dao.VariedadesDAO;
import org.sanmarcux.dao.impl.VariedadesDAOImpl;
import org.sanmarcux.domain.Carta;
import org.sanmarcux.domain.Variedades;

import java.util.List;

/**
 * @author cesardl
 */
public class VariedadService {

    private VariedadesDAO dao;

    public VariedadService() {
        dao = new VariedadesDAOImpl();
    }

    public List<Variedades> getVariedadesByCarta(Carta carta) {
        return dao.getVariedadesByCarta(carta);
    }
}
