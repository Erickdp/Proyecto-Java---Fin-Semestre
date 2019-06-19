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
        Usuario nuevoUsuario = (Usuario) registro;
        if (listaObjetos.contains(nuevoUsuario)) {
            throw new MyExcepcion("1");
        } else {
            listaObjetos.add(nuevoUsuario);
            guardarFichero();
            return "Usuario guardado correctamente";
        }

    }

    @Override
    public String actulizar(Object registro) throws MyExcepcion {
        Usuario actualizarUsuario = (Usuario) registro;
        for (Usuario usuarioAntiguo : listaObjetos) {
            if (usuarioAntiguo.equals(actualizarUsuario)) {
                usuarioAntiguo = actualizarUsuario;
                guardarFichero();
                return "Contraseña actualizada";
            }
        }
        throw new MyExcepcion("2");
    }

    @Override
    public Object consultarConId(int indice) throws NumberFormatException, MyExcepcion {
        for (Usuario buscarId : listaObjetos) {
            if (buscarId.getId() == indice) {
                return listaObjetos.get(indice);
            }
        }
        throw new MyExcepcion("3");
    }

    @Override
    public String eliminar(int indice) throws MyExcepcion {
        try {
            Usuario borrarUsuario = (Usuario) consultarConId(indice);
            listaObjetos.remove(borrarUsuario);
            guardarFichero();
            return "Eliminación correcta";
        } catch (NumberFormatException ex) {
            throw new MyExcepcion("4");
        }
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
