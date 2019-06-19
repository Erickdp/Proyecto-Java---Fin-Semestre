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
 *
 * @author Erick Díaz
 */
public abstract class MemoriaBDD<T> {

    private String nombreFichero;
    private String rutaFichero = "Fichero_";
    protected List<T> listaObjetos;

    protected MemoriaBDD(String nombreFichero) {
        this.nombreFichero = nombreFichero;
        rutaFichero += this.nombreFichero + ".ddr";
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
            try {
                fichero.createNewFile();
                valoresDefecto();
                System.out.println("Fichero de " + nombreFichero + " creado correctamente");
                System.out.println("Su ruta ->" + fichero.getAbsolutePath() + "\n");
            } catch (IOException ex) {
                Logger.getLogger(MemoriaBDD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Fichero " + nombreFichero + " existente, Su ruta ->" + fichero.getAbsolutePath() + "\n");
        }
    }

    /**
     * Método que me permite guardar en el fichero Colecciones de los diferentes
     * objetos en el programa.
     */
    protected void guardarFichero() {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
            //La línea anterior permite cerrar Ficheros automaticamente (posterior a version 7 Java)
            oss.writeObject(listaObjetos);
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

    protected abstract void valoresDefecto();

}
