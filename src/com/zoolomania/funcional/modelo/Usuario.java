/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zoolomania.funcional.modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase que representa al objeto de tipo Usuario
 *
 * @author Erick Díaz
 */
public class Usuario implements Serializable, Comparable<Usuario> {

    private static final long serialVersionUID = -1L; //Constante que evita errores en la serializacion

    private String userName;
    private String password;
    private String email;
    /*
    Permite determinar a través de que atributo se ordenará la lista
     */
    public static boolean bandera = false;
    private short id;

    /**
     * Método constructor de la clase Usuario
     *
     * @param userName
     * @param password
     * @param email
     */
    public Usuario(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        id = (short) Math.floor(Math.random() * 100);
    }

    /**
     * Método contructor que permitirá validar campos de actualización tomando
     * como ID el ID antiguo
     *
     * @param userName
     * @param password
     * @param email
     * @param id
     */
    public Usuario(String userName, String password, String email, short id) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.id = id;
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
        return "Usuario{" + "userName=" + userName + ", password=" + password + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.userName);
        hash = 29 * hash + Objects.hashCode(this.email);
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
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Usuario otroUsuario) {
        if (!bandera) {
            return this.userName.compareToIgnoreCase(otroUsuario.userName);
        } else {
            return Short.compare(this.id, otroUsuario.getId());
        }
    }

}
