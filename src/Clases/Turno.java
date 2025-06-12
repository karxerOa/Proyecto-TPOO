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
public class Turno {
    private String Id;
    private LocalDateTime HoraInicio;
    private LocalDateTime HoraFin;
    private String Especialidad;

    public Turno(String Id, LocalDateTime HoraInicio, LocalDateTime HoraFin, String Especialidad) {
        this.Id = Id;
        this.HoraInicio = HoraInicio;
        this.HoraFin = HoraFin;
        this.Especialidad = Especialidad;
    }

    public String getId() {
        return Id;
    }

    public LocalDateTime getHoraInicio() {
        return HoraInicio;
    }

    public LocalDateTime getHoraFin() {
        return HoraFin;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public boolean VerificarDisponibilidad(LocalDateTime fechaCita, String EspecialidadRequerida){
        return fechaCita.isAfter(HoraInicio) && fechaCita.isBefore(HoraFin) && EspecialidadRequerida.equals(Especialidad);
    }
}
