/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import com.zoolomania.funcional.control.UtilNumeros;
import java.io.Serializable;
import java.util.List;
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
    private List<Especie> especies;
    private List<Itinerario> itinerarios;
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
     * @param especies
     * @param itinerarios
     */
    public Zona(String nombreZona, float extension, List<Especie> especies, List<Itinerario> itinerarios) {
        this.nombreZona = nombreZona;
        this.extension = extension;
        this.especies = especies;
        this.itinerarios = itinerarios;
        id = UtilNumeros.getNumeroAleatorio();
    }

    /**
     * Método constructor que permitirá crear especies
     * @param nombreZona
     * @param extension 
     */
    public Zona(String nombreZona, float extension) {
        this.nombreZona = nombreZona;
        this.extension = extension;
        id = UtilNumeros.getNumeroAleatorio();
    }

    public List<Itinerario> getItinerarios() {
        return itinerarios;
    }

    public void setItinerarios(List<Itinerario> itinerarios) {
        this.itinerarios = itinerarios;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
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
        return "Zona{" + "nombreZona=" + nombreZona + ", extension=" + extension + ", especies=" + especies + ", itinerarios=" + itinerarios + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Zona otraZona) {
        if (!bandera) {
            return this.nombreZona.compareTo(otraZona.nombreZona);
        }
        return Short.compare(this.id, otraZona.id);
    }

}
