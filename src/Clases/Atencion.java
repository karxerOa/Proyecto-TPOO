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
public class Atencion {
    private int IdAtencion;
    private Diagnostico diagnostico;
    private Receta receta;
    private LocalDateTime fecha;
    private boolean estado;

    public int getIdAtencion() {
        return IdAtencion;
    }
    
    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) throws Exception {
        this.diagnostico = diagnostico;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) throws Exception {
        this.receta = receta;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) throws Exception {
        if (fecha == null) {
            throw new Exception("Debe asignar una fecha.");
        }
        if (fecha.isAfter(LocalDateTime.now())) {
            throw new Exception("La fecha no puede estar en el futuro.");
        }
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
