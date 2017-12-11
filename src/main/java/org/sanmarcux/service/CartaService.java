/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.service;

import org.sanmarcux.dao.CartaDAO;
import org.sanmarcux.dao.impl.CartaDAOImpl;
import org.sanmarcux.domain.Carta;

import java.util.List;

/**
 * @author cesardl
 */
public class CartaService {

    private CartaDAO dao;

    public CartaService() {
        dao = new CartaDAOImpl();
    }

    public List<Carta> getListaCartas() {
        return dao.getCartas();
    }
}
