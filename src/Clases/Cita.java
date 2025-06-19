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
    private Paciente pacienteSolicitante;
    private Doctor doctorSolicitado;
    private String EspecialidadSolicitada;
    private boolean Antendida;

    public Cita(String IdCita, LocalDateTime FechaHora, Paciente pacienteSolicitante, Doctor doctorSolicitado, String EspecialidadSolicitada, boolean Antendida) {
        this.IdCita = IdCita;
        this.FechaHora = FechaHora;
        this.pacienteSolicitante = pacienteSolicitante;
        this.doctorSolicitado = doctorSolicitado;
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

    public Paciente getPacienteSolicitante() {
        return pacienteSolicitante;
    }

    public void setPacienteSolicitante(Paciente pacienteSolicitante) {
        this.pacienteSolicitante = pacienteSolicitante;
    }

    public Doctor getDoctorSolicitado() {
        return doctorSolicitado;
    }

    public void setDoctorSolicitado(Doctor doctorSolicitado) {
        this.doctorSolicitado = doctorSolicitado;
    }

    public String getEspecialidadSolicitada() {
        return EspecialidadSolicitada;
    }

    public void setEspecialidadSolicitada(String EspecialidadSolicitada) {
        this.EspecialidadSolicitada = EspecialidadSolicitada;
    }

    public boolean esAntendida() {
        return Antendida;
    }

    public void setAntendida(boolean Antendida) {
        this.Antendida = Antendida;
    }

    
//    public void atenderCita(String diagnostico, String tratamiento) {
//        if (!Antendida) {
//            Visita visita = new Visita(FechaHora, doctor, diagnostico, tratamiento, );
//            paciente.agregarVisita(visita);
//            Antendida = true;
//        }
//    }
}
