/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Cuidador;
import com.zoolomania.funcional.modelo.Especie;
import com.zoolomania.funcional.modelo.Habitat;
import com.zoolomania.funcional.modelo.Zona;
import java.time.LocalDate;
import java.util.ArrayList;
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
        Especie nuevaEspecie = (Especie) registro;
        if (listaObjetos.contains(nuevaEspecie)) {
            throw new MyExcepcion("1");
        } else {
            listaObjetos.add(nuevaEspecie);
            guardarFichero();
            return "Especie guardada correctamente";
        }

    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Especie actualizarEspecie = (Especie) registro;
        for (Especie EspecieAntiguo : listaObjetos) {
            if (EspecieAntiguo.equals(actualizarEspecie)) {
                EspecieAntiguo = actualizarEspecie;
                guardarFichero();
                return "Especie actualizada";
            }
        }
        throw new MyExcepcion("2");
    }

    @Override
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion {
        for (Especie buscarId : listaObjetos) {
            if (buscarId.getId() == indice) {
                return listaObjetos.get(indice);
            }
        }
        throw new MyExcepcion("3");
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        try {
            Especie borrarEspecie = (Especie) consultarConId(indice);
            listaObjetos.remove(borrarEspecie);
            guardarFichero();
            return "Especie eliminada correctamente";
        } catch (NumberFormatException ex) {
            Logger.getLogger(EspecieTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new MyExcepcion("4");
    }

    @Override
    public List<?> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
            List<Cuidador> cuidadoresDefecto = new ArrayList<>();
            List<Habitat> habitatDefecto = new ArrayList<>();
            List<Zona> zonasDefecto = new ArrayList<>();

            cuidadoresDefecto.add(new Cuidador("Carlos", "Zona centro", "123434", LocalDate.of(2019, 02, 02)));
            cuidadoresDefecto.add(new Cuidador("Juan", "Av doce", "854743", LocalDate.of(2010, 04, 04)));
            cuidadoresDefecto.add(new Cuidador("Mario", "Zona rosa", "432123", LocalDate.of(2015, 06, 11)));

            habitatDefecto.add(new Habitat("Sabana", "Trópico Seco", "Sabanas herbácea", "África"));
            habitatDefecto.add(new Habitat("Bosque", "Subpolar & Continental", "Árboles y Matas", "América\nAsia"));
            habitatDefecto.add(new Habitat("Montaña", "Frío y Húmedo", "Pradera Alphina", "América"));
            habitatDefecto.add(new Habitat("Pantano", "Seco", "Escorrentía", "Sudamérica"));
            
            zonasDefecto.add(new Zona("Zona Norte", 2.4F));
            zonasDefecto.add(new Zona("Zona Media", 1.4F));

        try {
            guardar(new Especie("Leon", "Panthera", "Mamífero Carníror de la familia de los félidos y una "
                    + "de las cinco especies del género Panthera.", cuidadoresDefecto, habitatDefecto, zonasDefecto));
        } catch (MyExcepcion ex) {
            ex.getMessage();
            ex.getStackTrace();
        }

    }

}
