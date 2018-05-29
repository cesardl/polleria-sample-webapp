package org.sanmarcux.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sanmarcux.dao.UsuarioDAO;
import org.sanmarcux.dao.impl.UsuarioDAOImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created on 27/05/2018.
 *
 * @author Cesardl
 */
public class PolleriaBootstrap {

    private ObjectMapper objectMapper;
    private UsuarioDAO usuarioDAO;

    private static final PolleriaBootstrap INSTANCE = new PolleriaBootstrap();

    public static PolleriaBootstrap getInstance() {
        return INSTANCE;
    }

    private PolleriaBootstrap() {
        objectMapper = new ObjectMapper();
        usuarioDAO = new UsuarioDAOImpl();
    }

    public void initUsuarios() throws IOException {
        List<Map<String, Object>> usuarios = objectMapper.readValue(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(
                        "data/polleria_usuario.json"), new TypeReference<List<Map<String, Object>>>() {
                }
        );
        System.out.println(usuarios);
        String userKey = usuarioDAO.saveUsuario(usuarios.get(0));
        System.out.println(userKey);
    }

    public void initCartas() throws IOException {
        List<Map<String, Object>> cartas = objectMapper.readValue(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(
                        "data/polleria_carta.json"), new TypeReference<List<Map<String, Object>>>() {
                }
        );
        System.out.println(cartas);
    }

    public void initVariedades() throws IOException {
        List<Map<String, Object>> variedades = objectMapper.readValue(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(
                        "data/polleria_variedades.json"), new TypeReference<List<Map<String, Object>>>() {
                }
        );
        System.out.println(variedades);
    }
}
