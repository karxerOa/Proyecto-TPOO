/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class Doctor extends Persona{
    private String CodigoColegiatura;
    private ArrayList<Especialidad> Especialidades;
    private ArrayList<Turno> Turnos;
    private Usuario user;

    public Doctor(String CodigoColegiatura, Usuario user, String nombre, String apellidoPaterno, String numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.CodigoColegiatura = CodigoColegiatura;
        this.Especialidades = new ArrayList<>();
        this.Turnos = new ArrayList<>();
        this.user = user;
    }

    public String getCodigoColegiatura() {
        return CodigoColegiatura;
    }

    public ArrayList<Especialidad> getEspecialidades() {
        return Especialidades;
    }

    public ArrayList<Turno> getTurnos() {
        return Turnos;
    }

    public Usuario getUser() {
        return user;
    }

    public void setTurnos(ArrayList<Turno> Turnos) {
        this.Turnos = Turnos;
    }

    public void AgregarTuno(Turno turno)throws Exception {
        if (turno == null) throw new Exception("El turno no puede ser nulo.");
        this.Turnos.add(turno);
    }
}
