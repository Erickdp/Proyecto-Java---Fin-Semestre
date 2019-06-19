/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalDate;
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
     * Método contructor de la calse Guia que extiende de Empleado
     * @param itinerarios
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechInicioTrabajar 
     */
    public Guia(List<Itinerario> itinerarios, String nombre, String direccion, String telefono, LocalDate fechInicioTrabajar) {
        super(nombre, direccion, telefono, fechInicioTrabajar);
        this.itinerarios = itinerarios;
    }

    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }

    @Override
    public String toString() {
        return "Guia{" + super.toString() + " itinerarios=" + itinerarios + '}';
    }
}
