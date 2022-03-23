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
import javax.ejb.Local;

/**
 *
 * @author ZALO
 */
@Local
public interface FavoritoFacadeLocal {

    void create(Favorito favorito);

    void edit(Favorito favorito);

    void remove(Favorito favorito);

    Favorito find(Object id);

    List<Favorito> findAll();

    List<Favorito> findRange(int[] range);

    List<Favorito> buscarFavs(Usuario u);
    
  List<Favorito> buscarFavPorIdAviso(Aviso actualAviso);

   List<Favorito> buscarFavPorUsuario(int idusuario);
    int count();
    
}
