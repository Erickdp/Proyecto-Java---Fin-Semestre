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
        Itinerario guardarItinerario = (Itinerario) registro;
        if (buscarConId(guardarItinerario.getId()) != null) {
            throw new MyExcepcion("3");
        }
        for (Itinerario itinerarioRepetido : listaObjetos) {
            if (itinerarioRepetido.equals(guardarItinerario)) {
                throw new MyExcepcion("1");
            }
        }
        listaObjetos.add(guardarItinerario);
        guardarFichero();
        return "Guardado Correctamente";
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Itinerario actualizarItinerario = (Itinerario) registro;
        if (buscarConId(actualizarItinerario.getId()) != null) {
            throw new MyExcepcion("2");
        }
        for (Itinerario itinerarioAntiguo : listaObjetos) {
            if (itinerarioAntiguo.getId() == actualizarItinerario.getId()) {
                itinerarioAntiguo = actualizarItinerario;
                guardarFichero();
                return "Actualizado Correctamente";
            }
        }
        return null;
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Itinerario eliminarItinerario = (Itinerario) registro;
        if (buscarConId(eliminarItinerario.getId()) == null) {
            throw new MyExcepcion("4");
        }
        listaObjetos.remove(eliminarItinerario);
        guardarFichero();
        return "Eliminación Correcta";
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Itinerario itinerario : listaObjetos) {
            if (itinerario.getId() == id) {
                return itinerario;
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
            guardar(new Itinerario("1212", (byte) 30, (short) 1));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ItinerarioTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
