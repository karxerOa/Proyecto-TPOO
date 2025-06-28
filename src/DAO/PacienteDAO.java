/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Alergia;
import java.sql.*;
import Conexion.Conexion;
import DTO.PacienteDetalleDTO;
import DTO.PacienteResumenDTO;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author apnil
 */
public class PacienteDAO {
    public String obtenerNombreProximoPaciente(int idDoctor) throws SQLException {
        String query = """
                       SELECT TOP 1 P.Nombre + ' ' + P.ApellidoPaterno + ' ' + P.ApellidoMaterno AS Nombre
                       FROM Paciente P
                       JOIN Cita C ON C.PacienteID = P.PacienteID
                       WHERE C.Estado = 'Pendiente' AND C.DoctorID = ?
                       """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("Nombre");
            } else {
                return "Sin pacientes";
            }
        }
    }
    public ArrayList<PacienteResumenDTO> obtenerPacientesEnEspera(int idDoctor) throws SQLException {
        ArrayList<PacienteResumenDTO> pacientes = new ArrayList<>();
        String sql = """
                     SELECT P.PacienteID, P.Nombre + ' ' + P.ApellidoPaterno + ' ' + P.ApellidoMaterno AS Nombre
                     FROM Paciente P
                     JOIN Cita C ON P.PacienteID = C.PacienteID
                     WHERE C.Estado = 'Pendiente' AND C.DoctorID = ?
                     """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                pacientes.add(new PacienteResumenDTO(rs.getInt("PacienteID"), rs.getString("Nombre")));
            }
        }
        return pacientes;
    }
    
    public PacienteDetalleDTO pacientePorIdBasico(int idPaciente) throws Exception{
        JOptionPane.showMessageDialog(null, idPaciente);
        PacienteDetalleDTO pac = null;
        String sql = """
                     SELECT P.Nombre + ' ' + P.ApellidoPaterno + ' ' + P.ApellidoMaterno AS Paciente,
                     P.FechaNacimiento, P.Genero, P.GrupoSanguineo
                     FROM Paciente P
                     WHERE P.PacienteID = ?
                     """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                pac = new PacienteDetalleDTO();
                pac.setNombreCompleto(rs.getString("Paciente"));
                pac.setGrupoSanguineo(rs.getString("GrupoSanguineo"));
                LocalDate fechaNac = rs.getDate("FechaNacimiento").toLocalDate();
                pac.setEdad(Period.between(fechaNac, LocalDate.now()).getYears());
                pac.setGenero(rs.getString("Genero"));
                pac.setAlergias(obtenerAlergiasPaciente(idPaciente));
            }else {
                JOptionPane.showMessageDialog(null, "No se encontró el paciente con ID: " + idPaciente);
            }
        }
        return pac;
    }
    
    public ArrayList<Alergia> obtenerAlergiasPaciente(int idPaciente)throws Exception {
        ArrayList<Alergia> obAlergias = new ArrayList();
        String sql = """
                     SELECT A.AlergiaID, A.NombreAlergia, A.TipoAlergia, A.Severidad FROM Alergia A
                     JOIN Paciente_Alergia PA ON PA.AlergiaID = A.AlergiaID
                     WHERE PA.PacienteID = ?
                     """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idPaciente);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Alergia alergia = new Alergia(rs.getInt("AlergiaID"));
                alergia.setNombreAlergia(rs.getString("NombreAlergia"));
                alergia.setTipoAlergia(rs.getString("TipoAlergia"));
                alergia.setSeveridad(rs.getString("Severidad"));
                obAlergias.add(alergia);
            }
        }
        return obAlergias;
    }
    
    public void citaAtendida(int idPaciente)throws Exception {
        String sql = """
                     UPDATE Cita
                     SET Estado = 'Atendida'
                     FROM Cita
                     WHERE PacienteID = ?
                     """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, idPaciente);
            pstmt.executeUpdate();
        }
    }
    
    public String obtenerNombrePaciente(int IdPaciente)throws Exception{
        String doctor = "";
        String sql = """
                     SELECT P.Nombre + ' ' + P.ApellidoMaterno + ' ' + P.ApellidoPaterno AS Nombre
                     FROM Paciente P
                     WHERE P.PacienteID = ?
                     """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, IdPaciente);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                doctor = rs.getString("Nombre");
            }
        }
        return doctor;
    }
}
