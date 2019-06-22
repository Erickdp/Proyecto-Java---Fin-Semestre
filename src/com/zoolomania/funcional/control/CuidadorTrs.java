/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Cuidador;
import com.zoolomania.funcional.modelo.Especie;
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
        boolean bandera = false;
        if (buscarConId(guardarCuidador.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Cuidador cuidadorRepetido : listaObjetos) {
                if (cuidadorRepetido.equals(guardarCuidador)) {
                    bandera = true;
                    throw new MyExcepcion("1");
                }
            }
        }
        if (!bandera) {
            listaObjetos.add(guardarCuidador);
            guardarFichero();
            return "Guardado Correctamente";
        } else {
            return "No se pudo guardar";
        }
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Cuidador actualizarCuidador = (Cuidador) registro;
        if (buscarConId(actualizarCuidador.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Cuidador cuidadorAntiguo : listaObjetos) {
                if (cuidadorAntiguo.getId() == actualizarCuidador.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(cuidadorAntiguo), actualizarCuidador);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Cuidador eliminarCuidador = (Cuidador) registro;
        if (buscarConId(eliminarCuidador.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(eliminarCuidador);
            guardarFichero();
            return "Eliminación Correcta";
        }
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
        /*List<Cuidador> cuidadors = new ArrayList<>();

        cuidadors.add(new Cuidador("Leon", "Panthera",
                "Mamífero Carníror de la familia de los félidos y una de las cinco cuidadors del género Panthera."));
        cuidadors.add(new Cuidador("Elefante", "Elephantidee", "Son una familia de mamíderos placentarios del orden "
                + "Proboscidea. Existen hoy en día tres cuidadors y diversas subcuidadors"));
        cuidadors.add(new Cuidador("Chimpancé", "Pan", "Es un género de primates homínidos que comprende las "
                + "cuidadors Pan troglodytes y Pan paniscus. Su promedio de vida es de 50 años."));
        cuidadors.add(new Cuidador("Cebra", "Equus grevji", "Las cebras son altamente sociables. Aun así, su estructura "
                + "social depende de la cuidador. Las cebras de comtaña y cebras comunes viven en grupos, conocidos"
                + " como \"harenes"));*/
//        cuidadorDefecto.cuidarNuevaCuidador(new Cuidador("Perro", "Perrus", "Pelusa", (short) 1));
        try {
            guardar(new Cuidador("Carlos", "Floresta", "331234", (short)1));
        } catch (MyExcepcion ex) {
            Logger.getLogger(CuidadorTrs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
