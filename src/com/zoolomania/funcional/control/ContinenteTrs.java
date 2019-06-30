/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Continente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que represetna las operaciones de negocio relacionadas con el continente
 * @author Erick Díaz
 */
public class ContinenteTrs extends MemoriaBDD<Continente> implements ICrud<Continente> {

    public ContinenteTrs() {
        super("Continente");
        leerFichero();
    }

    @Override
    public String guardar(Continente registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("1");
        }
        for (Continente continenteV : listaObjetos) {
            if (continenteV.equals(registro)) {
                throw new MyExcepcion("1");
            }
        }
        listaObjetos.add(registro);
        guardarFichero();
        return "Registro guardado";
    }

    @Override
    public String actulizar(Continente registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        }
        for (Continente continenteV : listaObjetos) {
            if (continenteV.getId() == registro.getId()) {
                listaObjetos.set(listaObjetos.indexOf(continenteV), registro);
                guardarFichero();
                return "Actualizado correctamente";
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Continente continentes : listaObjetos) {
            if (continentes.getId() == id) {
                return continentes;
            }
        }
        return null;
    }

    @Override
    public String eliminar(Continente registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("4");
        }
        listaObjetos.remove(registro);
        guardarFichero();
        return "Eliminado correctamente";
    }

    @Override
    public List<Continente> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Continente((short) 1, "Asia"));
            guardar(new Continente((short) 2, "África"));
            guardar(new Continente((short) 3, "Australia"));
            guardar(new Continente((short) 4, "América"));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ContinenteTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
