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
    private ArrayList<Alergia> alergias = new ArrayList<>();
    private ArrayList<Atencion> HistorialMedico = new ArrayList<>();

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) throws Exception {
        if (grupoSanguineo == null || grupoSanguineo.isBlank()) {
            throw new Exception("El grupo sanguíneo no puede estar vacío.");
        }
        this.grupoSanguineo = grupoSanguineo;
    }

    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public ArrayList<Atencion> getHistorialMedico() {
        return HistorialMedico;
    }
    
    public void agregarAlergia(Alergia alergia) throws Exception {
        this.alergias.add(alergia);
    }
    
    public void agregarHistoriaMedico(Atencion atencion) throws Exception {
        this.HistorialMedico.add(atencion);
    }
    
}
