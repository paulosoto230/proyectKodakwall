/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ZALO
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "kodakwall-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    
    @Override
    public Usuario Validar(String email) {

        try {

            TypedQuery<Usuario> q = em.createNamedQuery("Usuario.findByCorreo", Usuario.class);
            q.setParameter("correo", email);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Usuario> email(String email) {
        EntityManager em = getEntityManager();
        List<Usuario> usuario = em.createQuery("SELECT u FROM Usuario u WHERE u.correo = ?1")
                .setParameter(1, email)
                .getResultList();
        return usuario;
    }
}
    

