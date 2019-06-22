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
 * Clase que representa al objeto Cuidador y extiende de la clase Empleado.
 *
 * @author Erick Díaz
 */
public class Cuidador extends Empleado implements Serializable, Comparable<Empleado> {

    private static final long serialVersionUID = -1L;

    private List<Especie> especies;
    private LocalDate fechaDeEspecie;

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
        System.out.println("Nueva especie agregada al cuiaddor " + this.getNombre());
    }

    public void eliminarEspecie(Especie especie) {
        especies.remove(especie);
        System.out.println("Especie removida correctamente del cuidador " + this.getNombre());
    }

}
