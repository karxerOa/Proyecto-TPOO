/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Doctor;
import Clases.ReturnGenerico;
import Conexion.Conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
/**
 *
 * @author apnil
 */
public class ControladorDoctor {
    
    public Doctor BuscarDatosBasicosDoctorPorId(int idDoc)throws Exception{// solo DatosBasico
        Doctor doctor = null;
        try {
            Connection con = Conexion.getConexion();
            String consulta = "SELECT d.*, u.UsuarioID, u.NombreUsuario, u.Contraseña, u.Rol FROM Doctor WHERE d.DoctorID = ?;";
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setInt(1, idDoc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                doctor = new Doctor(
                    rs.getInt("DoctorID"),
                    rs.getString("Nombre"),
                    rs.getString("ApellidoPaterno"),
                    rs.getString("ApellidoMaterno"),
                    rs.getInt("NumDoc"),
                    rs.getString("TipoDoc"),
                    rs.getString("Telefono"),
                    rs.getDate("FechaNacimiento").toLocalDate(),
                    rs.getString("Genero"),
                    rs.getString("Correo"),
                    rs.getString("Direccion"),
                    rs.getString("CodigoColegiatura"));
            }
            con.close();
        } catch (SQLException  e) {
            throw new SQLException("No se encontraron datos: " + e.getMessage());
        }
        return doctor;
    }
    public int cantidadCitasPorAtender(int doctorId)throws Exception {
        int cantidad = 0;
        try {
            Connection con = Conexion.getConexion();
            String consulta = "SELECT COUNT(*) FROM Cita WHERE DoctorID = ?";
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
            throw new SQLException("No se encontraron datos: " + e.getMessage());
        }
        return cantidad;
    }
    public ReturnGenerico TurnoActual(int doctorId)throws Exception {
        String inicio = "";
        String fin = "";
        try {
            Connection con = Conexion.getConexion();
            String consulta = """
                         
                         SELECT D.DoctorID, T.HoraInicio, T.HoraFin
                         FROM Doctor D
                         JOIN Doctor_Turno DT ON D.DoctorID = DT.DoctorID
                         JOIN Turno T ON DT.TurnoID = T.TurnoID
                         WHERE D.DoctorID = ?
                         AND DT.NombreDia = DATENAME(WEEKDAY, DATEADD(HOUR, -5, GETUTCDATE()))
                         AND CAST(DATEADD(HOUR, -5, GETUTCDATE()) AS TIME) BETWEEN T.HoraInicio AND T.HoraFin;
                         """;
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Time horaInicio = rs.getTime("HoraInicio");
                Time horaFin = rs.getTime("HoraFin");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                inicio = sdf.format(horaInicio);
                fin = sdf.format(horaFin);
                return new ReturnGenerico(inicio, fin);
            }
            else{
                return new ReturnGenerico("00:00", "00:00");
            }
        } catch (SQLException e) {
            throw new SQLException("No se encontraron datos: " + e.getMessage());
        }
    }
    public String PacienteEnEspera(int doctorId)throws Exception {
        String nombrePac = "";
        try {
            Connection con = Conexion.getConexion();
            String consulta = """
                         SELECT TOP 1 P.Nombre + ' ' + P.ApellidoPaterno AS Paciente FROM Paciente P
                         JOIN Cita C ON C.PacienteID = P.PacienteID
                         JOIN Doctor D ON D.[DoctorID] = C.[DoctorID]
                         WHERE D.DoctorID = ?
                         """;
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setInt(1, doctorId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombrePac = rs.getString("Paciente");
            }
        } catch (SQLException e) {
            throw new SQLException("No se encontraron datos: " + e.getMessage());
        }
        return nombrePac;
    }
}
