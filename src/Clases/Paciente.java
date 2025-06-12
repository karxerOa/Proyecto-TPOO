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
    private String grupoSanguineo;
    private ArrayList<Alergia> alergias;
    private ArrayList<Visita> HistorialMedico;


    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergia> alergias) {
        this.alergias = alergias;
    }
    
    public void agregarAlergia(Alergia alergia) {
        alergias.add(alergia);
    }

    public void agregarVisita(Visita visita) {
        HistorialMedico.add(visita);
    }

    @Override
    public String mostrarInfo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
