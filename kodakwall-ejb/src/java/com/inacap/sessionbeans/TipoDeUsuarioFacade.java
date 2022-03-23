/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.TipoDeUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZALO
 */
@Stateless
public class TipoDeUsuarioFacade extends AbstractFacade<TipoDeUsuario> implements TipoDeUsuarioFacadeLocal {

    @PersistenceContext(unitName = "kodakwall-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDeUsuarioFacade() {
        super(TipoDeUsuario.class);
    }
    
}
