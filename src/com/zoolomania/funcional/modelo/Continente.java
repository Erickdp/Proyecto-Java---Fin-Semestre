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
 * Clase que representa los atributos de un Continente. Se omite la
 * implementación de la interfaz Comparable para el uso de lambdas en
 * frmContinente
 *
 * @author Erick Díaz
 */
public class Continente implements Serializable {

    private static final long serialVersionUID = -1L;

    private String nombreContienete;

    private short id; //Atributo que será usado como identificador
    private List<Habitat> habitats;

    /**
     * Método constructor de la clase Continente
     *
     * @param id
     * @param nombreContienete
     */
    public Continente(short id, String nombreContienete) {
        this.nombreContienete = nombreContienete;
        this.id = id;
        habitats = new ArrayList<>();
    }

    /**
     * Método que permite agregar Habitats al objeto Continente
     *
     * @param habitat
     */
    public void agregarHabitat(Habitat habitat) {
        habitats.add(habitat);
    }

    /**
     * Método que permite eliminar de la lista Habitats
     *
     * @param habitat
     */
    public void eliminarHabitat(Habitat habitat) {
        habitats.remove(habitat);
    }

    public String getNombreContienete() {
        return nombreContienete;
    }

    public void setNombreContienete(String nombreContienete) {
        this.nombreContienete = nombreContienete;
    }

    public short getId() {
        return id;
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.nombreContienete);
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
        final Continente other = (Continente) obj;
        if (!Objects.equals(this.nombreContienete, other.nombreContienete)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Continente{" + "nombreContienete=" + nombreContienete + '}';
    }

}
