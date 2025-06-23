/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author apnil
 */
public class Diagnostico {
    private int IdDiagnostico;
    private Paciente paciente;
    private Doctor doctor;
    private String sintomas;
    private String enfermedadDiagnosticada;

    public int getIdDiagnostico() {
        return IdDiagnostico;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente)throws Exception {
        if (paciente == null) {
            throw new Exception("Debe asignar un paciente.");
        }
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor)throws Exception {
        if (doctor == null) {
            throw new Exception("Debe asignar un doctor.");
        }
        this.doctor = doctor;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas)throws Exception {
         if (sintomas == null || sintomas.isBlank()) {
            throw new Exception("Los síntomas no pueden estar vacíos.");
        }
        this.sintomas = sintomas;
    }

    public String getEnfermedadDiagnosticada() {
        return enfermedadDiagnosticada;
    }

    public void setEnfermedadDiagnosticada(String enfermedadDiagnosticada)throws Exception {
        if (enfermedadDiagnosticada == null || enfermedadDiagnosticada.isBlank()) {
            throw new Exception("La enfermedad diagnosticada no puede estar vacía.");
        }
        this.enfermedadDiagnosticada = enfermedadDiagnosticada;
    }
}
