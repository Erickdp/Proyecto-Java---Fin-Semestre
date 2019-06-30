/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa la base de datos en memoria
 *
 * @author Erick Díaz
 */
public abstract class MemoriaBDD<T> {

    private String rutaFichero = "Fichero_";
    protected List<T> listaObjetos;

    protected MemoriaBDD(String nombreFichero) {
        rutaFichero += nombreFichero + ".ddr";
        listaObjetos = new ArrayList<>();
        crearFichero();
    }

    /**
     * Método que crea el fichero si esque este aún no existe, además de darle
     * un valor por defecto.
     *
     */
    private void crearFichero() {
        File fichero = new File(rutaFichero);
        if (!fichero.exists()) {
            System.out.println("MemoriaBdd V1.0 - Erick Díaz - Santiago Sisalema - Diego Gualoto - U.C.E");
            try {
                fichero.createNewFile();
                valoresDefecto();
            } catch (IOException ex) {
                Logger.getLogger(MemoriaBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Método que me permite guardar en el fichero Colecciones de los diferentes
     * objetos en el programa.
     */
    protected void guardarFichero() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
            //La línea anterior permite cerrar Ficheros automaticamente (posterior a version 7 Java)
            oos.writeObject(listaObjetos); // No se necesita sobrescribir la cabezera pues entra toda la lista completa cada vez que se escribe
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MemoriaBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MemoriaBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que me permite extraer la coleción de objetos que se encuentra en
     * un fichero.
     */
    protected void leerFichero() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero))) {
            listaObjetos = (List<T>) ois.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MemoriaBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MemoriaBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método que permite, si no existen ficheros creados, agregar objetos
     * evitar un funcionamiento desde 0.
     */
    protected abstract void valoresDefecto();

}
