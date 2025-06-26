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
    private int IdRecepcionista;
    private Usuario user;

    public Recepcionista() {
    }

    public Recepcionista(String nombre, String apellidoPaterno, String apellidoMaterno, int numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        
    }

    public void setUser(Usuario user) {
        this.user = user;
    }



    public Usuario getUser() {
        return user;
    }

    public int getIdRecepcionista() {
        return IdRecepcionista;
    }
    
}
