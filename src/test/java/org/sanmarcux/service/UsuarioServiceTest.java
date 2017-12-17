package org.sanmarcux.service;

import org.junit.Test;
import org.sanmarcux.domain.Usuario;

import static org.junit.Assert.*;

/**
 * Created on 16/12/2017.
 *
 * @author Cesardl
 */
public class UsuarioServiceTest {

    private UsuarioService service = new UsuarioService();

    @Test
    public void validarUsuarioCorrectoTest() {
        Usuario usuario = new Usuario();
        usuario.setUsuario("admin");
        usuario.setClave("admin");
        Usuario result = service.validarUsuario(usuario);

        assertNotNull(result);
        assertNotNull(result.getIdUsuario());
        assertNotNull(result.getNombres());
        assertNotNull(result.getApellidos());

        assertEquals(usuario.getUsuario(), result.getUsuario());
        assertEquals(usuario.getClave(), result.getClave());
    }

    @Test
    public void validarUsuarioInorrectoTest() {
        Usuario usuario = new Usuario();
        usuario.setUsuario("admin");
        usuario.setClave("111111");
        Usuario result = service.validarUsuario(usuario);

        assertNull(result);
    }
}