/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.TipoDeUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ZALO
 */
@Local
public interface TipoDeUsuarioFacadeLocal {

    void create(TipoDeUsuario tipoDeUsuario);

    void edit(TipoDeUsuario tipoDeUsuario);

    void remove(TipoDeUsuario tipoDeUsuario);

    TipoDeUsuario find(Object id);

    List<TipoDeUsuario> findAll();

    List<TipoDeUsuario> findRange(int[] range);

    int count();
    
}
