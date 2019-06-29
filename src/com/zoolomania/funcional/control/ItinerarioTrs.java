/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.control.MemoriaBDD;
import com.zoolomania.funcional.control.MyExcepcion;
import com.zoolomania.funcional.modelo.Cuidador;
import com.zoolomania.funcional.modelo.Itinerario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa las operaciones de negio para Itinerarios
 *
 * @author Erick Díaz
 */
public class ItinerarioTrs extends MemoriaBDD<Itinerario> implements ICrud<Itinerario> {

    public ItinerarioTrs() {
        super("Itinerario");
        leerFichero();
    }

    @Override
    public String guardar(Itinerario registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Itinerario itinerarioRepetido : listaObjetos) {
                if (itinerarioRepetido.equals(registro)) {
                    bandera = true;
                    throw new MyExcepcion("1");
                }
            }
        }
        if (!bandera) {
            listaObjetos.add(registro);
            guardarFichero();
            return "Guardado Correctamente";
        } else {
            return "No se pudo guardar";
        }
    }

    @Override
    public String actulizar(Itinerario registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Itinerario itinerarioAntiguo : listaObjetos) {
                if (itinerarioAntiguo.getId() == registro.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(itinerarioAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Itinerario registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(registro);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public List<Itinerario> listar() {
        return listaObjetos;
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
    protected void valoresDefecto() {
        try {
            guardar(new Itinerario("1212", (byte) 30, (short) 1, (short) 5));
            guardar(new Itinerario("4523", (byte) 40, (short) 2, (short) 10));
            guardar(new Itinerario("3425", (byte) 15, (short) 3, (short) 3));
            guardar(new Itinerario("4356", (byte) 11, (short) 4, (short) 4));
            guardar(new Itinerario("90832", (byte) 12, (short) 5, (short) 10));
            guardar(new Itinerario("8243", (byte) 5, (short) 6, (short) 7));
            guardar(new Itinerario("94352", (byte) 4, (short) 7, (short) 5));
            guardar(new Itinerario("94300", (byte) 76, (short) 9, (short) 12));
            guardar(new Itinerario("94111", (byte) 1, (short) 12, (short) 21));
            guardar(new Itinerario("94222", (byte) 15, (short) 17, (short) 27));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ItinerarioTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
