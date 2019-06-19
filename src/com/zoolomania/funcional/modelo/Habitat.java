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
 * Clase que representa la tabla de Habitat
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Habitat implements Serializable, Comparable<Habitat> {

    private static long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private String nombreHabitat;
    private String clima;
    private String vegetacion;
    private String continente;
    private List<Especie> especies;
    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private short id; //Variable que permitirá ordenar objetos según su ID

    /**
     * Método contructor de la clase Habitat
     *
     * @param nombreHabitat
     * @param clima
     * @param vegetacion
     * @param continente
     * @param especies
     * @param id
     */
    public Habitat(String nombreHabitat, String clima, String vegetacion, String continente, List<Especie> especies) {
        this.nombreHabitat = nombreHabitat;
        this.clima = clima;
        this.vegetacion = vegetacion;
        this.continente = continente;
        this.especies = especies;
        this.id = UtilNumeros.getNumeroAleatorio();
    }

    /**
     * Método contrucor que se usará como objeto para pasarlo como parámetro a un objeto Especie
     * que necesite de una lista de habitats
     * @param nombreHabitat
     * @param clima
     * @param vegetacion
     * @param continente 
     */
    public Habitat(String nombreHabitat, String clima, String vegetacion, String continente) {
        this.nombreHabitat = nombreHabitat;
        this.clima = clima;
        this.vegetacion = vegetacion;
        this.continente = continente;
        this.id = UtilNumeros.getNumeroAleatorio();
    }
    
    

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
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
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.nombreHabitat);
        hash = 29 * hash + Objects.hashCode(this.clima);
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
        return "Habitat{" + "nombreHabitat=" + nombreHabitat + ", clima=" + clima + ", vegetacion=" + vegetacion + ", continente=" + continente + ", id=" + id + '}';
    }

    @Override
    public int compareTo(Habitat otroHabitat) {
        if (!bandera) {
            return this.nombreHabitat.compareToIgnoreCase(otroHabitat.nombreHabitat);
        }
        return Short.compare(this.id, otroHabitat.id);
    }

}
