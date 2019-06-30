/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Itinerario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa las operaciones de negio para Itinerarios
 *
 * @author Erick Díaz
 */
public class ItinerarioTrs extends MemoriaBDD<Itinerario> implements ICrud<Itinerario> {

    public ItinerarioTrs() {
        super("Itinerario");
        leerFichero();
    }

    @Override
    public String guardar(Itinerario registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Itinerario itinerarioRepetido : listaObjetos) {
                if (itinerarioRepetido.equals(registro)) {
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
    public String actulizar(Itinerario registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Itinerario itinerarioAntiguo : listaObjetos) {
                if (itinerarioAntiguo.getId() == registro.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(itinerarioAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Itinerario registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(registro);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public List<Itinerario> listar() {
        return listaObjetos;
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Itinerario itinerario : listaObjetos) {
            if (itinerario.getId() == id) {
                return itinerario;
            }
        }
        return null;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Itinerario("1df212", (byte) 30, (short) 1, 5.5F));
            guardar(new Itinerario("452gasd3", (byte) 40, (short) 2, 10.2F));
            guardar(new Itinerario("34trs25", (byte) 15, (short) 3, 3.45F));
            guardar(new Itinerario("43g56", (byte) 11, (short) 4, 4.7F));
            guardar(new Itinerario("90asd832", (byte) 12, (short) 5, 10));
            guardar(new Itinerario("82er43", (byte) 5, (short) 6, 7));
            guardar(new Itinerario("943gdf52", (byte) 4, (short) 7, 5));
            guardar(new Itinerario("943hr00", (byte) 76, (short) 9, 12.6F));
            guardar(new Itinerario("941sa11", (byte) 1, (short) 12, 21.9F));
            guardar(new Itinerario("9422gf2", (byte) 15, (short) 17, 27));
        } catch (MyExcepcion ex) {
            Logger.getLogger(ItinerarioTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
