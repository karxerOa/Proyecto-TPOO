/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import DAO.AtencionDAO;
import DTO.HistorialMedicoDTO;
import Estructuras.ListaCircularDoble;
import java.sql.SQLException;
/**
 *
 * @author apnil
 */
public class ControladorAtencion {
    private final AtencionDAO atencionDAO;

    public ControladorAtencion() {
        this.atencionDAO = new AtencionDAO();
    }
    
    public void Registrar( int idPaciente, int idDiagnostico, int idReceta)throws Exception{
        atencionDAO.Registrar(idPaciente, idDiagnostico, idReceta);
    }
    
    public ListaCircularDoble<HistorialMedicoDTO> ObtenerHistorial(int idPaciente)throws SQLException{
        return atencionDAO.ObtenerHistorial(idPaciente);
    }
}
