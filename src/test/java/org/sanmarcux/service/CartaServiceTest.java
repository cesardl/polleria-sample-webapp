package org.sanmarcux.service;

import org.junit.Test;
import org.sanmarcux.domain.Carta;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created on 16/12/2017.
 *
 * @author Cesardl
 */
public class CartaServiceTest {

    private CartaService service = new CartaService();

    @Test
    public void getListaCartasTest() {
        List<Carta> result = service.getListaCartas();

        assertFalse(result.isEmpty());
        assertEquals(4, result.size());
    }
}