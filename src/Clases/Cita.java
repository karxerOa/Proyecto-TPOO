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
    private LocalDateTime FechaHora;
    private Paciente pacienteSolicitante;
    private Doctor doctorSolicitado;
    private String EspecialidadSolicitada;
    private boolean Antendida;

    public Cita(LocalDateTime FechaHora, Paciente pacienteSolicitante, Doctor doctorSolicitado, String EspecialidadSolicitada, boolean Antendida) {
        this.FechaHora = FechaHora;
        this.pacienteSolicitante = pacienteSolicitante;
        this.doctorSolicitado = doctorSolicitado;
        this.EspecialidadSolicitada = EspecialidadSolicitada;
        this.Antendida = Antendida;
    }

    public LocalDateTime getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(LocalDateTime FechaHora)throws Exception {
        this.FechaHora = FechaHora;
    }

    public Paciente getPacienteSolicitante() {
        return pacienteSolicitante;
    }

    public void setPacienteSolicitante(Paciente pacienteSolicitante)throws Exception {
        if (pacienteSolicitante == null) {
            throw new Exception("Debe asignar un paciente solicitante.");
        }
        this.pacienteSolicitante = pacienteSolicitante;
    }

    public Doctor getDoctorSolicitado() {
        return doctorSolicitado;
    }

    public void setDoctorSolicitado(Doctor doctorSolicitado)throws Exception {
        if (doctorSolicitado == null) {
            throw new Exception("Debe asignar un doctor solicitado.");
        }
        this.doctorSolicitado = doctorSolicitado;
    }

    public String getEspecialidadSolicitada() {
        return EspecialidadSolicitada;
    }

    public void setEspecialidadSolicitada(String EspecialidadSolicitada)throws Exception {
        if (EspecialidadSolicitada == null || EspecialidadSolicitada.isBlank()) {
            throw new Exception("La especialidad solicitada no puede estar vacía.");
        }
        this.EspecialidadSolicitada = EspecialidadSolicitada;
    }

    public void setAntendida(boolean Antendida){
        this.Antendida = Antendida;
    }
}
