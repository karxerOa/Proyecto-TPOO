/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;


import Conexion.Conexion;
import DAO.DoctorDAO;
import DAO.PacienteDAO;
import DTO.DoctorDTO;
import DTO.DoctorSimpleDTO;
import DTO.TurnoDTO;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class ControladorDoctor {
    private final DoctorDAO doctorDAO;
    private final PacienteDAO pacienteDAO;
    
    public ControladorDoctor() {
        this.doctorDAO = new DoctorDAO();
        this.pacienteDAO = new PacienteDAO();
    }

    public int obtenerCantidadCitasPendientes(int idDoctor) throws Exception {
        return doctorDAO.obtenerCantidadCitasPendientes(idDoctor);
    }

    public TurnoDTO obtenerTurnoActual(int idDoctor) throws Exception {
        return doctorDAO.obtenerTurnoActual(idDoctor);
    }

    public String obtenerNombreDoctor(int idDoctor) throws Exception {
        return doctorDAO.obtenerNombreDoctor(idDoctor);
    }

    public String obtenerNombreProximoPaciente(int idDoctor) throws Exception {
        return pacienteDAO.obtenerNombreProximoPaciente(idDoctor);
    }
    
    public DoctorDTO buscarDatosBasicosPorId(int idDoctor)throws Exception {
        return doctorDAO.buscarDatosBasicosPorId(idDoctor);
    }
    
    public void actualizarDatosDoctor(String correo, String telefono, String direccion, int idDoctor) throws Exception {
        doctorDAO.actualizarDatos(idDoctor, correo, telefono, direccion);
    }
    
    public ArrayList<DoctorSimpleDTO> DoctoresPorFechaHora(LocalDateTime fechaHora, String Especialidad)throws SQLException{
        return doctorDAO.DoctoresPorFechaHora(fechaHora, Especialidad);
    }
    
    public void AsignarEspecialidad(int DoctorID,int EspecialidadID)throws Exception{
        String sql = "INSERT INTO Doctor_Especialidad(DoctorID,EspecialidadID) VALUES (?,?)";
         try {Connection conn = Conexion.getConexion();
            PreparedStatement Estmt = conn.prepareStatement(sql);
            Estmt.setInt(1, DoctorID);
            Estmt.setInt(2, EspecialidadID);
            Estmt.executeUpdate();       
        
        }
        catch(SQLException e){
            throw new Exception("Error al relacionar ID: "+e.getMessage());      
        }      
        
    }
}
