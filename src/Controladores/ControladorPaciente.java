/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ContenedorGenerico;
import Clases.Paciente;
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
    public int registrar_paciente(Paciente paciente) throws Exception{
        String sql = """
        INSERT INTO Paciente (Nombre, ApellidoPaterno, ApellidoMaterno, NumDocumento, TipoDocumento, 
                              Telefono, FechaNacimiento, Genero, Correo, Direccion, GrupoSanguineo)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        try (Connection con = Conexion.getConexion();
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellidoPaterno());
            stmt.setString(3, paciente.getApellidoMaterno());
            stmt.setInt(4, paciente.getNumDoc());
            stmt.setString(5, paciente.getTipoDoc());
            stmt.setString(6, paciente.getTelefono());
            stmt.setDate(7, Date.valueOf(paciente.getFechaNacimiento()));
            stmt.setString(8, paciente.getGenero());
            stmt.setString(9, paciente.getCorreo());
            stmt.setString(10, paciente.getDireccion());
            stmt.setString(11, paciente.getGrupoSanguineo());

             stmt.executeUpdate();

            // Obtener el ID generado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // ID del paciente insertado
                } else {
                    throw new Exception("No se pudo obtener el ID del paciente insertado.");
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error al registrar paciente: " + e.getMessage());
        }
    }
}
