/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.Aviso;
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
public class AvisoFacade extends AbstractFacade<Aviso> implements AvisoFacadeLocal {

    @PersistenceContext(unitName = "kodakwall-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvisoFacade() {
        super(Aviso.class);
    }

    @Override
    public Aviso Encontrar(String modelo) {

        try {

            TypedQuery<Aviso> q = em.createNamedQuery("Aviso.findByModelo", Aviso.class);
            q.setParameter("modelo", modelo);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Aviso> findMarca(String marca) {

        EntityManager em = getEntityManager();
        List<Aviso> avisos = em.createQuery("SELECT a FROM Aviso a WHERE a.marca = :codigo")
                .setParameter("codigo", marca)
                .getResultList();
        return avisos;
    }

    @Override
    public List<Aviso> buscarLike(String like) {
        String pro = "%" + like + "%";

        EntityManager em = getEntityManager();
        List<Aviso> avisos = em.createQuery("SELECT a FROM Aviso a WHERE a.modelo LIKE :codigo")
                .setParameter("codigo", pro)
                .getResultList();
        return avisos;
    }

    @Override
    public Aviso buscarId(int idaviso) {

        try {

            TypedQuery<Aviso> q = em.createNamedQuery("Aviso.findByIdaviso", Aviso.class);
            q.setParameter("idaviso", idaviso);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
