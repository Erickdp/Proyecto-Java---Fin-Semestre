/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que representa al objeto itinerario
 *
 * @author Erick Díaz
 */
public class Itinerario implements Serializable, Comparable<Itinerario> {

    private static final long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private String codigo; //El código no puede ser modificado una vez creado el itinerario
    private LocalTime duracionRecorrido;
    private short longitud;
    private byte numMaxVisitantes;
//    private byte numEspeciesVisitadas;
    private List<Zona> zonas;
    private List<Guia> guias;

    /*
    Permite determinar a través de que identificador se ordenará la lista
     */
    public static boolean bandera = false;
    private short id;

    /**
     * Método constructor de la clase Itinerario
     *
     * @param codigo
     * @param numMaxVisitantes
     */
    public Itinerario(String codigo, byte numMaxVisitantes, short id, short longitud) {
        this.codigo = codigo;
        this.id = id;
        this.numMaxVisitantes = numMaxVisitantes;
        this.longitud = longitud;
        duracionRecorrido = LocalTime.of((int) Math.floor(Math.random() * 2),
                (int) Math.floor(Math.random() * 59)); //Tendrá hasta un límite de 3 horas de duración
        zonas = new ArrayList<>();
        guias = new ArrayList<>();
    }

    public void agregarZona(Zona zona) {
        zonas.add(zona);
        System.out.println("Zona agregada al Itinerario");
    }

    public void eliminarZona(Zona zona) {
        zonas.remove(zona);
        System.out.println("Zona eliinara del Itinerario");
    }

    public int especiesVisitadas(List<Zona> zonas) {
        int numeroEspecies = 0;
        for (Zona z : zonas) {
            numeroEspecies += z.getEspecies().size();
        }
        return numeroEspecies;
    }
    
    public void agregarGuia(Guia guia) {
        guias.add(guia);
        System.out.println("Guia agregado al itinerario " + this.getCodigo());
    }

    public void eliminarGuia(Guia guia) {
        guias.remove(guia);
        System.out.println("Guia eliminado del itinerario " + this.codigo);
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public byte getNumMaxVisitantes() {
        return numMaxVisitantes;
    }

    public void setNumMaxVisitantes(byte numMaxVisitantes) {
        this.numMaxVisitantes = numMaxVisitantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalTime getDuracionRecorrido() {
        return duracionRecorrido;
    }

    public void setDuracionRecorrido(LocalTime duracionRecorrido) {
        this.duracionRecorrido = duracionRecorrido;
    }

    public List<Guia> getGuias() {
        return guias;
    }

    public void setGuias(List<Guia> guias) {
        this.guias = guias;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(short longitud) {
        this.longitud = longitud;
    }

    public short getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
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
        final Itinerario other = (Itinerario) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "codigo=" + codigo + ", duracionRecorrido=" + duracionRecorrido + ", longitud=" + longitud + "KM, numMaxVisitantes=" + numMaxVisitantes + '}';
    }

    @Override
    public int compareTo(Itinerario otroItinerario) {
        if (!bandera) {
            return this.codigo.compareToIgnoreCase(otroItinerario.codigo);
        }
        return Short.compare(this.id, otroItinerario.getId());
    }

}
