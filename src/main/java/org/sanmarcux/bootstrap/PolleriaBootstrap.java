package org.sanmarcux.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sanmarcux.domain.Usuario;

import java.io.IOException;
import java.util.List;

/**
 * Created on 27/05/2018.
 *
 * @author Cesardl
 */
public class PolleriaBootstrap {

    private void init() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        List<Usuario> usuarios = objectMapper.readValue(
                Thread.currentThread().getContextClassLoader().getResourceAsStream(
                        "org/sanmarcux/bootstrap/polleria_usuario.json"), new TypeReference<List<Usuario>>() {
                }
        );

        System.out.println(usuarios);
    }

    public static void main(String[] args) {
        try {
            PolleriaBootstrap polleriaBootstrap = new PolleriaBootstrap();
            polleriaBootstrap.init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
