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
 * @author Erick Díaz (Unplugged)
 */
public class ZonaTrs extends MemoriaBDD<Zona> implements ICrud<Zona> {

    public ZonaTrs() {
        super("Zona");
        leerFichero();
    }

    @Override
    public String guardar(Zona registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Zona zonaRepetido : listaObjetos) {
                if (zonaRepetido.equals(registro)) {
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
    public String actulizar(Zona registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Zona zonaAntiguo : listaObjetos) {
                if (zonaAntiguo.getId() == registro.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(zonaAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Zona registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(registro);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public List<Zona> listar() {
        return listaObjetos;
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
    protected void valoresDefecto() {
        try {
            guardar(new Zona("Media", 2.2F, (short) 1));
            guardar(new Zona("Alta", 3.5F, (short) 2));
            guardar(new Zona("Baja", 1.2F, (short) 3));
            guardar(new Zona("Calurosa", 1.8F, (short) 4));
            guardar(new Zona("Norte", 2.7F, (short) 5));
            guardar(new Zona("Sur", 1.9F, (short) 6));
            guardar(new Zona("Oriente", 1.0F, (short) 7));
            guardar(new Zona("Piedras", 2.3F, (short) 8));
            guardar(new Zona("Lluviosa", 0.5F, (short) 9));
            guardar(new Zona("Centro", 2.3F, (short) 10));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ZonaTrs.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
