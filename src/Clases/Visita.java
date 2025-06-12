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
    private String Diagnostico;
    private String Tratamiento;

    public Visita(LocalDateTime Fecha, Doctor Doctor, String Diagnostico, String Tratamiento) {
        this.Fecha = Fecha;
        this.Doctor = Doctor;
        this.Diagnostico = Diagnostico;
        this.Tratamiento = Tratamiento;
    }

    public LocalDateTime getFecha() {
        return Fecha;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public String getDiagnostico() {
        return Diagnostico;
    }

    public String getTratamiento() {
        return Tratamiento;
    }

    public void setDiagnostico(String Diagnostico) {
        this.Diagnostico = Diagnostico;
    }

    public void setTratamiento(String Tratamiento) {
        this.Tratamiento = Tratamiento;
    }
}
