/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_técnicaspoo;

import java.time.LocalDateTime;

/**
 *
 * @author USUARIO
 */
public class Persona {
    private String Nombre;
    private String Apellido;
    private int DNI;
    private int Telefono;
    private LocalDateTime Fecha;
    private int Edad;
    private String Genero;
    
    public Persona(){}

    public Persona(String Nombre, String Apellido, int DNI, int Telefono, LocalDateTime Fecha, int Edad, String Genero) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DNI = DNI;
        this.Telefono = Telefono;
        this.Fecha = Fecha;
        this.Edad = Edad;
        this.Genero = Genero;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
    
    
}
