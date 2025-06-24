/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ContenedorGenerico;
import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class ControladorPaciente {
    public ArrayList<ContenedorGenerico<Integer, String, Void, Void>> ObtenerListaPacientesEnEspera(int IdDoc)throws Exception {
        ArrayList<ContenedorGenerico<Integer, String, Void, Void>> pacientes = new ArrayList<>();
        try {
            Connection con = Conexion.getConexion();
            String consulta = """
                              SELECT D.Nombre, P.PacienteID ,P.Nombre + ' ' + P.ApellidoPaterno + ' ' + P.ApellidoMaterno AS Paciente
                              FROM Paciente P
                              JOIN Cita C ON C.PacienteID = P.PacienteID
                              JOIN Doctor D ON D.DoctorID = C.DoctorID
                              WHERE C.Estado = 'Pendiente' AND D.DoctorID = ?
                              """;
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setInt(1, IdDoc);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int idPaciente = rs.getInt("PacienteID");
                String nombrePaciente = rs.getString("Paciente");
                pacientes.add(new ContenedorGenerico(idPaciente, nombrePaciente));
            }
        } catch (SQLException e) {
            throw new Exception("Error al cargar los pacientes desde la base de datos");
        }
        return pacientes;
    }
}
