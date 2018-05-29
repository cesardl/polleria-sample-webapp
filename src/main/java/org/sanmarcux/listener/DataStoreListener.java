package org.sanmarcux.listener;

import org.sanmarcux.bootstrap.PolleriaBootstrap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * Created on 27/05/2018.
 *
 * @author Cesardl
 */
@WebListener
public class DataStoreListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().log("Starting up!");

        PolleriaBootstrap bootstrap = PolleriaBootstrap.getInstance();
        try {
            bootstrap.initUsuarios();
            bootstrap.initCartas();
            bootstrap.initVariedades();
        } catch (IOException e) {
            servletContextEvent.getServletContext().log(e.getMessage(), e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        // App Engine does not currently invoke this method.
    }
}
