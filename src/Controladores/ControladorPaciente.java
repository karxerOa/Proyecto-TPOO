/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Alergia;
import Clases.Paciente;
import Conexion.Conexion;
import DAO.PacienteDAO;
import DTO.PacienteDetalleDTO;
import DTO.PacienteDniDTO;
import DTO.PacienteResumenDTO;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class ControladorPaciente {
    private final PacienteDAO pacienteDAO;
    public ArrayList<Paciente> listaPacientes = new ArrayList();
    private ArrayList<PacienteDniDTO> pacientesDniDTO = new ArrayList();
    
    public ControladorPaciente() {
        this.pacienteDAO = new PacienteDAO();
    }
    
    public ArrayList<PacienteResumenDTO> obtenerPacientesEnEspera(int idDoctor) throws Exception {
        return pacienteDAO.obtenerPacientesEnEspera(idDoctor);
    }
    
    public PacienteDetalleDTO pacientePorIdBasico(int idPaciente) throws Exception{
        return pacienteDAO.pacientePorIdBasico(idPaciente);
    }
    
    public ArrayList<Alergia> obtenerAlergiasPaciente(int IdPaciente)throws Exception {
        return pacienteDAO.obtenerAlergiasPaciente(IdPaciente);
    }
    
    public void citaAtendida(int idPaciente)throws Exception {
        pacienteDAO.citaAtendida(idPaciente);
    }
    
    public String obtenerNombrePaciente(int idPaciente)throws Exception{
        return pacienteDAO.obtenerNombrePaciente(idPaciente);
    }
    public void ObternerPacientes()throws Exception{
        pacientesDniDTO = pacienteDAO.ObtenerPacientes();
    }
    public PacienteDniDTO buscarPorDniDTO(String docIdentidad) {
        for (PacienteDniDTO p : pacientesDniDTO) {
            if (p.getDocIdentidad().equals(docIdentidad)) {
                return p;
            }
        }
        return null;
    }
    
    public void obtenerPacientesDni()throws Exception{
        listaPacientes = pacienteDAO.obtenerPacientesDni();
    }
    
    public ArrayList<Paciente> FiltrarPacientes(String filtro) {
    ArrayList<Paciente> resultados = new ArrayList<>();
    for (Paciente p : listaPacientes) {
        if (p.getNumDoc().contains(filtro)) {
            resultados.add(p);
        }
    }
    return resultados;
}
    
    public int registrar_paciente(Paciente paciente) throws Exception{
        String sql = """
        INSERT INTO Paciente (Nombre, ApellidoPaterno, ApellidoMaterno, NumeroDocumento, TipoDocumento, 
                              Telefono, FechaNacimiento, Genero, Correo, Direccion, GrupoSanguineo)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)""";
        try (Connection con = Conexion.getConexion();
        PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, paciente.getNombre());
            stmt.setString(2, paciente.getApellidoPaterno());
            stmt.setString(3, paciente.getApellidoMaterno());
            stmt.setString(4, paciente.getNumDoc());
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

    public int contarPacientes() throws Exception {
        String sql = "SELECT COUNT(*) FROM Paciente";
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new Exception("No se pudo contar los pacientes.");
            }

        } catch (SQLException e) {
            throw new Exception("Error al contar pacientes: " + e.getMessage());
        }
    }
    
}
