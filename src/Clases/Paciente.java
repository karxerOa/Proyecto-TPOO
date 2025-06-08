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
public class Paciente extends Persona{
    private String IdPaciente;
    private String grupoSanguineo;
    private ArrayList<Alergias> alergias;

    public Paciente(String IdPaciente, String grupoSanguineo) {
        this.IdPaciente = IdPaciente;
        this.grupoSanguineo = grupoSanguineo;
    }
    
    public String getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(String IdPaciente) {
        this.IdPaciente = IdPaciente;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<Alergias> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergias> alergias) {
        this.alergias = alergias;
    }
    
    
}
