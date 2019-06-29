/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.control.MyExcepcion;
import java.util.List;

/**
 * Interface que representa el contraro de negocio CRUD
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public interface ICrud<T> {

    /**
     * Método que permite Guardar/Crear un objeto de tipo T
     * @param registro
     * @return
     * @throws MyExcepcion 
     */
    public String guardar(T registro) throws MyExcepcion;

    /**
     * Método que permite actualizar un objeto
     *
     * @param registro
     * @return
     * @throws MyExcepcion
     */
    public String actulizar(T registro) throws MyExcepcion;

    /**
     * Método que permitirá devolver el estado del objeto a consultar
     * @param id
     * @return
     * @throws NumberFormatException 
     */
    public Object buscarConId(short id) throws NumberFormatException;

    /**
     * Método que permite eliminar un registro a través de su ID
     * @param registro
     * @return
     * @throws MyExcepcion 
     */
    public String eliminar(T registro) throws MyExcepcion;

    /**
     *Método que permite listar con conjuto de objetos
     * @return 
     */
    public List<T> listar();
}
