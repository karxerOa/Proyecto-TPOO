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
    private int IdUsuario;
    private String nombreUsuario;
    private String contraseña;
    private String rol;

    public Usuario(String nombreUsuario, String contraseña, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Usuario(int IdUsuario, String nombreUsuario, String contraseña, String rol) {
        this.IdUsuario = IdUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }
    
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombreUsuario = nombreUsuario;
    }

    public void setRol(String rol) {
        if (rol == null || rol.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.rol = rol;
    }

    public void setContraseña(String contraseña) throws Exception {
        if (contraseña == null || contraseña.isBlank()) {
            throw new Exception("La contraseña no puede estar vacía.");
        }
        if (contraseña.length() < 8) {
            throw new Exception("La contraseña debe tener al menos 6 caracteres.");
        }
        this.contraseña = contraseña;
    }
}
