/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Cuidador;
import com.zoolomania.funcional.modelo.Especie;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick Díaz
 */
public class CuidadorTrs extends MemoriaBDD<Cuidador> implements ICrud {

    public CuidadorTrs(String nombreFichero) {
        super("Cuidador");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        Cuidador nuevoCuidador = (Cuidador) registro;
        if (listaObjetos.contains(nuevoCuidador)) {
            throw new MyExcepcion("1");
        } else {
            listaObjetos.add(nuevoCuidador);
            guardarFichero();
            return "Cuidador guardado correctamente";
        }

    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Cuidador actualizarCuidador = (Cuidador) registro;
        for (Cuidador cuidadorAntiguo : listaObjetos) {
            if (cuidadorAntiguo.equals(actualizarCuidador)) {
                cuidadorAntiguo = actualizarCuidador;
                guardarFichero();
                return "Cuidador actualizado";
            }
        }
        throw new MyExcepcion("2");
    }

    @Override
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion {
        for (Cuidador buscarId : listaObjetos) {
            if (buscarId.getId() == indice) {
                return listaObjetos.get(indice);
            }
        }
        throw new MyExcepcion("3");
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        try {
            Cuidador borrarCuidador = (Cuidador) consultarConId(indice);
            listaObjetos.remove(borrarCuidador);
            guardarFichero();
            return "Eliminación correcta";
        } catch (NumberFormatException ex) {
            Logger.getLogger(CuidadorTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new MyExcepcion("4");
    }

    @Override
    public List<?> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
        List<Especie> especies = new ArrayList<>();

        especies.add(new Especie("Leon", "Panthera",
                "Mamífero Carníror de la familia de los félidos y una de las cinco especies del género Panthera."));
        especies.add(new Especie("Elefante", "Elephantidee", "Son una familia de mamíderos placentarios del orden "
                + "Proboscidea. Existen hoy en día tres especies y diversas subespecies"));
        especies.add(new Especie("Chimpancé", "Pan", "Es un género de primates homínidos que comprende las "
                + "especies Pan troglodytes y Pan paniscus. Su promedio de vida es de 50 años."));
        especies.add(new Especie("Cebra", "Equus grevji", "Las cebras son altamente sociables. Aun así, su estructura "
                + "social depende de la especie. Las cebras de comtaña y cebras comunes viven en grupos, conocidos"
                + " como \"harenes"));

        //Guardar Usuarios con su constructor que se puede ingresar Listas
        try {
            guardar(new Cuidador(especies, "Alejadnro", "Av Solanda", "123124", LocalDate.now()));
        } catch (MyExcepcion ex) {
            Logger.getLogger(CuidadorTrs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
