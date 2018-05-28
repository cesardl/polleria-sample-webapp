package org.sanmarcux.service;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sanmarcux.domain.Carta;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created on 16/12/2017.
 *
 * @author Cesardl
 */
public class CartaServiceTest {

    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    private CartaService service = new CartaService();

    @Before
    public void setUp() {
        helper.setUp();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void getListaCartasTest() {
        List<Carta> result = service.getListaCartas();

        assertTrue(result.isEmpty());
    }
}