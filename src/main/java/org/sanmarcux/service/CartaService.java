/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.service;

import com.google.appengine.api.datastore.KeyFactory;
import org.sanmarcux.dao.CartaDAO;
import org.sanmarcux.dao.impl.CartaDAOImpl;
import org.sanmarcux.domain.Carta;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author cesardl
 */
public class CartaService {

    private static final Logger LOG = Logger.getLogger(CartaService.class.getCanonicalName());

    private CartaDAO dao;

    private AtomicInteger idx;

    public CartaService() {
        dao = new CartaDAOImpl();
    }

    public List<Carta> getListaCartas() {
        idx = new AtomicInteger();

        List<Carta> cartas = dao.getCartas().stream().map(result -> {
            LOG.info("Leyendo informacion de la carta " + idx);

            // Grab the key and convert it into a string in preparation for encoding
            String keyString = KeyFactory.keyToString(result.getKey());

            // Encode the entity's key with Base64
            String encodedID = Base64.getUrlEncoder().encodeToString(String.valueOf(keyString).getBytes());

            Carta carta = new Carta();
            carta.setKeyCarta(encodedID);
            carta.setIdCarta(idx.incrementAndGet());
            return carta;
        }).collect(Collectors.toList());

        if (cartas.isEmpty()) {
            LOG.fine("No datos de tipo de carta registrado");
            return Collections.emptyList();
        } else {
            LOG.fine("Se obtuvieron " + cartas.size() + " registros");
            return cartas;
        }
    }
}
