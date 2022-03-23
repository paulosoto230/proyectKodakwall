/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.Usuario;
import com.inacap.entities.Zapatillascompletas;
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
public class ZapatillascompletasFacade extends AbstractFacade<Zapatillascompletas> implements ZapatillascompletasFacadeLocal {

    @PersistenceContext(unitName = "kodakwall-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ZapatillascompletasFacade() {
        super(Zapatillascompletas.class);
    }
      @Override
    public List<Zapatillascompletas> zapTodo(int idusuario) {
        EntityManager em = getEntityManager();
        List<Zapatillascompletas> Zapatillascompletas = em.createQuery("SELECT z FROM Zapatillascompletas z WHERE z.usuarioidUsuario = ?1")
                .setParameter(1, idusuario)
                .getResultList();
        return Zapatillascompletas;
    }

   
}
