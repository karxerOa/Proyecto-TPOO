/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import Conexion.Conexion;
import DTO.DoctorDTO;
import DTO.EspecialidadDTO;
import DTO.TurnoDTO;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class DoctorDAO {
    public int obtenerCantidadCitasPendientes(int idDoctor) throws SQLException {
        String consulta = """
                       SELECT COUNT(*) AS Total
                       FROM Cita
                       WHERE Estado = 'Pendiente' AND DoctorID = ?
                       """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)) {
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            } else {
                return 0;
            }
        }
    }

    public TurnoDTO obtenerTurnoActual(int idDoctor) throws SQLException {
        String consulta = """
                       SELECT T.HoraInicio, T.HoraFin
                       FROM Doctor D
                       JOIN Doctor_Turno DT ON D.DoctorID = DT.DoctorID
                       JOIN Turno T ON DT.TurnoID = T.TurnoID
                       WHERE D.DoctorID = ?
                       AND DT.NombreDia = DATENAME(WEEKDAY, DATEADD(HOUR, -5, GETUTCDATE()))
                       AND CAST(DATEADD(HOUR, -5, GETUTCDATE()) AS TIME) BETWEEN T.HoraInicio AND T.HoraFin;
                       """;

        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)) {
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String inicio = rs.getString("HoraInicio");
                String fin = rs.getString("HoraFin");
                return new TurnoDTO(inicio, fin);
            } else {
                return new TurnoDTO("N/A", "N/A");
            }
        }
    }

    public String obtenerNombreDoctor(int idDoctor) throws SQLException {
        String consulta = """
                       SELECT Nombre + ' ' + ApellidoPaterno + ' ' + ApellidoMaterno AS Nombre
                       FROM Doctor
                       WHERE DoctorID = ?
                       """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)) {
            pstmt.setInt(1, idDoctor);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("Nombre");
            } else {
                return "Desconocido";
            }
        }
    }
    
    public DoctorDTO buscarDatosBasicosPorId(int idDoctor) throws SQLException {
        String consulta = """
            SELECT D.DoctorID, D.Nombre, D.ApellidoPaterno, D.ApellidoMaterno,
                   D.Genero, D.FechaNacimiento, D.Telefono, D.Correo, D.Direccion, D.CodigoColegiatura, D.NumeroDocumento
            FROM Doctor D
            WHERE D.DoctorID = ?
        """;
        try (Connection con = Conexion.getConexion();
            PreparedStatement stmt = con.prepareStatement(consulta)) {
            stmt.setInt(1, idDoctor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int idDoc = rs.getInt("DoctorID");
                String nombreCompleto = rs.getString("Nombre") + " " + rs.getString("ApellidoPaterno") + " " + rs.getString("ApellidoMaterno");
                LocalDate fechaNac = rs.getDate("FechaNacimiento").toLocalDate();
                int edad = Period.between(fechaNac, LocalDate.now()).getYears();
                String genero = rs.getString("Genero");
                String correo = rs.getString("Correo");
                String direccion = rs.getString("Direccion");
                String telefono = rs.getString("Telefono");
                String codColegiatura = rs.getString("CodigoColegiatura");
                String numdoc = rs.getString("NumeroDocumento");
                ArrayList<EspecialidadDTO> especialidades = obtenerEspecialidadesNombres(idDoctor, con);
                
                DoctorDTO doc =  new DoctorDTO();
                doc.setNombreCompleto(nombreCompleto);
                doc.setEdad(edad);
                doc.setGenero(genero);
                doc.setCorreo(correo);
                doc.setDireccion(direccion);
                doc.setTelefono(telefono);
                doc.setCodigoColegiatura(codColegiatura);
                doc.setDocIdentidad(numdoc);
                doc.setEspecialidades(especialidades);
                return doc;
            }
        }
        return null;
    }
    
    private ArrayList<EspecialidadDTO> obtenerEspecialidadesNombres(int idDoctor, Connection con) throws SQLException {
        ArrayList<EspecialidadDTO> especialidades = new ArrayList<>();
        String consulta = """
                     SELECT E.nombre, E.descripcion
                     FROM Especialidad E
                     JOIN Doctor_Especialidad DE ON DE.EspecialidadID = E.EspecialidadID
                     WHERE DE.DoctorID = ?
                     """;
        try (PreparedStatement stmt = con.prepareStatement(consulta)) {
            stmt.setInt(1, idDoctor);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                especialidades.add(new EspecialidadDTO(nombre, descripcion));
            }
        }
        return especialidades;
    }

    
    public void actualizarDatos(int id, String correo, String telefono, String direccion) throws SQLException {
        String consulta = """
            UPDATE Doctor
            SET Telefono = ?, Correo = ?, Direccion = ?
            WHERE DoctorID = ?
        """;
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(consulta)) {
            stmt.setString(1, telefono);
            stmt.setString(2, correo);
            stmt.setString(3, direccion);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        }
    }
}
