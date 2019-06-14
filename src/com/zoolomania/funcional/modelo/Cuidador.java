/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa al objeti Cuidardo y extiende de la clase Guia.
 * @author Santiago Sisalem - Erick Díaz
 */
public class Cuidador extends Guia implements Serializable, Comparable<Guia>{
    
    /**
     * Método contructor de la clase Cuidador que llamará al contructor de la clase Guia (Ancestro)
     * @param nombreGuia
     * @param direccion
     * @param telefono
     * @param fechInicioTrabajar 
     */
    public Cuidador(String nombreGuia, String direccion, String telefono, LocalDate fechInicioTrabajar) {
        super(nombreGuia, direccion, telefono, fechInicioTrabajar);
    }

    @Override
    public String toString() {
        return sb.append("Nombre del cuidador ").append(super.getNombreGuia()).append(". Direccion [").append(super.getDireccion())
                .append("]").append(" Número de teléfono: ").append(super.getTelefono()).append(" Con fecha de inicio de trabajo del "
                        + "Zoo").append(super.getFechInicioTrabajar()).toString();
    }

}
