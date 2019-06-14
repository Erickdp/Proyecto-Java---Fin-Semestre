/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import java.util.List;

/**
 * Clase que representa las operaciones de negio para Itinerarios
 * @author Santiago Sisalem - Erick Díaz
 */
public class Itinerario extends MemoriaBDD<Itinerario> implements ICrud{

    public Itinerario() {
        super("Itinerario");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object consultarConId(int indice) throws MyExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void valoresDefecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
