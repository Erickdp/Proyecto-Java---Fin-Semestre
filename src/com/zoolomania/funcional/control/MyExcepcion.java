/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

/**
 * Clase que repersenta la creación de una expeción comprobada
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class MyExcepcion extends Exception {

    String error;

    public MyExcepcion() {
    }

    /**
     * Método que permite personalizar el mensaje cuando se produce una
     * excepción
     *
     * @param error - Tipo De Excepción
     */
    public MyExcepcion(String error) {
        this.error = error;
    }

    @Override
    public String getMessage() {
        int numError = Integer.parseInt(error);
        switch (numError) {
            case 1:
                return "Error al guardar Registro (El Objeto puede ya existir)";
            case 2:
                return "No se puede actualizar el Registro pues no existe";
            case 3:
                return "No se econtró el índice en el Registro";
            case 4:
                return "No se pudo eliminar el Registro";
            default:
                return "Ha existido un error en la ejecución del programa revise el código";
        }
    }

}
