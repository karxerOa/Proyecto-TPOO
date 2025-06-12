/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apnil
 */
public class Administrador extends Persona{
   private String IdAdministrador;
   private Usuario user;

    public String getIdAdministrador() {
        return IdAdministrador;
    }

    public void setIdAdministrador(String IdAdministrador) {
        this.IdAdministrador = IdAdministrador;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    @Override
    public String mostrarInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
