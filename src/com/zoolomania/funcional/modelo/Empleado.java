/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 *
 * @author Erick Díaz
 */
public abstract class Empleado implements Serializable, Comparable<Empleado> {

    private static final Long serialVersionUID = -1L;

    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDateTime fechInicioTrabajar;
    //Variable que servirá como identificador
    private short id;
    //Variable que permite comprar de acuerdo al nombre o id
    public static boolean bandera = false;

    /**
     * Método constructor de la clase Empleado
     *
     * @param nombre
     * @param direccion
     * @param telefono
     * @param id
     */
    protected Empleado(String nombre, String direccion, String telefono, short id) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id = id;
        /*
        Uso de la clase LocalDateTime y Math para generar fechas aleatorias
        */
        this.fechInicioTrabajar = LocalDateTime.of(LocalDate.of(2019, (int) (1 + Math.floor(Math.random() * 11)), (int) (1 + Math.floor(Math.random() * 27)))
                , LocalTime.of((int) Math.floor(Math.random() * 23), (int) Math.floor(Math.random() * 59)));
    }

    public String getNombre() {
        return nombre;
    }

    public void setFechInicioTrabajar(LocalDateTime fechInicioTrabajar) {
        this.fechInicioTrabajar = fechInicioTrabajar;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechInicioTrabajar() {
        return fechInicioTrabajar;
    }

    public short getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " Nombre: " + this.nombre + ". Dirección: " + this.direccion + " Teléfono: "
                + this.telefono + " Fecha que inició a trabajar: " + this.fechInicioTrabajar;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.telefono);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Empleado otroEmpleado) {
        if (!bandera) {
            return this.nombre.compareToIgnoreCase(otroEmpleado.getNombre());
        } else {
            return Short.compare(this.id, otroEmpleado.id);
        }
    }
}
