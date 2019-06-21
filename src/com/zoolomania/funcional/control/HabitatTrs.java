/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Habitat;
import java.util.List;

/**
 * Clase que representa las operaciones de negocio para Habitats
 *
 * @author Santiago Sisalem - Erick Díaz (Unplugged)
 */
public class HabitatTrs extends MemoriaBDD<Habitat> implements ICrud {

    public HabitatTrs() {
        super("Habitat");
        leerFichero();
    }

     @Override
    public String guardar(Object registro) throws MyExcepcion {
        Habitat guardarHabitat = (Habitat) registro;
        if (buscarConId(guardarHabitat.getId()) != null) {
            throw new MyExcepcion("3");
        }
        for (Habitat habitatRepetido : listaObjetos) {
            if (habitatRepetido.equals(guardarHabitat)) {
                throw new MyExcepcion("1");
            }
        }
        listaObjetos.add(guardarHabitat);
        guardarFichero();
        return "Guardado Correctamente";
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Habitat actualizarHabitat = (Habitat) registro;
        if (buscarConId(actualizarHabitat.getId()) != null) {
            throw new MyExcepcion("2");
        }
        for (Habitat habitatAntiguo : listaObjetos) {
            if (habitatAntiguo.getId() == actualizarHabitat.getId()) {
                habitatAntiguo = actualizarHabitat;
                guardarFichero();
                return "Actualizado Correctamente";
            }
        }
        return null;
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Habitat eliminarHabitat = (Habitat) registro;
        if (buscarConId(eliminarHabitat.getId()) == null) {
            throw new MyExcepcion("4");
        }
        listaObjetos.remove(eliminarHabitat);
        guardarFichero();
        return "Eliminación Correcta";
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Habitat habitat : listaObjetos) {
            if (habitat.getId() == id) {
                return habitat;
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
        try {
            /*
            Esto no sirve crear con listas
            */
            guardar(new Habitat("Sabana", "Trópico Seco", "Sabanas herbácea", "África", (short) 1));
            guardar(new Habitat("Bosque", "Subpolar & Continental", "Árboles y Matas", "América\nAsia", (short) 2));
            guardar(new Habitat("Montaña", "Frío y Húmedo", "Pradera Alphina", "América", (short) 3));
            guardar(new Habitat("Pantano", "Seco", "Escorrentía", "Sudamérica", (short) 4));
        } catch (MyExcepcion ex) {
            ex.getMessage();
            ex.getStackTrace();
        }

    }

}
