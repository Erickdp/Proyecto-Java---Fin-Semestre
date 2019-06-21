
import com.zoolomania.funcional.control.CuidadorTrs;
import com.zoolomania.funcional.control.EspecieTrs;
import com.zoolomania.funcional.control.MyExcepcion;
import com.zoolomania.funcional.modelo.Cuidador;
import com.zoolomania.funcional.modelo.Especie;
import java.time.LocalDate;
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
public class PruebaCrud {

    static CuidadorTrs ctrs = new CuidadorTrs();
    static EspecieTrs etrs = new EspecieTrs();
    static Scanner leer = new Scanner(System.in);
    static byte numero;
    static Cuidador cuidadorN;
    static Especie especieN;
    static List<Cuidador> listaC = (List<Cuidador>) ctrs.listar();
    static List<Especie> listaE = (List<Especie>) etrs.listar();

    public static void menu() {
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
        System.out.println("\nQuiere trabajar con Especies (1), Cuidadores (2) o (3) Quiere mirar relaciones entre espeecies y cuidadores?");
        numero = leer.nextByte();
        if (numero == 1) {
            crudEspecies();
        } else if (numero == 2) {
            crudCuidadores();

        } else {
            relaciones();
        }
    }

    public static void relaciones() {
        for (Cuidador cuidador : listaC) {
            System.out.println(cuidador);
        }
        System.out.println("\nLista de especies\n");
        for (Especie especie : listaE) {
            System.out.println(especie);
        }
        do {
            System.out.println("Desea ver Cuidadores 1 Especies 2, Menu 3");
            numero = leer.nextByte();
            switch (numero) {
                case 1:
                    System.out.println("Ingrese el id del cuidador para mirar que especies cuida");
                    short id = leer.nextShort();
                    cuidadorN = (Cuidador) ctrs.buscarConId(id);
                    while (cuidadorN == null) {
                        System.out.println("No se encutra el ID");
                        id = leer.nextShort();
                        cuidadorN = (Cuidador) ctrs.buscarConId(id);
                    }
                    List<Especie> especies = cuidadorN.getEspecies();
                    for (Especie especy : especies) {
                        System.out.println(especy);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la marca de la especie para ver quienes lo cuidan");
                    id = leer.nextShort();
                    especieN = (Especie) etrs.buscarConId(id);
                    while (especieN == null) {
                        System.out.println("No se encutra la marca");
                        id = leer.nextShort();
                        especieN = (Especie) etrs.buscarConId(id);
                    }
                    List<Cuidador> cuidadores = especieN.getCuiadores();
                    for (Cuidador especy : cuidadores) {
                        System.out.println(especy);
                    }
                    break;
                case 3:
                    menu();
                    break;
            }
        } while (numero != 3);

    }

    public static void crudCuidadores() {
        Especie especieN, especieV;
        System.out.println("Ingrese el ID del Cuidador que quiere administrar y verá sus especies");
        numero = leer.nextByte();
        Cuidador cuidadorCrud = (Cuidador) ctrs.buscarConId((short) numero);
        List<Especie> especies = cuidadorCrud.getEspecies();
        System.out.println("Tamaño de la lista de especies del cuidador " + cuidadorCrud.getNombre() + " - " + especies.size());
        for (Especie especie : especies) {
            System.out.println(especie);
        }
        do {
            System.out.println("Desea: \n1. Agregar\n2. Modificar Especie\n3. Actualizar Cuidador\n4. Eliminar\n5. Regresar Al menú");
            numero = leer.nextByte();
            switch (numero) {
                case 1:
                    System.out.println("Ingrese el nombre de la especie");
                    String nombre = leer.next();
                    System.out.println("Ingrese nombre Cientifico");
                    String nombreC = leer.next();
                    System.out.println("Ingrese una descripción");
                    String descripcion = leer.next();
                    System.out.println("La fecha en que empezó a cuidar a la especie es hoy");
                    System.out.println("Ingrese una marca para la especie");
                    short id = leer.nextShort();
                    especieV = (Especie) etrs.buscarConId(id);
                    while (especieV != null) {
                        System.err.println("Una especie no puede tener una misa marca");
                        id = leer.nextShort();
                        especieV = (Especie) etrs.buscarConId(id);
                    }
                    especieN = new Especie(nombre, nombreC, descripcion, id);
                    cuidadorCrud.cuidarNuevaEspecie(especieN);
                    especieN.agregarCuidador(cuidadorCrud);
                    try {
                        System.out.println("\n" + etrs.guardar(especieN));
                        System.out.println(ctrs.actulizar(cuidadorCrud) + "\n");
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }
                    break;
                case 2:
                    for (Especie cuidador : especies) {
                        System.out.println(cuidador);
                    }
                    System.out.println("A cuál quiere modificar? Ingrese su marca");
                    id = leer.nextShort();
                    especieV = (Especie) etrs.buscarConId(id);
                    while (especieV == null) {
                        System.err.println("No se encuentra la marca, ingrese de nuevo");
                        id = leer.nextShort();
                        especieV = (Especie) ctrs.buscarConId(id);
                    }
                    System.out.println("Ingrese el nombre científico");
                    nombre = leer.next();
                    System.out.println("El día de cuidado es mismo que la última vez");
                    System.out.println("La marca no se puede modificar");
                    try {
                        System.out.println(etrs.actulizar(new Especie(especieV.getNombreEspecie(), nombre, especieV
                                .getDescripcion(), especieV.getMarca())));
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }
                    break;
                case 3:
                    System.out.println("Ingrese nuevo nombre del Cuidador");
                    nombreC = leer.next();
                    try {
                        System.out.println(ctrs.actulizar(new Cuidador(nombreC, cuidadorCrud.getDireccion(),
                                cuidadorCrud.getTelefono(), cuidadorCrud.getFechInicioTrabajar(), cuidadorCrud.getId())));
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }
                    break;
                case 4:
                    for (Especie cuidador : listaE) {
                        System.out.println(cuidador);
                    }
                    System.out.println("Ingrese la marca de la especie tener en cuenta que si elimina a la especie solamente "
                            + "lo dejará de cuidar el cuidador actual");
                    id = leer.nextShort();
                    cuidadorCrud.eliminarEspecie((Especie) etrs.buscarConId(id));
                    break;
                case 5:
                    menu();
                    break;
            }
        } while (numero != 5);

    }

    public static void crudEspecies() {
        Cuidador cuidadorN,
                cuidadorV;
        short id;
        System.out.println("Ingrese a la especie que quiere administrar y verá sus cuidadores");
        numero = leer.nextByte();
        Especie especieCrud = (Especie) etrs.buscarConId((short) numero);
        List<Cuidador> cuidadores = especieCrud.getCuiadores();
        System.out.println("Tamaño de la lista de cuidadores de la especie " + especieCrud.getNombreEspecie() + " - " + cuidadores.size());
        for (Cuidador cuidadore : cuidadores) {
            System.out.println(cuidadores);
        }
        do {
            System.out.println("Desea: \n1. Agregar\n2. Modificar Cuidador\n3. Actualizar Especie\n4. Eliminar\n5. Regresar Al menú");
            numero = leer.nextByte();
            switch (numero) {
                case 1:
                    System.out.println("Ingrese el nombre");
                    String nombre = leer.next();
                    System.out.println("Ingrese la direccion");
                    String nombreC = leer.next();
                    System.out.println("Ingrese un teléfono");
                    String descripcion = leer.next();
                    System.out.println("El día que empieza a trabajar es hoy a trabajar");
                    System.out.println("Ingrese un ID");
                    id = leer.nextShort();
                    cuidadorV = (Cuidador) ctrs.buscarConId(id);
                    while (cuidadorV != null) {
                        System.err.println("Un cuidador no puede tener un mismo ID, ingrese otro");
                        id = leer.nextShort();
                        cuidadorV = (Cuidador) ctrs.buscarConId(id);
                    }
                    cuidadorN = new Cuidador(nombre, nombreC, descripcion, LocalDate.now(), id);
                    especieCrud.agregarCuidador(cuidadorN);
                    cuidadorN.cuidarNuevaEspecie(especieCrud);
                    try {
                        System.out.println("\n" + ctrs.guardar(cuidadorN));
                        System.out.println(etrs.actulizar(especieCrud) + "\n");
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }

                    break;
                case 2:
                    for (Cuidador cuidador : cuidadores) {
                        System.out.println(cuidador);
                    }
                    System.out.println("A cuál quiere modificar?");
                    id = leer.nextShort();
                    cuidadorV = (Cuidador) ctrs.buscarConId(id);
                    while (cuidadorV != null) {
                        System.err.println("No se encuentra el ID del cuidador, ingrese de nuevo");
                        id = leer.nextShort();
                        cuidadorV = (Cuidador) ctrs.buscarConId(id);
                    }
                    System.out.println("Ingrese el nombre");
                    nombre = leer.next();
                    System.out.println("Ingrese la direccion");
                    nombreC = leer.nextLine();
                    System.out.println("Ingrese un teléfono");
                    descripcion = leer.next();
                    System.out.println("El día que es el mismo que la última vez");
                    System.out.println("El ID no se puede modificar");
                    try {
                        System.out.println(ctrs.actulizar(new Cuidador(nombre, nombreC, descripcion, cuidadorV.
                                getFechInicioTrabajar(), cuidadorV.getId())));
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }
                    break;
                case 3:
                    System.out.println("Ingrese nuevo nombre científico de la especie");
                    nombreC = leer.next();
                    try {
                        System.out.println(etrs.actulizar(new Especie(especieCrud.getNombreEspecie(), nombreC, especieCrud.getDescripcion(), especieCrud.getMarca())));
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }
                    break;
                case 4:
                    for (Cuidador cuidador : listaC) {
                        System.out.println(cuidador);
                    }
                    System.out.println("Ingrese el id del cuidador a eliminar tener en cuenta si elimina al cuidador este solo dejará de cuidar"
                            + "a la especie actual");
                    id = leer.nextShort();
                    especieCrud.eliminarCuidador((Cuidador) ctrs.buscarConId(id));
                    break;
                case 5:
                    menu();
                    break;
            }

        } while (numero != 5);

    }

    public static void eliminaciones() {
        do {
            System.out.println("Eliminar Especie 1 o Cuidador 2? Menu 3");
            numero = leer.nextByte();
            switch (numero) {
                case 1:
                    for (Especie especie : listaE) {
                        System.out.println(especie);
                    }
                    System.out.println("Ingrese la marca de especie a eliminar (tener en cuenta que si elimina a la especie sus cuidadores ya no"
                            + "tendrán a esa especie en sus listas");
                    short id = leer.nextShort();
                    especieN = (Especie) etrs.buscarConId(id);
                    while (especieN == null) {
                        System.err.println("No se encuntra la marca de la especie reintente");
                        id = leer.nextShort();
                        especieN = (Especie) etrs.buscarConId(id);
                    }
                    try {
                        System.out.println(etrs.eliminar(especieN));
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }
                    break;
                case 2:
                    for (Cuidador cuidador : listaC) {
                        System.out.println(cuidador);
                    }
                    System.out.println("Ingrese el id del cuidador a eliminar tener en cuenta si elimina al cuidador este solo dejará de cuidar "
                            + "todas las especies que cuida ya no estarán en sus listas de cuidadores");
                    id = leer.nextShort();
                    cuidadorN = (Cuidador) ctrs.buscarConId(id);
                    while (cuidadorN == null) {
                        System.err.println("No se encuntra el id del cuidador reintente");
                        id = leer.nextShort();
                        cuidadorN = (Cuidador) ctrs.buscarConId(id);
                    }
                    try {
                        System.out.println(ctrs.eliminar(cuidadorN));
                    } catch (MyExcepcion ex) {
                        Logger.getLogger(PruebaCrud.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    menu();
            }
        } while (numero != 3);
    }

    public static void main(String[] args) {
        menu();
    }
}

/*static Cuidador nuevoC = listaC.get(0);
    static Especie nuevaE = listaE.get(0);
    static List<Especie> listaEspecies = nuevoC.getEspecies();
    static List<Cuidador> listaCuidadores = nuevaE.getCuiadores();*/ /**
 * @param args the command line arguments
 */
