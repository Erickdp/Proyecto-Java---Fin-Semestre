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
 * Clase que representa la tabla de Habitat
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Habitat implements Serializable, Comparable<Habitat> {

    private static final long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private String nombreHabitat;
    private String clima;
    private String vegetacion;
    private List<Continente> continentes;
    private List<Especie> especies;
    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private final short id; //Variable que permitirá ordenar objetos según su ID

    /**
     * Método constructor de la clase Habitat
     *
     * @param nombreHabitat
     * @param clima
     * @param vegetacion
     * @param id
     */
    public Habitat(String nombreHabitat, String clima, String vegetacion, short id) {
        this.nombreHabitat = nombreHabitat;
        this.clima = clima;
        this.vegetacion = vegetacion;
        this.continentes = new ArrayList<>();
        this.id = id;
        especies = new ArrayList<>();
    }

    public void agregarEspecie(Especie especie) {
        especies.add(especie);
        System.out.println("Especie agregada al habitat " + this.nombreHabitat);
    }

    public void eliminarEspecie(Especie especie) {
        especies.remove(especie);
        System.out.println("Especie eliminada del habitat " + this.nombreHabitat);
    }

    public void agregarContinente(Continente continente) {
        continentes.add(continente);
    }

    public void eliminarContinente(Continente continente) {
        continentes.remove(continente);
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public List<Continente> getContinentes() {
        return continentes;
    }

    public String getNombreHabitat() {
        return nombreHabitat;
    }

    public void setNombreHabitat(String nombreHabitat) {
        this.nombreHabitat = nombreHabitat;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getVegetacion() {
        return vegetacion;
    }

    public void setVegetacion(String vegetacion) {
        this.vegetacion = vegetacion;
    }

    public short getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombreHabitat);
        hash = 37 * hash + Objects.hashCode(this.clima);
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
        final Habitat other = (Habitat) obj;
        if (!Objects.equals(this.nombreHabitat, other.nombreHabitat)) {
            return false;
        }
        if (!Objects.equals(this.clima, other.clima)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Habitat{" + "nombreHabitat=" + nombreHabitat + ", clima=" + clima + ", vegetacion=" + vegetacion + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Habitat otroHabitat) {
        if (!bandera) {
            return this.nombreHabitat.compareToIgnoreCase(otroHabitat.nombreHabitat);
        }
        return Short.compare(this.id, otroHabitat.id);
    }

}
