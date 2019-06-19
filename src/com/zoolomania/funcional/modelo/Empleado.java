/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import com.zoolomania.funcional.control.UtilNumeros;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Erick Díaz
 */
public abstract class Empleado implements Serializable, Comparable<Empleado> {

    private static final Long serialVersionUID = -1L;

    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected LocalDate fechInicioTrabajar;
    //Variable que permite comprar de acuerdo al nombre o id
    public static boolean bandera = false;
    // variable que permitirá ordenar por índice
    private short id;

    public Empleado(String nombre, String direccion, String telefono, LocalDate fechInicioTrabajar) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechInicioTrabajar = fechInicioTrabajar;
        id = UtilNumeros.getNumeroAleatorio();
    }

    public short getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
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

    public LocalDate getFechInicioTrabajar() {
        return fechInicioTrabajar;
    }

    public void setFechInicioTrabajar(LocalDate fechInicioTrabajar) {
        this.fechInicioTrabajar = fechInicioTrabajar;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", fechInicioTrabajar=" + fechInicioTrabajar + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.telefono);
        hash = 41 * hash + this.id;
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
        if (this.id != other.id) {
            return false;
        }
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
            return Short.compare(id, otroEmpleado.id);
        }
    }
}
