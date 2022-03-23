/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.Noticia;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZALO
 */
@Stateless
public class NoticiaFacade extends AbstractFacade<Noticia> implements NoticiaFacadeLocal {

    @PersistenceContext(unitName = "kodakwall-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoticiaFacade() {
        super(Noticia.class);
    }
    
}
