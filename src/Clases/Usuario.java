/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apnil
 */
public class Usuario{
    private String NombreUsuario;
    private String Contraseña;
    private String Rol;

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }
    
    public boolean esDoctor() {
        return Rol.equals("Doctor");
    }

    public boolean esAdministrador() {
        return Rol.equals("Administrador");
    }

    public boolean esRecepcionista() {
        return Rol.equals("Recepcionista");
    }

}
