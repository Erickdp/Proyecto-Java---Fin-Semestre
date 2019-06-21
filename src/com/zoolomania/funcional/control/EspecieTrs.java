/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Especie;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa las operaciones de negocio para Especies
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class EspecieTrs extends MemoriaBDD<Especie> implements ICrud {

    public EspecieTrs() {
        super("Especie");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        Especie guardarEspecie = (Especie) registro;
        if (buscarConId(guardarEspecie.getMarca()) != null) {
            throw new MyExcepcion("3");
        }
        for (Especie especieRepetido : listaObjetos) {
            if (especieRepetido.equals(guardarEspecie)) {
                throw new MyExcepcion("1");
            }
        }
        listaObjetos.add(guardarEspecie);
        guardarFichero();
        return "Guardado Correctamente";
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Especie actualizarEspecie = (Especie) registro;
        if (buscarConId(actualizarEspecie.getMarca()) == null) {
            throw new MyExcepcion("2");
        }
        for (Especie especieAntiguo : listaObjetos) {
            if (especieAntiguo.getMarca() == actualizarEspecie.getMarca()) {
                listaObjetos.set(listaObjetos.indexOf(especieAntiguo), actualizarEspecie);
                guardarFichero();
                return "Actualizado Correctamente";
            }
        }
        return null;
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Especie eliminarEspecie = (Especie) registro;
        if (buscarConId(eliminarEspecie.getMarca()) == null) {
            throw new MyExcepcion("4");
        }
        listaObjetos.remove(eliminarEspecie);
        guardarFichero();
        return "Eliminación Correcta";
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Especie especie : listaObjetos) {
            if (especie.getMarca() == id) {
                return especie;
            }
        }
        return null;
    }

    @Override
    public List<?> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {

            /*habitatDefecto.add(new Habitat("Sabana", "Trópico Seco", "Sabanas herbácea", "África"));
            habitatDefecto.add(new Habitat("Bosque", "Subpolar & Continental", "Árboles y Matas", "América\nAsia"));
            habitatDefecto.add(new Habitat("Montaña", "Frío y Húmedo", "Pradera Alphina", "América"));
            habitatDefecto.add(new Habitat("Pantano", "Seco", "Escorrentía", "Sudamérica"));*/
        try {
            guardar(new Especie("Leon", "Panthera", "Mamífero Carníror de la familia de los félidos y una "
                    + "de las cinco especies del género Panthera.", (short) 1));
        } catch (MyExcepcion ex) {
            Logger.getLogger(EspecieTrs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
