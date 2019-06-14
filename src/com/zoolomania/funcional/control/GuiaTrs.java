/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Guia;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa las operaciones de negocio para los Cuidadores
 *
 * @author Santiago Sisalem - Erick Díaz (Unplugged)
 */
public class GuiaTrs extends MemoriaBDD<Guia> implements ICrud {

    public GuiaTrs() {
        super("Guia");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        Guia nuevoGuia = (Guia) registro;
        if (listaObjetos.contains(nuevoGuia)) {
            throw new MyExcepcion("1");
        } else {
            listaObjetos.add(nuevoGuia);
            guardarFichero();
            return "Guia guardado correctamente";
        }

    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Guia actualizarGuia = (Guia) registro;
        for (Guia guiaAntiguo : listaObjetos) {
            if (guiaAntiguo.equals(actualizarGuia)) {
                guiaAntiguo = actualizarGuia;
                guardarFichero();
                return "Contraseña actualizada";
            }
        }
        throw new MyExcepcion("2");
    }

    @Override
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion {
        for (Guia buscarId : listaObjetos) {
            if (buscarId.getId() == indice) {
                return listaObjetos.get(indice);
            }
        }
        throw new MyExcepcion("3");
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        try {
            Guia borrarGuia = (Guia) consultarConId(indice);
            listaObjetos.remove(borrarGuia);
            guardarFichero();
            return "Eliminación correcta";
        } catch (NumberFormatException ex) {
            Logger.getLogger(GuiaTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new MyExcepcion("4");
    }

    @Override
    public List<?> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
        if (listaObjetos.isEmpty()) {
            try {
                guardar(new Guia("Pedro", "Zona centro", "2626-166", LocalDate.of(2019, 04, 05)));
                guardar(new Guia("Mauro", "Quitumbe", "1137-553", LocalDate.of(2019, 01, 03)));
                guardar(new Guia("Yayo", "Foch", "1111-2323", LocalDate.of(2006, 12, 04)));
            } catch (MyExcepcion ex) {
                ex.getMessage();
                ex.getStackTrace();
            }

        }
    }

}
