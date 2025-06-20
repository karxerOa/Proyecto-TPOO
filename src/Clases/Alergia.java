/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
/**
 *
 * @author apnil
 */
public class Alergia {
    private int IdAlergia;
    private String NombreAlergia;
    private String Severidad;
    private String TipoAlergia;

    public Alergia(String NombreAlergia, String Severidad, String TipoAlergia) {
        this.NombreAlergia = NombreAlergia;
        this.Severidad = Severidad;
        this.TipoAlergia = TipoAlergia;
    }

    public void setNombreAlergia(String NombreAlergia)throws Exception {
        if (NombreAlergia == null || NombreAlergia.isBlank()) {
            throw new Exception("El nombre de la alergia no puede estar vacío.");
        }
        this.NombreAlergia = NombreAlergia;
    }

    public String getSeveridad() {
        return Severidad;
    }

    public void setSeveridad(String severidad)throws Exception {
        if (severidad == null || severidad.isBlank()) {
            throw new Exception("La severidad no puede estar vacía.");
        }
        this.Severidad = severidad;
    }

    public String getTipoAlergia() {
        return TipoAlergia;
    }

    public void setTipoAlergia(String TipoAlergia)throws Exception {
        if (TipoAlergia == null || TipoAlergia.isBlank()) {
            throw new Exception("El tipo de alergia no puede estar vacío.");
        }
        this.TipoAlergia = TipoAlergia;
    }
}
