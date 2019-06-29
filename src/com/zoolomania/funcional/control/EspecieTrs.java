/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.control.ICrud;
import com.zoolomania.funcional.control.MemoriaBDD;
import com.zoolomania.funcional.control.MyExcepcion;
import com.zoolomania.funcional.modelo.Especie;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que representa las operaciones de negocio para Especies
 *
 * @author Erick Díaz
 */
public class EspecieTrs extends MemoriaBDD<Especie> implements ICrud<Especie> {

    public EspecieTrs() {
        super("Especie");
        leerFichero();
    }

    @Override
    public String guardar(Especie registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getMarca()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Especie especieRepetida : listaObjetos) {
                if (especieRepetida.equals(registro)) {
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
    public String actulizar(Especie registro) throws MyExcepcion {
        if (buscarConId(registro.getMarca()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Especie especieAntiguo : listaObjetos) {
                if (especieAntiguo.getMarca() == registro.getMarca()) {
                    registro.setFechaRegistrada(especieAntiguo.getFechaRegistrada());
                    listaObjetos.set(listaObjetos.indexOf(especieAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Especie registro) throws MyExcepcion {
        if (buscarConId(registro.getMarca()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(registro);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public List<Especie> listar() {
        return listaObjetos;
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Especie especie : listaObjetos) {
            if (especie.getMarca() == id) {
                return especie;
            }
        }
        return null;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Especie("Leon", "Panthera", "Mamífero Carnívoro de la familia de los félidos y una\n "
                    + "de las cinco especies del género Panthera.", (short) 1));
            guardar(new Especie("Elefante", "Elephantidee", "Son una familia de mamíderos placentarios del orden\n "
                    + "Proboscidea. Existen hoy en día tres cuidadors y diversas subcuidadors", (short) 2));
            guardar(new Especie("Chimpancé", "Pan", "Es un género de primates homínidos que comprende las\n "
                    + "cuidadors Pan troglodytes y Pan paniscus. Su promedio de vida es de 50 años.", (short) 3));
            guardar(new Especie("Cebra", "Equus grevji", "Las cebras son altamente sociables. Aun así, su estructura\n "
                    + "social depende de la cuidador. Las cebras de comtaña y cebras comunes viven en grupos, conocidos"
                    + " como \"harenes", (short) 4));
            guardar(new Especie("Pingüino", "Spheniscidae", "Los pingüinos son una familia de aves, la única del orden Sphenisciformes. Son aves marinas, no voladoras, "
                    + "\nque se distribuyen casi exclusivamente en el hemisferio sur, exceptuando el pingüino de las islas Galápagos.", (short) 5));
            guardar(new Especie("Iguana", "Laurenti‎", "Iguana es un género de sauropsidos escamosos de la familia Iguanidae nativos de "
                    + "zonas tropicales de Centroamérica, Sudamérica y el Caribe.", (short) 6));
            guardar(new Especie("Torutga", "Testudines", "Las tortugas o quelonios forman un orden de reptiles caracterizados por tener un "
                    + "\ntronco ancho y corto, y un caparazón que protege los órganos internos de su cuerpo", (short) 7));
            guardar(new Especie("Gavilán", "Accipiter nisus", "El gavilán común ​​ es una especie de ave accipitriforme de la familia Accipitridae, "
                    + "\npresente en muchas zonas de Eurasia —desde la península ibérica y el norte de África hasta Japón y Vietnam", (short) 8));
            guardar(new Especie("Leones Marinos", "Otariinae", "Los otarinos u otaríinos son una subfamilia de mamíferos marinos conocidos como l"
                    + "\nobos marinos. Esta subfamilia está dentro de la familia Otariidae en la superfamilia Pinnipedia.", (short) 9));
            guardar(new Especie("Fragata", "Fregata", "Fregata es un género de aves suliformes, el único de la familia Fregatidae, ​​ conocidas "
                    + "\nvulgarmente como rabihorcados o fragatas. Viven en zonas tropicales de los océanos Pacífico y Atlántico.", (short) 10));
            guardar(new Especie("Avestruz", "Struthio camelus", "Pertenece a las especies de aves no voladoras , ​​ conocidas "
                    + "\nestrutioniformes. Viven en zonas aridas y semiaridas como desiertos y sabanas de Africa.", (short) 11));
           guardar(new Especie("Ave Martillo", "Scopus umbretta", "Es una especie  de ave pelecaniforme de la familia Scopidae "
                    + "\nvulgarmente como Pelacaniforme. Habita los rios y humedales del Africa subsahariana.", (short) 12));
           guardar(new Especie("Cigueña de Abdim", "Ciconia abdimil", "Se alimenta casi exclusivamente de grandes insectos  "
                    + "\nAve migratoria intra-africana en temporadas de lluvias.Habita toda la region de la sabana africana", (short) 13));
           guardar(new Especie("Condor", "Vuitur gryphus", "es una ave  sudamericana en la familia de  buitres, ​​ se encuentra en peligro de Extincion "
                    + "\nSe en cuentran en la coordillera de los andes  y en las costas adyacentes del Pacifico.", (short) 14));
           guardar(new Especie("Jirafa", "Giraffa camelopardalis rosthscildi", "Destacan por su cuello largo, miembros anteriores mas largos que los posteriores "
                    + "\nson nativas de Africa, viven tanto en los pastos  como es bosques y llanuras.", (short) 15));
           guardar(new Especie("Gorila", "Gorilla", "Pertenecientes  al genero Gorilla son primates con, ​​ composiciones "
                    + "\ngeneticas muy parecidas las del ser humano, habita en bosques tropicales de Camerun, republica Centroafricana", (short) 16));
           guardar(new Especie("Buho Real", "Bubo bubo", "Es una de las aves rapaces mas conocidas gracias a su majestuosidad y abundancia, ​ "
                    + "\nHabita en lugarestan dispares como regiones desericas de Africa y Asia.", (short) 17));
           guardar(new Especie("Aguila", "Aquila chrysaetos", "Esta gran ave tiene el cuerpo muy delgado y unas amplias alas con grandes ojos, ​​ "
                    + "\nSe encuentran en cualquier region del mundo, siempre y cuando el luar donde vivan no sea demasiado frio", (short) 18));
           guardar(new Especie("Cocodrilo", "Crocodylus niloticus", "Son una especie de depredadores mas grande que existe en la tierra, incluso mas que los tigres y los leones "
                    + "\nSe encuentran en las zonas tropicales y subtropicales tanto en Africa como en CentroAmerica", (short) 19));
           guardar(new Especie("Koala", "Phascolarctos Cinereus", "Marsupial herviboro, su dentadura esta adaptada con afilados dientes incisivos para cortar hojas​ "
                    + "\nVive exclusivamente en regiones australiana", (short) 20));
           
        } catch (MyExcepcion ex) {
            Logger.getLogger(EspecieTrs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
