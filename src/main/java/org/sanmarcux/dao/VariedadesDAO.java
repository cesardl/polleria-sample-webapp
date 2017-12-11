/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao;

import org.sanmarcux.domain.Carta;
import org.sanmarcux.domain.Variedades;

import java.util.List;

/**
 * @author cesardl
 */
public interface VariedadesDAO {

    List<Variedades> getVariedadesByCarta(Carta carta);
}
