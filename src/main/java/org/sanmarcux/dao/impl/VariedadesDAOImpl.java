/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import org.sanmarcux.dao.VariedadesDAO;
import org.sanmarcux.domain.Carta;
import org.sanmarcux.domain.Variedades;

import java.util.Collections;
import java.util.List;

/**
 * @author cesardl
 */
public class VariedadesDAOImpl implements VariedadesDAO {

    @Override
    public List<Variedades> getVariedadesByCarta(Carta carta) {
        return Collections.emptyList();
    }
}
