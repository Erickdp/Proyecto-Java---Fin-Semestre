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
 * Clase que representa al objeto itinerario
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Itinerario implements Serializable, Comparable<Itinerario> {

    private static long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private String codigo;
    private short duracionRecorrido;
    private float longitud;
    private byte numMaxVisitantes;
    private byte numEspeciesVisitadas;
    private List<Zona> zonas;

    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private short id; //Variable que permitirá ordenar objetos según su ID

    /**
     * Método constructor de la clase Itinerario
     * @param codigo
     * @param duracionRecorrido
     * @param longitud
     * @param numMaxVisitantes
     * @param numEspeciesVisitadas
     * @param zonas 
     */
    public Itinerario(String codigo, short duracionRecorrido, float longitud, byte numMaxVisitantes, byte numEspeciesVisitadas, List<Zona> zonas) {
        this.codigo = codigo;
        this.duracionRecorrido = duracionRecorrido;
        this.longitud = longitud;
        this.numMaxVisitantes = numMaxVisitantes;
        this.numEspeciesVisitadas = numEspeciesVisitadas;
        this.zonas = zonas;
        id = UtilNumeros.getNumeroAleatorio();
    }

    public List<Zona> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona> zonas) {
        this.zonas = zonas;
    }

    public byte getNumEspeciesVisitadas() {
        return numEspeciesVisitadas;
    }

    public void setNumEspeciesVisitadas(byte numEspeciesVisitadas) {
        this.numEspeciesVisitadas = numEspeciesVisitadas;
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public short getDuracionRecorrido() {
        return duracionRecorrido;
    }

    public void setDuracionRecorrido(short duracionRecorrido) {
        this.duracionRecorrido = duracionRecorrido;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.codigo);
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
        if (this.duracionRecorrido != other.duracionRecorrido) {
            return false;
        }
        if (Float.floatToIntBits(this.longitud) != Float.floatToIntBits(other.longitud)) {
            return false;
        }
        if (this.numMaxVisitantes != other.numMaxVisitantes) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    public short getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "codigo=" + codigo + ", duracionRecorrido=" + duracionRecorrido + ", longitud=" + longitud + ", numMaxVisitantes=" + numMaxVisitantes + '}';
    }

    @Override
    public int compareTo(Itinerario otroItinerario) {
        if (!bandera) {
            return this.codigo.compareToIgnoreCase(otroItinerario.codigo);
        }
        return Short.compare(this.id, otroItinerario.id);
    }

}
