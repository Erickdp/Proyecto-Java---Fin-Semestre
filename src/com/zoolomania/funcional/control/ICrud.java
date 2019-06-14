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
     * @param registro - Objeto a crear/guardar
     * @return Mensaje de guardado para el Usuario
     */
    public String guardar(Object registro) throws MyExcepcion;

    /**
     * Método que permite actualizar un objeto
     *
     * @param registro - Objeto a actulizarse
     * @return Mensaje de actualización de registro
     */
    public String actulizar(Object registro) throws MyExcepcion;

    /**
     *
     * @param indice - Buscará al objeto según su posición
     * @return Devolverá el objeto encontrado en caso de existir
     */
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion;

    /**
     * Método que permite eliminar un registro a través de su ID
     *
     * @param indice
     * @return Mensaje de eliminación de registro
     * @throws MyExcepcion
     */
    public String eliminar(int indice) throws MyExcepcion;

    /**
     * Método que permite listar con conjuto de objetos
     *
     * @return Lista de objetos de tipo ? almacenados
     */
    public List<?> listar();
}
