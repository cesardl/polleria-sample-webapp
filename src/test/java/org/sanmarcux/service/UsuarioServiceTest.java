package org.sanmarcux.service;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sanmarcux.bootstrap.PolleriaBootstrap;
import org.sanmarcux.domain.Usuario;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created on 16/12/2017.
 *
 * @author Cesardl
 */
public class UsuarioServiceTest {

    private final LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    private UsuarioService service = new UsuarioService();

    @Before
    public void setUp() throws IOException {
        helper.setUp();
        PolleriaBootstrap.getInstance().initUsuarios();
    }

    @After
    public void tearDown() {
        helper.tearDown();
    }

    @Test
    public void validarUsuarioCorrectoTest() {
        String username = "admin";
        String password = "admin";

        Usuario result = service.validarUsuario(username, password);

        assertNotNull(result);
        assertNotNull(result.getIdUsuario());
        assertNotNull(result.getNombres());
        assertNotNull(result.getApellidos());

        assertEquals(username, result.getUsuario());
        assertEquals(password, result.getClave());
    }

    @Test
    public void validarUsuarioIncorrectoTest() {
        String username = "admin";
        String password = "123456";
        Usuario result = service.validarUsuario(username, password);

        assertNull(result);
    }
}