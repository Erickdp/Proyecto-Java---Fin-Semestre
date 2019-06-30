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
 * Clase que representa al objeto Cuidador que extiende de la clase Empleado.
 *
 * @author Erick Díaz
 */
public class Cuidador extends Empleado implements Serializable, Comparable<Empleado> {

    private static final long serialVersionUID = -1L;

    private List<Especie> especies;

    /**
     * Método constructor de la clase Cuidador
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param id
     */
    public Cuidador(String nombre, String direccion, String telefono, short id) {
        super(nombre, direccion, telefono, id);
        especies = new ArrayList<>();
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    /**
     * Método que permitirá cuidar nuevas especies
     *
     * @param nuevaEspecie
     */
    public void cuidarNuevaEspecie(Especie nuevaEspecie) {
        especies.add(nuevaEspecie);
    }

    /**
     * Método que elimina de la lista del cuidador la especie pasadada como
     * argumento
     *
     * @param especie
     */
    public void eliminarEspecie(Especie especie) {
        especies.remove(especie);
    }
}
