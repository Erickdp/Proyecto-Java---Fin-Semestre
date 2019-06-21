/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Zona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa las operaciones de negocio para Zonas
 *
 * @author Santiago Sisalem - Erick Díaz (Unplugged)
 */
public class ZonaTrs extends MemoriaBDD<Zona> implements ICrud {

    public ZonaTrs() {
        super("Zona");
        leerFichero();
    }

     @Override
    public String guardar(Object registro) throws MyExcepcion {
        Zona guardarZona = (Zona) registro;
        if (buscarConId(guardarZona.getId()) != null) {
            throw new MyExcepcion("3");
        }
        for (Zona zonaRepetido : listaObjetos) {
            if (zonaRepetido.equals(guardarZona)) {
                throw new MyExcepcion("1");
            }
        }
        listaObjetos.add(guardarZona);
        guardarFichero();
        return "Guardado Correctamente";
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Zona actualizarZona = (Zona) registro;
        if (buscarConId(actualizarZona.getId()) != null) {
            throw new MyExcepcion("2");
        }
        for (Zona zonaAntiguo : listaObjetos) {
            if (zonaAntiguo.getId() == actualizarZona.getId()) {
                zonaAntiguo = actualizarZona;
                guardarFichero();
                return "Actualizado Correctamente";
            }
        }
        return null;
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Zona eliminarZona = (Zona) registro;
        if (buscarConId(eliminarZona.getId()) == null) {
            throw new MyExcepcion("4");
        }
        listaObjetos.remove(eliminarZona);
        guardarFichero();
        return "Eliminación Correcta";
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Zona zona : listaObjetos) {
            if (zona.getId() == id) {
                return zona;
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
            /*
            Esta zona no sirve utilizar constructor que permite ingresar listas
            */
            guardar(new Zona("Media", 2.2F, (short) 1));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ZonaTrs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
