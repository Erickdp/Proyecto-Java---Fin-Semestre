/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Habitat;
import java.util.List;

/**
 * Clase que representa las operaciones de negocio para Habitats
 *
 * @author Santiago Sisalem - Erick Díaz (Unplugged)
 */
public class HabitatTrs extends MemoriaBDD<Habitat> implements ICrud<Habitat> {

    public HabitatTrs() {
        super("Habitat");
        leerFichero();
    }

    @Override
    public String guardar(Habitat registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Habitat habitatRepetido : listaObjetos) {
                if (habitatRepetido.equals(registro)) {
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
    public String actulizar(Habitat registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Habitat habitatAntiguo : listaObjetos) {
                if (habitatAntiguo.getId() == registro.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(habitatAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Habitat registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(registro);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public List<Habitat> listar() {
        return listaObjetos;
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Habitat habitat : listaObjetos) {
            if (habitat.getId() == id) {
                return habitat;
            }
        }
        return null;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Habitat("Sabana", "Trópico Seco", "Sabanas herbácea", (short) 1));
            guardar(new Habitat("Bosque", "Subpolar & Continental", "Árboles y Matas", (short) 2));
            guardar(new Habitat("Montaña", "Frío y Húmedo", "Pradera Alphina", (short) 3));
            guardar(new Habitat("Pantano", "Seco", "Escorrentía", (short) 4));
            guardar(new Habitat("Selva", "Calido", "Vegetación Ttropical", (short) 5));
        } catch (MyExcepcion ex) {
            ex.getMessage();
            ex.getStackTrace();
        }
    }

}
