/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Guia;
import java.util.List;

/**
 * Clase que representa las operaciones de negocio para los Guiaes
 *
 * @author Erick Díaz (Unplugged)
 */
public class GuiaTrs extends MemoriaBDD<Guia> implements ICrud<Guia> {

    public GuiaTrs() {
        super("Guia");
        leerFichero();
    }

    @Override
    public String guardar(Guia registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Guia guiaRepetido : listaObjetos) {
                if (guiaRepetido.equals(registro)) {
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
    public String actulizar(Guia registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Guia guiaAntiguo : listaObjetos) {
                if (guiaAntiguo.getId() == registro.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(guiaAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Guia registro) throws MyExcepcion {
        Guia eliminarGuia = (Guia) registro;
        if (buscarConId(eliminarGuia.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(eliminarGuia);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public List<Guia> listar() {
        return listaObjetos;
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Guia guia : listaObjetos) {
            if (guia.getId() == id) {
                return guia;
            }
        }
        return null;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Guia("Marcelo", "Patria", "42321", (short) 1));
            guardar(new Guia("Marco", "América", "42134", (short) 2));
            guardar(new Guia("Octavio", "Solanda", "51233", (short) 3));
            guardar(new Guia("Omar", "Beaterio", "32412", (short) 4));
            guardar(new Guia("Julia", "Plazoleta", "92387", (short) 5));
            guardar(new Guia("Alvaro", "Las Casas", "90328", (short) 6));
            guardar(new Guia("Martín", "Rio Coca", "72129", (short) 7));
        } catch (MyExcepcion ex) {
            ex.getMessage();
            ex.getStackTrace();
        }
    }
}
