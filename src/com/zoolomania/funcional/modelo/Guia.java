/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import com.zoolomania.funcional.control.util.UtilNumeros;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que repersenta los atribuos y métodos del objeto Guia
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Guia implements Serializable, Comparable<Guia> {

    private static long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    protected String nombreGuia;
    protected String direccion;
    protected String telefono;
    protected LocalDate fechInicioTrabajar;
    //Variable que permite comprar de acuerdo al nombre o id
    public static boolean bandera = false;
    // variable que permitirá ordenar por índice
    private short id;

    /**
     * Método constructor de la clase Guia
     *
     * @param nombreGuia
     * @param direccion
     * @param telefono
     * @param fechInicioTrabajar
     */
    public Guia(String nombreGuia, String direccion, String telefono, LocalDate fechInicioTrabajar) {
        this.nombreGuia = nombreGuia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechInicioTrabajar = fechInicioTrabajar;
        id = UtilNumeros.getNumeroAleatorio();
    }

    public LocalDate getFechInicioTrabajar() {
        return fechInicioTrabajar;
    }

    public void setFechInicioTrabajar(LocalDate fechInicioTrabajar) {
        this.fechInicioTrabajar = fechInicioTrabajar;
    }

    public String getNombreGuia() {
        return nombreGuia;
    }

    public void setNombreGuia(String nombreGuia) {
        this.nombreGuia = nombreGuia;
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

    public short getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.nombreGuia);
        hash = 11 * hash + Objects.hashCode(this.telefono);
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
        final Guia other = (Guia) obj;
        if (!Objects.equals(this.nombreGuia, other.nombreGuia)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Guia{" + "nombreGuia=" + nombreGuia + ", direccion=" + direccion + ", telefono=" + telefono + ", fechInicioTrabajar=" + fechInicioTrabajar + ", id=" + id + '}';
    }

  

    @Override
    public int compareTo(Guia otroGuia) {
        if (!bandera) {
            return this.nombreGuia.compareToIgnoreCase(otroGuia.nombreGuia);
        }
        return Short.compare(this.id, otroGuia.id);
    }
}
