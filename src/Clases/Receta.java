/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;

/**
 *
 * @author apnil
 */
public class Receta {
    private String IdReceta;
    private String IdDoctor;
    private LocalDate FechaEmision;
    private String FirmaDigital;

    public Receta(String IdReceta, String IdDoctor, LocalDate FechaEmision, String FirmaDigital) {
        this.IdReceta = IdReceta;
        this.IdDoctor = IdDoctor;
        this.FechaEmision = FechaEmision;
        this.FirmaDigital = FirmaDigital;
    }

    public String getIdReceta() {
        return IdReceta;
    }

    public void setIdReceta(String IdReceta) {
        this.IdReceta = IdReceta;
    }

    public String getIdDoctor() {
        return IdDoctor;
    }

    public void setIdDoctor(String IdDoctor) {
        this.IdDoctor = IdDoctor;
    }

    public LocalDate getFechaEmision() {
        return FechaEmision;
    }

    public void setFechaEmision(LocalDate FechaEmision) {
        this.FechaEmision = FechaEmision;
    }

    public String getFirmaDigital() {
        return FirmaDigital;
    }

    public void setFirmaDigital(String FirmaDigital) {
        this.FirmaDigital = FirmaDigital;
    }
    
    
}
