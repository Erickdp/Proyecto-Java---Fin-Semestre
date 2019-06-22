/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa al objeto especie
 *
 * @author Erick Díaz
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
    private LocalDateTime fechaRegistrada;
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
        fechaRegistrada = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        cuiadores = new ArrayList<>();
        habitats = new ArrayList<>();
        zonas = new ArrayList<>();
    }

    /**
     * Método que permite agregar un cuidador a la lista cuidadores
     *
     * @param nuevoCuidador
     */
    public void agregarCuidador(Cuidador nuevoCuidador) {
        cuiadores.add(nuevoCuidador);
        System.out.println("Cuidador agregado a " + this.nombreEspecie);
    }

    /**
     * Método que permite eliminar o quitar a un cuidador de la lista de
     * cuidadores de una especie.
     *
     * @param eCuidador
     */
    public void eliminarCuidador(Cuidador eCuidador) {
        cuiadores.remove(eCuidador);
        System.out.println("Cuidador eliminado de " + this.nombreEspecie);
    }

    public void agregarHabitat(Habitat habitat) {
        habitats.add(habitat);
        System.out.println("Habitat agregada a la especie");
    }

    public void elimninarHabitat(Habitat habitat) {
        habitats.remove(habitat);
        System.out.println("Habitat eliminada de especie");
    }

    public LocalDateTime getFechaRegistrada() {
        return fechaRegistrada;
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
        System.out.println("Zona agregada a la especie");
    }

    public void eliminarZona(Zona zona) {
        zonas.remove(zona);
        System.out.println("Zona eliinara de la especie");
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

    public void setFechaRegistrada(LocalDateTime fechaRegistrada) {
        this.fechaRegistrada = fechaRegistrada;
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
