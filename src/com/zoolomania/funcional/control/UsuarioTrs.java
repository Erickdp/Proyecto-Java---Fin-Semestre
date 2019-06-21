/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.control;

import com.zoolomania.funcional.modelo.Usuario;
import java.util.List;

/**
 * Clase que representa las operaciones de negocio para Usuarios
 *
 * @author Santiago Sisalem - Erick Díaz (unplugged)
 */
public class UsuarioTrs extends MemoriaBDD<Usuario> implements ICrud {

    public UsuarioTrs() {
        super("Usuario");
        leerFichero();
    }

    @Override
    public String guardar(Object registro) throws MyExcepcion {
        Usuario guardarUsuario = (Usuario) registro;
        boolean bandera = false;
        if (buscarConId(guardarUsuario.getId()) != null) {
            throw new MyExcepcion("3");
        } else {
            for (Usuario usuarioRepetido : listaObjetos) {
                if (usuarioRepetido.equals(guardarUsuario)) {
                    bandera = true;
                    throw new MyExcepcion("1");
                }
            }
            if (!bandera) {
                listaObjetos.add(guardarUsuario);
                guardarFichero();
                return "Guardado Correctamente";
            } else {
                return "No se pudo guardar";
            }
        }
    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Usuario actualizarUsuario = (Usuario) registro;
        if (buscarConId(actualizarUsuario.getId()) == null) {
            throw new MyExcepcion("2");
        } else {
            for (Usuario usuarioAntiguo : listaObjetos) {
                if (usuarioAntiguo.getId() == actualizarUsuario.getId()) {
                    listaObjetos.set(listaObjetos.indexOf(usuarioAntiguo), actualizarUsuario);
                    guardarFichero();
                    return "Actualizado Correctamente";
                }
            }
        }
        return "No se pudo actualizar";
    }

    @Override
    public String eliminar(Object registro) throws MyExcepcion {
        Usuario eliminarUsuario = (Usuario) registro;
        if (buscarConId(eliminarUsuario.getId()) == null) {
            throw new MyExcepcion("4");
        } else {
            listaObjetos.remove(eliminarUsuario);
            guardarFichero();
            return "Eliminación Correcta";
        }
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
    public List<?> listar() {
        return listaObjetos;
    }

    @Override
    protected void valoresDefecto() {
        try {
            guardar(new Usuario("Erick", "123", "erickdp@hotmail.com"));
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
