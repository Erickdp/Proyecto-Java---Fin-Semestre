/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que repersenta los atribuos y métodos del objeto Guia
 *
 * @author Erick Díaz
 */
public class Guia extends Empleado implements Serializable {

    private static final long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private final List<Itinerario> itinerarios;

    /**
     * Método constructor de la clase Guia
     * @param nombre
     * @param direccion
     * @param telefono
     * @param id
     */
    public Guia(String nombre, String direccion, String telefono, short id) {
        super(nombre, direccion, telefono, id);
        itinerarios = new ArrayList<>();
    }

    /**
     * Método que permite agregar itinerarios a la lista y darle una hora en la cuál el Guia deberá realizar
     * el itinerario.
     * @param itinerario 
     */
    public void agregarItinerario(Itinerario itinerario) {
        itinerario.setHoraItinerario(LocalTime.of((int) (1 + (Math.floor(Math.random() * 16))), (int)  (1 + (Math.floor(Math.random() * 58)))));
        itinerarios.add(itinerario);
    }
    
    public void eliminarItinerario(Itinerario itinerario) {
        itinerarios.remove(itinerario);
    }

    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }

}
