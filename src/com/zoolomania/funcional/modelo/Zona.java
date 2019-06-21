/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
     * Método constructor de la clase Zona
     * @param nombreZona
     * @param extension
     * @param id 
     */
    public Zona(String nombreZona, float extension, short id) {
        this.nombreZona = nombreZona;
        this.extension = extension;
        this.id = id;
        especies = new ArrayList<>();
        itinerarios = new ArrayList<>();
    }
    

    public void agregarEspecie(Especie especie) {
        especies.add(especie);
        System.out.println("Especie agregada al habitat " + this.nombreZona);
    }
    
    public void eliminarEspecie(Especie especie) {
        especies.remove(especie);
        System.out.println("Especie eliminada del habitat " + this.nombreZona);
    }
    
    public void agregarItinerario(Itinerario itinerario) {
        itinerarios.add(itinerario);
        System.out.println("Itinerario agregado a la zona " + this.nombreZona);
    }
    
    public void eliminarItinerario(Itinerario itinerario) {
        itinerarios.remove(itinerario);
        System.out.println("Itinerario eliminado de la zona " + this.nombreZona);
    }
    
    public List<Especie> getEspecies() {
        return especies;
    }

    public List<Itinerario> getItinerarios() {
        return itinerarios;
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.nombreZona);
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
        return "Zona{" + "nombreZona=" + nombreZona + ", extension=" + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Zona otraZona) {
        if (!bandera) {
            return this.nombreZona.compareTo(otraZona.nombreZona);
        }
        return Short.compare(this.id, otraZona.id);
    }

}
