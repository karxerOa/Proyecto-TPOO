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
public class Paciente extends Persona{
    private int IdPaciente;
    private String grupoSanguineo;
    private ArrayList<Alergia> alergias;
    private ArrayList<Atencion> HistorialMedico;

    public Paciente(String nombre, String apellidoPaterno, String apellidoMaterno, int numDoc, String tipoDoc, String telefono, LocalDate fechaNacimiento, String genero, String correo, String direccion) {
        super(nombre, apellidoPaterno, apellidoMaterno, numDoc, tipoDoc, telefono, fechaNacimiento, genero, correo, direccion);
        this.grupoSanguineo = grupoSanguineo;
        this.alergias = new ArrayList<>();
        this.HistorialMedico = new ArrayList<>();
    }



    public int getIdPaciente() {
        return IdPaciente;
    }
    
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) throws Exception {
        if (grupoSanguineo == null || grupoSanguineo.trim().isEmpty()) {
            throw new Exception("El grupo sanguíneo no puede estar vacío.");
        }
        this.grupoSanguineo = grupoSanguineo;
    }
    
    public void agregarAlergia(Alergia alergia) throws Exception {
        this.alergias.add(alergia);
    }
    
    public void agregarHistoriaMedico(Atencion atencion) throws Exception {
        this.HistorialMedico.add(atencion);
    }
    
}
