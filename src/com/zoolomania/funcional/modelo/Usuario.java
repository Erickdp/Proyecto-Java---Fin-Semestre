/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import com.zoolomania.funcional.control.UtilNumeros;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa al objeto de tipo Usuario
 *
 * @author Santiago Sisalem - Erick Díaz
 */
public class Usuario implements Serializable, Comparable<Usuario> {

    private static long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private String userName;
    private String password;
    private String email;
    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private short id; //Variable que permitirá ordenar objetos según su ID

    public Usuario(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        id = UtilNumeros.getNumeroAleatorio();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public short getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "userName=" + userName + ", password=" + password + ", email=" + email + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Usuario otroUsuario) {
        if (!bandera) {
            return this.userName.compareToIgnoreCase(otroUsuario.userName);
        }
        return Short.compare(this.id, otroUsuario.id);
    }

}
