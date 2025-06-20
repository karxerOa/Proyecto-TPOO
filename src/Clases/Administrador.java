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
public class Administrador extends Persona{
    private int IdAdministrador;
    private Usuario user;
    private int nivelAcceso;

    public Administrador(String nombre, String apellidoPaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion, Usuario user, int nivelAcceso) {
        super(nombre, apellidoPaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.user = user;
        this.nivelAcceso = validarNivelAcceso(nivelAcceso);
    }

    public void setIdAdministrador(int IdAdministrador) {
        this.IdAdministrador = IdAdministrador;
    }
    
    public Usuario getUser() {
        return user;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    private int validarNivelAcceso(int nivel){
        if (nivel < 1 || nivel > 3) {
            throw new IllegalArgumentException("Numero invalido, debe de estar en el rango 1-3.");
        }
        return  nivel;
    }
}
