/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Date;

/**
 *
 * @author apnil
 */
public class Alergia {
    private String NombreAlergia;
    private String Severidad;
    private String TipoAlergia;
    private Date fechaDiagnostico;

    public Alergia(String NombreAlergia, String Severidad, String TipoAlergia, Date fechaDiagnostico) {
        this.NombreAlergia = NombreAlergia;
        this.Severidad = Severidad;
        this.TipoAlergia = TipoAlergia;
        this.fechaDiagnostico = fechaDiagnostico;
    }

    public String getNombreAlergia() {
        return NombreAlergia;
    }

    public void setNombreAlergia(String NombreAlergia) {
        this.NombreAlergia = NombreAlergia;
    }

    public String getSeveridad() {
        return Severidad;
    }

    public void setSeveridad(String serveridad) {
        this.Severidad = serveridad;
    }

    public String getTipoAlergia() {
        return TipoAlergia;
    }

    public void setTipoAlergia(String TipoAlergia) {
        this.TipoAlergia = TipoAlergia;
    }

    public Date getFechaDiagnostico() {
        return fechaDiagnostico;
    }

    public void setFechaDiagnostico(Date fechaDiagnostico) {
        this.fechaDiagnostico = fechaDiagnostico;
    }
    @Override
    public String toString() {
        return "Alergia [tipo=" + this.TipoAlergia + ", severidad=" + this.Severidad + ", fechaDiagnostico=" + this.fechaDiagnostico + "]";
    }
}
