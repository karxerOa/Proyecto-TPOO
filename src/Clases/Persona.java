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
    protected int numDoc;
    protected String tipoDoc;
    protected String telefono;
    protected LocalDate fechaNacimiento;
    protected String genero;
    protected String correo;
    protected String direccion;

    public Persona() {
    }

    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
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

    public int getNumDoc() {
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
    private int validarDoc(int doc) {
        int length = Integer.toString(doc).length();
       if (length == 8 || length == 12) {
            throw new IllegalArgumentException("Número de documento inválido. Debe tener 8 o 12 dígitos.");
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setNumDoc(int numDoc) {
        this.numDoc = numDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public int verEdad(){
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
    public String verNombreCompleto(){
        return this.nombre + " " + this.apellidoPaterno + " " + this.apellidoMaterno;
    }
}