/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Doctor extends Persona{
    private String CodigoColegiatura;
    private String Especialidad;
    private ArrayList<Turno> Turnos = new ArrayList<>();
    private Usuario user;

    public String getCodigoColegiatura() {
        return CodigoColegiatura;
    }

    public void setCodigoColegiatura(String CodigoColegiatura) throws Exception{
        if (CodigoColegiatura == null || CodigoColegiatura.isBlank()) {
            throw new Exception("El código de colegiatura no puede estar vacío.");
        }
        this.CodigoColegiatura = CodigoColegiatura;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) throws Exception{
        if (Especialidad == null || Especialidad.isBlank()) {
            throw new Exception("La especialidad no puede estar vacía.");
        }
    this.Especialidad = Especialidad;
        this.Especialidad = Especialidad;
    }

    public ArrayList<Turno> getTurnos() {
        return Turnos;
    }

    public void setUser(Usuario user)throws Exception {
        this.user = user;
    }
    public void AgregarTuno(Turno turno)throws Exception {
        if (turno == null) throw new Exception("El turno no puede ser nulo.");
        this.Turnos.add(turno);
    }
}
