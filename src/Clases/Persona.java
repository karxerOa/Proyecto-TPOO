/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author USUARIO
 */
public abstract class Persona {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected String numDoc;
    protected String tipoDoc;
    protected String telefono;
    protected LocalDate fechaNacimiento;
    protected String genero;
    protected String correo;
    protected String direccion;

    public Persona(String nombre, String apellidoPaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        this.nombre = validarTexto(nombre, "El nombre");
        this.apellidoPaterno = validarTexto(apellidoPaterno, "El Apellido Paterno");
        this.apellidoMaterno = validarTexto(apellidoMaterno, "El Apellido Materno");
        this.numDoc = validarDoc(numDoc);
        this.tipoDoc = tipoDoc;
        this.telefono = telefono;
        this.fechaNacimiento = validarFecha(fechaNacimiento);
        this.genero = genero;
        this.correo = validarCorreo(correo);
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = validarCorreo(correo);
    }

    //sets usados solo para actualizar info?
    public void setDireccion(String direccion) {
        this.direccion = validarTexto(direccion, "La direccion");
    }
    
    private String validarTexto(String valor, String dato) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(dato + " no puede estar vacío.");
        }
        return valor.trim();
    }
    
    //validaciones (srirven para seters y constructor)
    private String validarDoc(String doc) {
        if (doc == null || doc.length() != 12 || doc.length() != 8) {
            throw new IllegalArgumentException("Número de documento inválido.");
        }
        return doc;
    }
    
    private String validarCorreo(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("Correo inválido.");
        }
        return correo;
    }
    
    private LocalDate validarFecha(LocalDate fecha) {
        if (fecha == null || fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento inválida.");
        }
        return fecha;
    }
    
    public int verEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
    public String verNombreCompleto(){
        return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }
}