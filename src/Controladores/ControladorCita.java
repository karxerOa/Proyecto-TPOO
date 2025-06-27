/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Cita;
import java.sql.Statement;
import Conexion.Conexion;
import java.sql.*;

/**
 *
 * @author USUARIO
 */
public class ControladorCita {
     public int registrarCita(Cita cita) throws Exception {
        String sql = """
            INSERT INTO Cita (DoctorID, PacienteID, FechaHora, Especialidad, Estado)
            VALUES (?, ?, ?, ?, ?)""";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, cita.getDoctorSolicitado().getIdDoctor());
            stmt.setInt(2, cita.getPacienteSolicitante().getIdPaciente());
            stmt.setTimestamp(3, Timestamp.valueOf(cita.getFechaHora()));
            stmt.setString(4, cita.getEspecialidadSolicitada());
            stmt.setString(5, "Pendiente");

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // Retorna el ID generado de la cita
            } else {
                throw new Exception("No se pudo obtener el ID generado.");
            }

        } catch (SQLException e) {
            throw new Exception("Error al registrar la cita: " + e.getMessage());
        }
    }   
    public boolean marcarCitaComoAtendida(int idCita) throws Exception {
        String sql = "UPDATE Cita SET Estado = 'Atendida' WHERE CitaID = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idCita);
            return stmt.executeUpdate() > 0;
        }
    }
}
