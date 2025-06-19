/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDateTime;

/**
 *
 * @author apnil
 */
public class Visita {
    private LocalDateTime Fecha;
    private Doctor Doctor;
    private Receta receta;
    private String Diagnostico;
    private String Tratamiento;

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDateTime Fecha) {
        this.Fecha = Fecha;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor Doctor) {
        this.Doctor = Doctor;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }
}
