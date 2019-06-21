/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa al objeto especie
 *
 * @author DELL
 */
public class Especie implements Serializable, Comparable<Especie> {

    private static final long serialVersionUID = -1L;

    private String nombreEspecie;
    private String nombreCientifico;
    private String descripcion;
    private List<Cuidador> cuiadores;
    private List<Habitat> habitats;
    private List<Zona> zonas;
    //Variable que permite agregar la fecha en la que la especie tiene asignado un cuidador
    private LocalDate fechaRegistrada;
    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private short marca; //La marca de un objeto creado no puede ser actualizado, también sirve para poder ordenar segun la marca

    /**
     * Método constructor de la clase Especie
     *
     * @param nombreEspecie
     * @param nombreCientifico
     * @param descripcion
     * @param marca
     */
    public Especie(String nombreEspecie, String nombreCientifico, String descripcion, short marca) {
        this.nombreEspecie = nombreEspecie;
        this.nombreCientifico = nombreCientifico;
        this.descripcion = descripcion;
        this.marca = marca;
        fechaRegistrada = LocalDate.now();
        cuiadores = new ArrayList<>();
    }

    public void agregarCuidador(Cuidador nuevoCuidador) {
        cuiadores.add(nuevoCuidador);
        System.out.println("Cuidador agregado");
    }
    
    public void eliminarCuidador(Cuidador eCuidador) {
        cuiadores.remove(eCuidador);
        System.out.println("Eliminación correcta");
    }
    public List<Cuidador> getCuiadores() {
        return cuiadores;
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public short getMarca() {
        return marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    /*Estos métodos para comparar se los implementa solamente con la marca pues pueden existir
    varias especies con el mismo nombre, descripción y nombreCientífico pero no con la misma marca
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.marca;
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
        final Especie other = (Especie) obj;
        if (this.marca != other.marca) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Especie otraEspecie) {
        if (!bandera) {
            return this.nombreEspecie.compareToIgnoreCase(otraEspecie.nombreEspecie);
        } else {
            return Short.compare(this.marca, otraEspecie.getMarca());
        }
    }

    @Override
    public String toString() {
        return "Marca N°" + this.marca + " Especie: " + this.nombreEspecie + ". Nombre Científico: " + this.nombreCientifico
                + ". Descripción: \n" + this.descripcion;
    }
    
}
