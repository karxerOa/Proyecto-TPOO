/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class TurnoDoctor {
    private ArrayList<LocalDate> DiasPorSemana;
    private LocalTime HoraIncio;
    private LocalTime HoraFin;

    public TurnoDoctor(LocalTime HoraIncio, LocalTime HoraFin) {
        this.HoraIncio = HoraIncio;
        this.HoraFin = HoraFin;
    }
    
    public ArrayList<LocalDate> getDiasPorSemana() {
        return DiasPorSemana;
    }

    public void setDiasPorSemana(ArrayList<LocalDate> DiasPorSemana) {
        this.DiasPorSemana = DiasPorSemana;
    }

    public LocalTime getHoraIncio() {
        return HoraIncio;
    }

    public void setHoraIncio(LocalTime HoraIncio) {
        this.HoraIncio = HoraIncio;
    }

    public LocalTime getHoraFin() {
        return HoraFin;
    }

    public void setHoraFin(LocalTime HoraFin) {
        this.HoraFin = HoraFin;
    }
    
}
