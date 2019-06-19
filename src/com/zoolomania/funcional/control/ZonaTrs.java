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
        Zona nuevoZona = (Zona) registro;
        if (listaObjetos.contains(nuevoZona)) {
            throw new MyExcepcion("1");
        } else {
            listaObjetos.add(nuevoZona);
            guardarFichero();
            return "Zona guardado correctamente";
        }

    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Zona actualizarZona = (Zona) registro;
        for (Zona zonaAntiguo : listaObjetos) {
            if (zonaAntiguo.equals(actualizarZona)) {
                zonaAntiguo = actualizarZona;
                guardarFichero();
                return "Zona actualizada";
            }
        }
        throw new MyExcepcion("2");
    }

    @Override
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion {
        for (Zona buscarId : listaObjetos) {
            if (buscarId.getId() == indice) {
                return listaObjetos.get(indice);
            }
        }
        throw new MyExcepcion("3");
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        try {
            Zona borrarZona = (Zona) consultarConId(indice);
            listaObjetos.remove(borrarZona);
            guardarFichero();
            return "Eliminación correcta";
        } catch (NumberFormatException ex) {
            Logger.getLogger(ZonaTrs.class.getName()).log(Level.SEVERE, null, ex);
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
            /*
            Esta zona no sirve utilizar constructor que permite ingresar listas
            */
            guardar(new Zona("Media", 2.2F));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ZonaTrs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
