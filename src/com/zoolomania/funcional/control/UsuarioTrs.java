/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.control.MyExcepcion;
import com.zoolomania.funcional.modelo.Usuario;
import java.util.List;

/**
 * Clase que representa las operaciones de negocio para Usuarios
 *
 * @author Erick Díaz (unplugged)
 */
public class UsuarioTrs extends MemoriaBDD<Usuario> implements ICrud<Usuario> {

    public UsuarioTrs() {
        super("Usuario");
        leerFichero();
    }

    @Override
    public String guardar(Usuario registro) throws MyExcepcion {
        boolean bandera = false;
        if (buscarConId(registro.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Usuario usuarioRepetido : listaObjetos) {
                if (usuarioRepetido.getUserName().equalsIgnoreCase(registro.getUserName())
                        || usuarioRepetido.getEmail().equalsIgnoreCase(registro.getEmail())) {
                    bandera = true;
                    break;
                }
            }
            if (!bandera) {
                listaObjetos.add(registro);
                guardarFichero();
                return "Guardado Correctamente";
            } else {
                throw new MyExcepcion("1");
            }
        }
    }

    @Override
    public String actulizar(Usuario registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Usuario usuarioAntiguo : listaObjetos) {
                if (usuarioAntiguo.getId() == registro.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(usuarioAntiguo), registro);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Usuario registro) throws MyExcepcion {
        if (buscarConId(registro.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(registro);
            guardarFichero();
            return "Eliminación Correcta";
        }
    }

    @Override
    public List<Usuario> listar() {
        return listaObjetos;
    }

    @Override
    public Object buscarConId(short id) throws NumberFormatException {
        for (Usuario usuario : listaObjetos) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Usuario("admin", "123", "admin@uce", (short) 1));
            guardar(new Usuario("erick", "123", "erick@hotmail.com", (short) 2));
        } catch (MyExcepcion ex) {
            ex.getMessage();
            ex.getStackTrace();
        }

    }

    public Usuario buscarUsuario(String usuario, String pass) {
        for (Usuario usuarios : listaObjetos) {
            if (usuarios.getUserName().equals(usuario) & usuarios.getPassword().equals(pass)) {
                return usuarios;
            }
        }
        return null;
    }

}
