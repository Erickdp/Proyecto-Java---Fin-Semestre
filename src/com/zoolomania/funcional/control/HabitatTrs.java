/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Habitat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Habitat nuevoHabitat = (Habitat) registro;
        if (listaObjetos.contains(nuevoHabitat)) {
            throw new MyExcepcion("1");
        } else {
            listaObjetos.add(nuevoHabitat);
            guardarFichero();
            return "Habitat guardado correctamente";
        }

    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Habitat actualizarHabitat = (Habitat) registro;
        for (Habitat habitatAntiguo : listaObjetos) {
            if (habitatAntiguo.equals(actualizarHabitat)) {
                habitatAntiguo = actualizarHabitat;
                guardarFichero();
                return "Habitat actualizado";
            }
        }
        throw new MyExcepcion("2");
    }

    @Override
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion {
        for (Habitat buscarId : listaObjetos) {
            if (buscarId.getId() == indice) {
                return listaObjetos.get(indice);
            }
        }
        throw new MyExcepcion("3");
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        try {
            Habitat borrarHabitat = (Habitat) consultarConId(indice);
            listaObjetos.remove(borrarHabitat);
            guardarFichero();
            return "Habitat eliminado";
        } catch (NumberFormatException ex) {
            Logger.getLogger(HabitatTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new MyExcepcion("4");
    }

    @Override
    public List<?> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Habitat("Sabana", "Trópico Seco", "Sabanas herbácea", "África"));
            guardar(new Habitat("Bosque", "Subpolar & Continental", "Árboles y Matas", "América\nAsia"));
            guardar(new Habitat("Montaña", "Frío y Húmedo", "Pradera Alphina", "América"));
            guardar(new Habitat("Pantano", "Seco", "Escorrentía", "Sudamérica"));
        } catch (MyExcepcion ex) {
            ex.getMessage();
            ex.getStackTrace();
        }

    }

}
