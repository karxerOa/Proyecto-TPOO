/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDateTime;

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
    protected LocalDateTime fechaNacimiento;
    protected int edad;
    protected String genero;
    protected String correo;
    protected String direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
        if (nombre == null || nombre.isBlank()) {
            throw new Exception("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) throws Exception {
        if (apellidoPaterno == null || apellidoPaterno.isBlank()) {
            throw new Exception("El apellido paterno no puede estar vacío.");
        }
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) throws Exception {
        if (apellidoMaterno == null || apellidoMaterno.isBlank()) {
            throw new Exception("El apellido materno no puede estar vacío.");
        }
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) throws Exception {
        if (numDoc == null || numDoc.isBlank()) {
            throw new Exception("El número de documento no puede estar vacío.");
        }
        this.numDoc = numDoc;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) throws Exception {
        if (tipoDoc == null || tipoDoc.isBlank()) {
            throw new Exception("Debe especificar el tipo de documento.");
        }
        this.tipoDoc = tipoDoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws Exception {
        if (telefono == null || telefono.isBlank()) {
            throw new Exception("El número de teléfono no puede estar vacío.");
        }
        this.telefono = telefono;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) throws Exception {
        if (fechaNacimiento == null) {
            throw new Exception("Debe ingresar la fecha de nacimiento.");
        }
        if (fechaNacimiento.isAfter(LocalDateTime.now())) {
            throw new Exception("La fecha de nacimiento no puede estar en el futuro.");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws Exception {
        if (edad < 0 || edad > 120) {
            throw new Exception("Edad no válida.");
        }
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) throws Exception {
        if (genero == null || genero.isBlank()) {
            throw new Exception("Debe especificar el género.");
        }
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) throws Exception {
        if (correo == null || correo.isBlank()) {
            throw new Exception("El correo no puede estar vacío.");
        }
        if (!correo.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$")) {
            throw new Exception("Correo electrónico inválido.");
        }
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) throws Exception {
        if (direccion == null || direccion.isBlank()) {
            throw new Exception("La dirección no puede estar vacía.");
        }
        this.direccion = direccion;
    }
    public String verNombreCompleto() {
        return nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }
}

   