
import com.zoolomania.funcional.control.EspecieTrs;
import com.zoolomania.funcional.control.GuiaTrs;
import com.zoolomania.funcional.control.HabitatTrs;
import com.zoolomania.funcional.control.ItinerarioTrs;
import com.zoolomania.funcional.control.UsuarioTrs;
import com.zoolomania.funcional.control.ZonaTrs;
import com.zoolomania.funcional.modelo.Especie;
import com.zoolomania.funcional.modelo.Guia;
import com.zoolomania.funcional.modelo.Habitat;
import com.zoolomania.funcional.modelo.Itinerario;
import com.zoolomania.funcional.modelo.Usuario;
import com.zoolomania.funcional.modelo.Zona;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Prueba {

    static Scanner leer = new Scanner(System.in);
    static int numero;
    static UsuarioTrs utrs = new UsuarioTrs();
    static EspecieTrs etrs = new EspecieTrs();
    static GuiaTrs gtrs = new GuiaTrs();
    static HabitatTrs htrs = new HabitatTrs();
    static ItinerarioTrs itrs = new ItinerarioTrs();
    static ZonaTrs ztrs = new ZonaTrs();
    static List<Usuario> listaUsuarios = (List<Usuario>) utrs.listar();
    static List<Especie> listaEspecie = (List<Especie>) etrs.listar();
    static List<Guia> listaGuia = (List<Guia>) gtrs.listar();
    static List<Habitat> listaHabitat = (List<Habitat>) htrs.listar();
    static List<Itinerario> listaItinerario = (List<Itinerario>) itrs.listar();
    static List<Zona> listaZona = (List<Zona>) ztrs.listar();

    public static void inicializar() {

        System.out.println("Usuarios del Fichero:\n");
        for (Usuario usario : listaUsuarios) {
            System.out.println(usario);
        }
        System.out.println("\nEspecies:\n");
        for (Especie especie : listaEspecie) {
            System.out.println(especie);
        }
        System.out.println("\nGuias:\n");
        for (Guia guia : listaGuia) {
            System.out.println(guia);
        }
        System.out.println("\nHabitats:\n");
        for (Habitat habitat : listaHabitat) {
            System.out.println(habitat);
        }
        System.out.println("\nZonas:\n");
        for (Zona zona : listaZona) {
            System.out.println(zona);
        }
        System.out.println("\nItinerarios:\n");
        for (Itinerario itinerario : listaItinerario) {
            System.out.println(itinerario);
        }
    }

    /*public static void operacionCrud() {
        System.out.println("1. Agregar");
        System.out.println("2. Actaulizar");
        System.out.println("3. Consultar con ID");
        System.out.println("4. Eliminar");
        System.out.println("5. Listar");
        System.out.println("6. Salir");
        numero = leer.nextInt();
        switch (numero) {
            case 1:
                System.out.println("Ingrese un nombre");
                String nombre = leer.next();
                System.out.println("Ingrese una contraseña");
                String contra = leer.next();
                 {
                    try {
                        System.out.println(utrs.guardar(new Usuario(nombre, contra)));
                    } catch (MyExcepcion ex) {
                        ex.getMessage();
                    }
                }
                break;
            case 5:
                for (int i = 0; i < listaUsuarios.size(); i++) {
                    System.out.println(listaUsuarios.get(i));
                }
                System.out.println(listaUsuarios.size());
                break;
        }

    }*/
    public static void main(String[] args) {
        inicializar();
    }
}
