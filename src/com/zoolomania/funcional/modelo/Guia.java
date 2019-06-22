/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que repersenta los atribuos y métodos del objeto Guia
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Guia extends Empleado implements Serializable {

    private static long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private List<Itinerario> itinerarios;

    /**
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param id
     */
    public Guia(String nombre, String direccion, String telefono, short id) {
        super(nombre, direccion, telefono, id);
        itinerarios = new ArrayList<>();
    }

    public void agregarItinerario(Itinerario itinerario) {
        itinerarios.add(itinerario);
        System.out.println("Itinerario agregado al Guia: " + this.getNombre() + " En " + itinerario.getHoraDeItinerario());
    }

    public void eliminarItinerario(Itinerario itinerario) {
        itinerarios.remove(itinerario);
        System.out.println("Itinerario eliminado del Guia " + this.getNombre());
    }

    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }

}
