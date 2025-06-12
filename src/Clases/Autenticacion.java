/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Autenticacion {
    private ArrayList<Usuario> usuarios;

    public Autenticacion(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticar(String user, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(user) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        return null;
    }
}
