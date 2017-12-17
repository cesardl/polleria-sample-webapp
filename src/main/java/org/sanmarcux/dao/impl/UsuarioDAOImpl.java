/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sanmarcux.dao.impl;

import org.sanmarcux.dao.UsuarioDAO;
import org.sanmarcux.domain.Usuario;
import org.sanmarcux.util.PolleriaUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 * @author cesardl
 */
public class UsuarioDAOImpl implements UsuarioDAO {

    @Override
    public Usuario getUsuario(Usuario usuario) {
        EntityManager entityManager = PolleriaUtil.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createNamedQuery("Usuario.findByDataUsuario").
                setParameter("usuario", usuario.getUsuario()).
                setParameter("clave", usuario.getClave());
        try {
            return (Usuario) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
