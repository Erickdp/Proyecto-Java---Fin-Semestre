/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import com.zoolomania.funcional.control.util.UtilNumeros;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa al objeto Zona con sus atributos y métodos
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Zona implements Serializable, Comparable<Zona> {

    private static final long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private String nombreZona;
    private float extension;
    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private short id; //Variable que permitirá ordenar objetos según su ID

    /**
     * Método contructor de la clase Zona
     *
     * @param nombreZona
     * @param extension
     */
    public Zona(String nombreZona, float extension) {
        this.nombreZona = nombreZona;
        this.extension = extension;
        id = UtilNumeros.getNumeroAleatorio();
    }

    public float getExtension() {
        return extension;
    }

    public void setExtension(float extension) {
        this.extension = extension;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.nombreZona);
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
        final Zona other = (Zona) obj;
        if (Float.floatToIntBits(this.extension) != Float.floatToIntBits(other.extension)) {
            return false;
        }
        if (!Objects.equals(this.nombreZona, other.nombreZona)) {
            return false;
        }
        return true;
    }

    public short getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Zona{" + "nombreZona=" + nombreZona + ", extension=" + extension + '}';
    }

    @Override
    public int compareTo(Zona otraZona) {
        if (!bandera) {
            return this.nombreZona.compareTo(otraZona.nombreZona);
        }
        return Short.compare(this.id, otraZona.id);
    }

}
