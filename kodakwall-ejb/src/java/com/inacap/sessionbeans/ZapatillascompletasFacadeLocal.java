/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inacap.sessionbeans;

import com.inacap.entities.Zapatillascompletas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ZALO
 */
@Local
public interface ZapatillascompletasFacadeLocal {

    void create(Zapatillascompletas zapatillascompletas);

    void edit(Zapatillascompletas zapatillascompletas);

    void remove(Zapatillascompletas zapatillascompletas);

    Zapatillascompletas find(Object id);

    List<Zapatillascompletas> findAll();

    List<Zapatillascompletas> findRange(int[] range);

    int count();
    
    List<Zapatillascompletas> zapTodo(int idusuario);
}
