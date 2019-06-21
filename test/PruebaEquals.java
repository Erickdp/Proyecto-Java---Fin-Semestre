
import com.zoolomania.funcional.control.CuidadorTrs;
import com.zoolomania.funcional.control.EspecieTrs;
import com.zoolomania.funcional.control.MyExcepcion;
import com.zoolomania.funcional.modelo.Cuidador;
import com.zoolomania.funcional.modelo.Especie;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Erick Díaz
 */
public class PruebaEquals {

    static CuidadorTrs ctrs = new CuidadorTrs();
    static EspecieTrs etrs = new EspecieTrs();
    static Scanner leer = new Scanner(System.in);
    static byte numero;
    static Cuidador cuidadorN;
    static Especie especieN;
    static List<Cuidador> listaC = (List<Cuidador>) ctrs.listar();
    static Cuidador nuevoC = listaC.get(0);
    static List<Especie> listaE = (List<Especie>) etrs.listar();
    static Especie nuevaE = listaE.get(0);
    static List<Especie> listaEspecies = nuevoC.getEspecies();
    static List<Cuidador> listaCuidadores = nuevaE.getCuiadores();

    public static void iniciar() {
        Collections.sort(listaEspecies, Comparator.reverseOrder());
        Collections.sort(listaCuidadores, Comparator.reverseOrder());
        Collections.sort(listaC);
        Collections.sort(listaE, Comparator.reverseOrder());
        System.out.println("Lista de Cuidadores\n");
        for (Cuidador cuidador : listaC) {
            System.out.println(cuidador);
        }
        System.out.println("\nLista de especies\n");
        for (Especie especie : listaE) {
            System.out.println(especie);
        }
        System.out.println("\n" + nuevoC);
        System.out.println("Lista de especies cuidadas\n");
        for (Especie i : listaEspecies) {
            System.out.println(i);
        }
        System.out.println("Tamaño de la lista de especies a cuidar de " + nuevoC.getNombre() + " - " + listaEspecies.size());
        System.out.println("Desea agreagar una nueva especie? 1 = Si");
        numero = leer.nextByte();
        if (numero == 1) {
            System.out.println("Ingrese el nombre");
            String nombre = leer.next();
            System.out.println("Ingrese nombre científico");
            String nombreC = leer.next();
            System.out.println("Ingrese un descripción");
            String descripcion = leer.next();
            System.out.println("Ingrese la marca del animal");
            short marca = leer.nextShort();
            especieN = new Especie(nombre, nombreC, descripcion, marca);
            nuevoC.cuidarNuevaEspecie(especieN);
            especieN.agregarCuidador(nuevoC);
            System.out.println("Lista de especies cuidadas\n");
            for (Especie i : listaEspecies) {
                System.out.println(i);
            }
            System.out.println("Tamaño de la lista de especies a cuidar de " + nuevoC.getNombre() + " - " + listaEspecies.size());
            try {
                System.out.println("Nueva especie: " + etrs.guardar(especieN));
                System.out.println("Cuidador actualizado de especie" + ctrs.actulizar(nuevoC));
            } catch (MyExcepcion ex) {
                ex.getMessage();
            }
        }
        System.out.println("\n" + nuevaE);
        System.out.println("Lista cuidadores de la especie\n");
        for (Cuidador i : listaCuidadores) {
            System.out.println(i);
        }
        System.out.println("Tamaño de la lista de cuidadores de la especie " + nuevaE.getNombreEspecie() + " - " + listaCuidadores.size());
        System.out.println("Desea agreagar un nuevo Cuidador? 1 = Si");
        numero = leer.nextByte();
        if (numero == 1) {
            System.out.println("Ingrese el nombre");
            String nombre = leer.next();
            System.out.println("Ingrese la direccion");
            String nombreC = leer.next();
            System.out.println("Ingrese un teléfono");
            String descripcion = leer.next();
            System.out.println("El día que empieza a trabajar es hoy a trabajar");
            System.out.println("Ingrese un ID");
            short id = leer.nextShort();
            cuidadorN = new Cuidador(nombre, nombreC, descripcion, LocalDate.now(), id);
            nuevaE.agregarCuidador(cuidadorN);
            cuidadorN.cuidarNuevaEspecie(nuevaE);
            System.out.println("Lista de cuidadores de la especie\n");
            for (Cuidador i : listaCuidadores) {
                System.out.println(i);
            }
            System.out.println("Tamaño de la lista de cuidadores de la especie " + nuevaE.getNombreEspecie() + " - " + listaCuidadores.size());

            try {
                System.out.println("Lista de cuidadores actualizados " + etrs.actulizar(nuevaE));
                System.out.println("Cuidador nuevo creado " + ctrs.guardar(cuidadorN) + "\n");
            } catch (MyExcepcion ex) {
                ex.getMessage();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i < 10; i++) {
            PruebaEquals.iniciar();
        }
    }

}
