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

    public Recepcionista(int IdRecepcionista, Usuario user, String nombre, String apellidoPaterno, String apellidoMaterno, int numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.IdRecepcionista = IdRecepcionista;
        this.user = user;
    }    
     public int getIdRecepcionista() {
        return IdRecepcionista;
    }

    public void setIdRecepcionista(int idRecepcionista) {
        this.IdRecepcionista = idRecepcionista;
    }
    public Usuario getUser() {
        return user;
    }
    public void setUser(Usuario user) {
        this.user = user;
    } 
    
}
