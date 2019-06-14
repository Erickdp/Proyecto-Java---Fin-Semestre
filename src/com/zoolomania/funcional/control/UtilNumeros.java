/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control.util;

/**
 * Clase que permitirá generar números aleatorios
 * para algunos campos como por ejemplo ordenar
 * por ID
 * @author Erick Díaz
 */
public class UtilNumeros {
    
    private short id;
    
    public static short getNumeroAleatorio() {
        return (short) Math.floor(Math.random() * 200);
    }
    
    public static short getNumerosAleatorios() {
        return (short) Math.floor(Math.random() * 3200);
    }
}
