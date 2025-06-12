/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Doctor extends Usuario{
    private String CodigoColegiatura;
    private String Especialidad;
    private ArrayList<Turno> Turnos;
    private Usuario user;

    public String getCodigoColegiatura() {
        return CodigoColegiatura;
    }

    public void setCodigoColegiatura(String CodigoColegiatura) {
        this.CodigoColegiatura = CodigoColegiatura;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public ArrayList<Turno> getTurnos() {
        return Turnos;
    }

    public void setTurnos(ArrayList<Turno> Turnos) {
        this.Turnos = Turnos;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public boolean verificarTurnoDisponible(LocalDateTime fechaHora) {
        for (Turno turno : Turnos) {
            if (turno.getHoraInicio().isBefore(fechaHora) && turno.getHoraFin().isAfter(fechaHora)) {
                return true;
            }
        }
        return false;
    }
}
