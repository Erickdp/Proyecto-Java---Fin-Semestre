/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Guia;
import java.time.LocalDate;
import java.util.List;

/**
 * Clase que representa las operaciones de negocio para los Guiaes
 *
 * @author Erick Díaz (Unplugged)
 */
public class GuiaTrs extends MemoriaBDD<Guia> implements ICrud {

    public GuiaTrs() {
        super("Guia");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        Guia guardarGuia = (Guia) registro;
        if (buscarConId(guardarGuia.getId()) != null) {
            throw new MyExcepcion("3");
        }
        for (Guia guiaRepetido : listaObjetos) {
            if (guiaRepetido.equals(guardarGuia)) {
                throw new MyExcepcion("1");
            }
        }
        listaObjetos.add(guardarGuia);
        guardarFichero();
        return "Guardado Correctamente";
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Guia actualizarGuia = (Guia) registro;
        if (buscarConId(actualizarGuia.getId()) != null) {
            throw new MyExcepcion("2");
        }
        for (Guia guiaAntiguo : listaObjetos) {
            if (guiaAntiguo.getId() == actualizarGuia.getId()) {
                guiaAntiguo = actualizarGuia;
                guardarFichero();
                return "Actualizado Correctamente";
            }
        }
        return null;
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Guia eliminarGuia = (Guia) registro;
        if (buscarConId(eliminarGuia.getId()) == null) {
            throw new MyExcepcion("4");
        }
        listaObjetos.remove(eliminarGuia);
        guardarFichero();
        return "Eliminación Correcta";
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
    public List<?> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Guia("Pedro", "Zona centro", "2626-166", LocalDate.of(2017, 12, 07), (short) 1));
            guardar(new Guia("Mauro", "Quitumbe", "1137-553", LocalDate.of(2019, 05, 03), (short) 2));
            guardar(new Guia("Yayo", "Zona Baja", "24324", LocalDate.now(), (short) 3));
        } catch (MyExcepcion ex) {
            ex.getMessage();
            ex.getStackTrace();
        }

    }

}
