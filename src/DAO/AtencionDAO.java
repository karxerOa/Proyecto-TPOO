/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import DTO.HistorialMedicoDTO;
import Estructuras.ListaCircularDoble;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class AtencionDAO {
    public ListaCircularDoble<HistorialMedicoDTO> ObtenerHistorial(int idPaciente) throws SQLException{
        ListaCircularDoble<HistorialMedicoDTO> historial = new ListaCircularDoble();
        String consulta = """
                          EXEC GenerarHistorialMedico @idPaciente = ?
                          """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)){
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                HistorialMedicoDTO hist = new HistorialMedicoDTO();
                hist.setAtencionID(rs.getInt("AtencionID"));
                hist.setNombrePaciente(rs.getString("NombrePaciente"));
                hist.setNombreDoctor(rs.getString("NombreDoctor"));
                hist.setSintomas("Sintomas");
                hist.setEnfermedadDiagnosticada("EnfermedadDiagnostica");
                hist.setRecomendaciones("Recomendaciones");
                hist.setMedicamentosDosis("MedicamentosDosis");
                hist.setFecha("Fecha");
                historial.agregarFinal(hist);
            }
        }
        return historial;
    }
}
