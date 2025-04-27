/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_técnicaspoo;

/**
 *
 * @author William
 */
public class Usuario {
    
    private String User;
    private String Contraseña;
    private String Rol;
    
    
    public Usuario(String User, String Contraseña, String Rol) {
        this.User = User;
        this.Contraseña = Contraseña;
        this.Rol = Rol;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String User) {
        this.User = User;
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
    
    public Boolean Verificar_Usuario(String User, String Contraseña){
        try{
           return this.User == User && this.Contraseña == Contraseña;
        }
        catch(NullPointerException e){
            System.out.println("Usuario o contraseña incorrecto");
            return false;
        }

    }
}
