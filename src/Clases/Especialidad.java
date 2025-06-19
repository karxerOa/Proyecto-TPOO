/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apnil
 */
public class Especialidad {
    private String Nombre;
    private String Descripcion;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre)throws Exception {
        if (Nombre == null || Nombre.isBlank()) {
            throw new Exception("El nombre de la especialidad no puede estar vacío.");
        }
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) throws Exception {
        if (Descripcion == null || Descripcion.isBlank()) {
            throw new Exception("La descripción de la especialidad no puede estar vacía.");
        }
        this.Descripcion = Descripcion;
    }
    
}
