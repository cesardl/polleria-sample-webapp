/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.util;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;

/**
 * @author cesardl
 */
public class PolleriaUtil {

    private static DatastoreService datastore;

    static {
        datastore = DatastoreServiceFactory.getDatastoreService();
    }

    public static DatastoreService getDatastoreService() {
        return datastore;
    }

}
