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
    private String nombreUsuario;
    private String contraseña;
    private String rol;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario)throws Exception {
        if (nombreUsuario == null || nombreUsuario.isBlank()) {
            throw new Exception("El nombre de usuario no puede estar vacío.");
        }
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol)throws Exception {
        if (rol == null || rol.isBlank()) {
            throw new Exception("Debe especificar el rol del usuario.");
        }
        this.rol = rol;
    }
    public boolean verificarContraseña(String ingreso) {
        return this.contraseña.equals(ingreso);
    }
}
