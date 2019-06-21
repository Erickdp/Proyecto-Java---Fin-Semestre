/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Cuidador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick Díaz
 */
public class CuidadorTrs extends MemoriaBDD<Cuidador> implements ICrud {

    public CuidadorTrs() {
        super("Cuidador");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        Cuidador guardarCuidador = (Cuidador) registro;
        if (buscarConId(guardarCuidador.getId()) != null) {
            throw new MyExcepcion("3");
        }
        for (Cuidador cuidadorRepetido : listaObjetos) {
            if (cuidadorRepetido.equals(guardarCuidador)) {
                throw new MyExcepcion("1");
            }
        }
        listaObjetos.add(guardarCuidador);
        guardarFichero();
        return "Guardado Correctamente";
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Cuidador actualizarCuidador = (Cuidador) registro;
        if (buscarConId(actualizarCuidador.getId()) == null) {
            throw new MyExcepcion("2");
        }
        for (Cuidador cuidadorAntiguo : listaObjetos) {
            if (cuidadorAntiguo.getId() == actualizarCuidador.getId()) {
                listaObjetos.set(listaObjetos.indexOf(cuidadorAntiguo), actualizarCuidador);
                guardarFichero();
                return "Actualizado Correctamente";
            }
        }
        return null;
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Cuidador eliminarCuidador = (Cuidador) registro;
        if (buscarConId(eliminarCuidador.getId()) == null) {
            throw new MyExcepcion("4");
        }
        listaObjetos.remove(eliminarCuidador);
        guardarFichero();
        return "Eliminación Correcta";
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Cuidador cuidador : listaObjetos) {
            if (cuidador.getId() == id) {
                return cuidador;
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
        /*List<Especie> especies = new ArrayList<>();

        especies.add(new Especie("Leon", "Panthera",
                "Mamífero Carníror de la familia de los félidos y una de las cinco especies del género Panthera."));
        especies.add(new Especie("Elefante", "Elephantidee", "Son una familia de mamíderos placentarios del orden "
                + "Proboscidea. Existen hoy en día tres especies y diversas subespecies"));
        especies.add(new Especie("Chimpancé", "Pan", "Es un género de primates homínidos que comprende las "
                + "especies Pan troglodytes y Pan paniscus. Su promedio de vida es de 50 años."));
        especies.add(new Especie("Cebra", "Equus grevji", "Las cebras son altamente sociables. Aun así, su estructura "
                + "social depende de la especie. Las cebras de comtaña y cebras comunes viven en grupos, conocidos"
                + " como \"harenes"));*/
//        cuidadorDefecto.cuidarNuevaEspecie(new Especie("Perro", "Perrus", "Pelusa", (short) 1));
        try {
            guardar(new Cuidador("Carlos", "Floresta", "331234", (short)1));
        } catch (MyExcepcion ex) {
            Logger.getLogger(CuidadorTrs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
