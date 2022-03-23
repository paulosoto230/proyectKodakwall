/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.Aviso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ZALO
 */
@Local
public interface AvisoFacadeLocal {

    void create(Aviso aviso);

    void edit(Aviso aviso);

    void remove(Aviso aviso);

    Aviso find(Object id);

    List<Aviso> findAll();

    List<Aviso> findRange(int[] range);

    int count();

    Aviso Encontrar(String modelo);

    Aviso buscarId(int idaviso);

    List<Aviso> findMarca(String marca);

    List<Aviso> buscarLike(String like);

}
