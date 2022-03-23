/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.Aviso;
import com.inacap.entities.Favorito;
import com.inacap.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ZALO
 */
@Stateless
public class FavoritoFacade extends AbstractFacade<Favorito> implements FavoritoFacadeLocal {

    @PersistenceContext(unitName = "kodakwall-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FavoritoFacade() {
        super(Favorito.class);
    }
    
    
    @Override
    public List<Favorito> buscarFavPorUsuario(int idusuario) {
        EntityManager em = getEntityManager();
        List<Favorito> favorito = em.createQuery("select * from favorito inner join usuario on favorito.idusuario=usuario.id where usuario.id=?1")
                .setParameter(1, idusuario)
                .getResultList();
        return favorito;
    }
    
    @Override
     public List<Favorito> buscarFavs(Usuario u) {
        EntityManager em = getEntityManager();
           // , @NamedQuery(name = "Fa           SELECT f FROM Favorito f WHERE f.estado = :estado")})
        List<Favorito> favorito = em.createQuery("SELECT f FROM Favorito f WHERE f.usuarioidUsuario = :codigo")
                .setParameter("codigo", u)
                .getResultList();
        return favorito;
    }
     
         @Override
    public List<Favorito> buscarFavPorIdAviso(Aviso actualAviso) {
        EntityManager em = getEntityManager();
        List<Favorito> favorito = em.createQuery("SELECT f FROM Favorito f WHERE f.avisoIdaviso = :codigo")
                .setParameter("codigo", actualAviso)
                .getResultList();
        return favorito;
    }
}
