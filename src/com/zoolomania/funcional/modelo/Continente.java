/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa los atributos de un Continente
 *
 * @author Erick Díaz
 */
public class Continente implements Serializable {

    private static final long serialVersionUID = -1L;

    private String nombreContienete;
    private short id;
    private List<Habitat> habitats;

    public Continente(short id, String nombreContienete) {
        this.nombreContienete = nombreContienete;
        this.id = id;
        habitats = new ArrayList<>();
    }

    public void agregarHabitat(Habitat habitat) {
        habitats.add(habitat);
    }

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
    public String toString() {
        return "Continente{" + "nombreContienete=" + nombreContienete + '}';
    }

}
