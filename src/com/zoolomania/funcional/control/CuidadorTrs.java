/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Cuidador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Erick Díaz
 */
public class CuidadorTrs extends MemoriaBDD<Cuidador> implements ICrud<Cuidador> {

    public CuidadorTrs() {
        super("Cuidador");
        leerFichero();
    }

    @Override
    public String guardar(Cuidador registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Cuidador cuidadorRepetido : listaObjetos) {
                if (cuidadorRepetido.equals(registro)) {
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
    public String actulizar(Cuidador registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Cuidador cuidadorAntiguo : listaObjetos) {
                if (cuidadorAntiguo.getId() == registro.getId()) {
                    registro.setFechInicioTrabajar(cuidadorAntiguo.getFechInicioTrabajar());
                    listaObjetos.set(listaObjetos.indexOf(cuidadorAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Cuidador registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(registro);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Cuidador cuidador : listaObjetos) {
            if (cuidador.getId() == id) {
                return cuidador;
            }
        }
        return null;
    }

    @Override
    public List<Cuidador> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Cuidador("Carlos", "Floresta", "331234", (short) 1));
            guardar(new Cuidador("José", "Oriental", "32423", (short) 2));
            guardar(new Cuidador("Esteban", "Quitumbe", "43252", (short) 3));
            guardar(new Cuidador("Mauro", "U.C.E", "23452", (short) 4));
            guardar(new Cuidador("Javier", "Ronda", "2345", (short) 5));
            guardar(new Cuidador("Antonio", "Santa Rita", "23421", (short) 6));
            guardar(new Cuidador("Carmen", "Teleferico", "32412", (short) 7));
            guardar(new Cuidador("Rosa", "Atahualpa", "3241", (short) 8));
            guardar(new Cuidador("Manuel", "Estadio Olimpico", "34214", (short) 9));
            guardar(new Cuidador("David", "Solanda", "32432", (short) 10));
            guardar(new Cuidador("Daniel", "Universitaria", "3242345", (short) 11));
            guardar(new Cuidador("Hugo", "Av. Simón Bolivar", "235412", (short) 12));
            guardar(new Cuidador("Pablo", "Gasca", "45321", (short) 13));
            guardar(new Cuidador("Lucas", "Oriental", "7563", (short) 14));
            guardar(new Cuidador("Mateo", "Aucas", "543872", (short) 15));
        } catch (MyExcepcion ex) {
            Logger.getLogger(CuidadorTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
