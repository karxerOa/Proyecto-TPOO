/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;

/**
 *
 * @author apnil
 */
public class Recepcionista extends Persona{
    private Usuario user;

    public Recepcionista(Usuario user, String nombre, String apellidoPaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }
}
