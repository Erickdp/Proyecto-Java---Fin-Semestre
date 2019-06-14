
import com.zoolomania.funcional.control.MyExcepcion;
import com.zoolomania.funcional.control.UsuarioTrs;
import com.zoolomania.funcional.modelo.Usuario;
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
    static UsuarioTrs utrs = new UsuarioTrs();
    static List<Usuario> listaUsuarios = (List<Usuario>) utrs.listar();
    static int numero;

    public static void realizar() {
        for (Usuario listaUsuario : listaUsuarios) {
            System.out.println(listaUsuario);
        }
        /*EspecieTrs etrs = new EspecieTrs();
        GuiaTrs gtrs = new GuiaTrs();
        HabitatTrs htrs = new HabitatTrs();
        List<Habitat> listaHabitat = (List<Habitat>) htrs.listar();
        System.out.println("");
        List<Especie> listaEspecie = (List<Especie>) etrs.listar();
        for (Especie especie : listaEspecie) {
            System.out.println(especie);
        }
        System.out.println("");
        List<Guia> listaGuia = (List<Guia>) gtrs.listar();
        for (Guia guia : listaGuia) {
            System.out.println(guia);
        }
        System.out.println("");
        for (Habitat habitat : listaHabitat) {
            System.out.println(habitat);
        }*/
    }

    public static void operacionCrud() {
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

    }

    public static void main(String[] args) {
        Prueba.realizar();
        System.out.println(listaUsuarios.size());
        do {
            Prueba.operacionCrud();
        } while (Prueba.numero != 6);
    }
}
