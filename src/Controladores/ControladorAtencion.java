/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Conexion.Conexion;
import DAO.AtencionDAO;
import DTO.HistorialMedicoDTO;
import Estructuras.ListaCircularDoble;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author apnil
 */
public class ControladorAtencion {
    private AtencionDAO atencionDAO;

    public ControladorAtencion() {
        this.atencionDAO = new AtencionDAO();
    }
    
    
    public void Registrar( int idPaciente, int idDiagnostico, int idReceta)throws Exception{
        try {
            Connection con = Conexion.getConexion();
            String consulta = """
                INSERT INTO Atencion (PacienteID, DiagnosticoID, RecetaID, Fecha)
                VALUES (?, ?, ?, CAST(GETDATE() AS DATE))
            """;
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setInt(1, idPaciente);
            pstmt.setInt(2, idDiagnostico);
            pstmt.setInt(3, idReceta);

            pstmt.executeUpdate();

            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al registrar los datos: " + e.getMessage());
        }
    }
    
    public ListaCircularDoble<HistorialMedicoDTO> ObtenerHistorial(int idPaciente)throws SQLException{
        return atencionDAO.ObtenerHistorial(idPaciente);
    }
}
