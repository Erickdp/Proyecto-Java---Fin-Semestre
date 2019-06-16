/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Itinerario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa las operaciones de negio para Itinerarios
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class ItinerarioTrs extends MemoriaBDD<Itinerario> implements ICrud {

    public ItinerarioTrs() {
        super("Itinerario");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        Itinerario nuevoItinerario = (Itinerario) registro;
        if (listaObjetos.contains(nuevoItinerario)) {
            throw new MyExcepcion("1");
        } else {
            listaObjetos.add(nuevoItinerario);
            guardarFichero();
            return "Itinerario guardado correctamente";
        }

    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Itinerario actualizarItinerario = (Itinerario) registro;
        for (Itinerario itinerarioAntiguo : listaObjetos) {
            if (itinerarioAntiguo.equals(actualizarItinerario)) {
                itinerarioAntiguo = actualizarItinerario;
                guardarFichero();
                return "Itinerario actualizado";
            }
        }
        throw new MyExcepcion("2");
    }

    @Override
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion {
        for (Itinerario buscarId : listaObjetos) {
            if (buscarId.getId() == indice) {
                return listaObjetos.get(indice);
            }
        }
        throw new MyExcepcion("3");
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        try {
            Itinerario borrarItinerario = (Itinerario) consultarConId(indice);
            listaObjetos.remove(borrarItinerario);
            guardarFichero();
            return "Eliminación correcta";
        } catch (NumberFormatException ex) {
            Logger.getLogger(ItinerarioTrs.class.getName()).log(Level.SEVERE, null, ex);
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
            guardar(new Itinerario("1212", (short) 90, 2.10F, (byte) 30));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ItinerarioTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
