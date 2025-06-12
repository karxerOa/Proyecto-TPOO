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
public class Cita {
    private String IdCita;
    private LocalDateTime FechaHora;
    private Paciente paciente;
    private Doctor doctor;
    private String EspecialidadSolicitada;
    private boolean Antendida;

    public Cita(String IdCita, LocalDateTime FechaHora, Paciente paciente, Doctor doctor, String EspecialidadSolicitada, boolean Antendida) {
        this.IdCita = IdCita;
        this.FechaHora = FechaHora;
        this.paciente = paciente;
        this.doctor = doctor;
        this.EspecialidadSolicitada = EspecialidadSolicitada;
        this.Antendida = false;
    }
    
    
    public String getIdCita() {
        return IdCita;
    }

    public void setIdCita(String IdCita) {
        this.IdCita = IdCita;
    }

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(LocalDateTime FechaHora) {
        this.FechaHora = FechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getEspecialidadSolicitada() {
        return EspecialidadSolicitada;
    }

    public void setEspecialidadSolicitada(String EspecialidadSolicitada) {
        this.EspecialidadSolicitada = EspecialidadSolicitada;
    }

    public boolean isAntendida() {
        return Antendida;
    }

    public void setAntendida(boolean Antendida) {
        this.Antendida = Antendida;
    }
    public boolean verificarDisponibilidad() {
        return doctor.verificarTurnoDisponible(FechaHora) && doctor.getEspecialidad().equals(EspecialidadSolicitada);
    }
    
    public void atenderCita(String diagnostico, String tratamiento) {
        if (!Antendida) {
            Visita visita = new Visita(FechaHora, doctor, diagnostico, tratamiento);
            paciente.agregarVisita(visita);
            Antendida = true;
        }
    }
}
