package org.sanmarcux.listener;

import org.sanmarcux.dao.CartaDAO;
import org.sanmarcux.dao.impl.CartaDAOImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created on 27/05/2018.
 *
 * @author Cesardl
 */
public class DataStoreListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Starting up!");
        CartaDAO cartaDAO = new CartaDAOImpl();
        cartaDAO.getCartas();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Shutting down!");
    }
}
