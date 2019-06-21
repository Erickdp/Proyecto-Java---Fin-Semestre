/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import java.util.List;

/**
 * Interface que representa el contraro de negocio CRUD
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public interface ICrud {

    /**
     * Método que permite Guardar/Crear un objeto
     *
     * @param registro
     * @return
     * @throws MyExcepcion
     */
    public String guardar(Object registro) throws MyExcepcion;

    /**
     * Método que permite actualizar un objeto
     *
     * @param registro
     * @return
     * @throws MyExcepcion
     */
    public String actulizar(Object registro) throws MyExcepcion;

    /**
     * Método que permitirá devolver el estado del objeto a consultar
     *
     * @param id
     * @return
     * @throws NumberFormatException
     */
    public Object buscarConId(short id) throws NumberFormatException;

    /**
     * Método que permite eliminar un registro a través de su ID
     *
     * @param registro
     * @return
     * @throws MyExcepcion
     */
    public String eliminar(Object registro) throws MyExcepcion;

    /**
     * Método que permite listar con conjuto de objetos
     *
     * @return Lista de objetos de tipo ? almacenados
     */
    public List<?> listar();
}
