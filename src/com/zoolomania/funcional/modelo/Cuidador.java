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
 * Clase que representa al objeto Cuidador y extiende de la clase Empleado.
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Cuidador extends Empleado implements Serializable, Comparable<Empleado> {

    private static final long serialVersionUID = -1L;

    private List<Especie> especies;
    private LocalDate fechaDeEspecie;

    /**
     * Método contructor de la clase Cuidador que llamará al contructor de la
     * clase Empleado (Ancestro)
     *
     * @param especies
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechInicioTrabajar
     */
    public Cuidador(List<Especie> especies, String nombre, String direccion, String telefono, LocalDate fechInicioTrabajar) {
        super(nombre, direccion, telefono, fechInicioTrabajar);
        this.especies = especies;
    }

    /**
     * Método contructor que se asignarán a las especies
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param fechInicioTrabajar
     */
    public Cuidador(String nombre, String direccion, String telefono, LocalDate fechInicioTrabajar) {
        super(nombre, direccion, telefono, fechInicioTrabajar);
        setFechaDeEspecie(LocalDate.now());
    }

    public LocalDate getFechaDeEspecie() {
        return fechaDeEspecie;
    }

    public void setFechaDeEspecie(LocalDate fechaDeEspecie) {
        this.fechaDeEspecie = fechaDeEspecie;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }

    @Override
    public String toString() {
        return "Cuidador{" + super.toString() + " especies=" + especies + '}';
    }

}
