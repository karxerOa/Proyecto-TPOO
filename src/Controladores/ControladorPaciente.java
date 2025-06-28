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
import DTO.PacienteResumenDTO;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author apnil
 */
public class ControladorPaciente {
    private final PacienteDAO pacienteDAO;
    
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
    
    //corregir
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
    public ArrayList<Paciente> mostrarPacientes() throws Exception {
    ArrayList<Paciente> lista = new ArrayList<>();
    String sql = "SELECT * FROM Paciente";

    try (Connection con = Conexion.getConexion();
         PreparedStatement stmt = con.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
                Paciente p = new Paciente();
                p.setNombre(rs.getString("Nombre"));
                p.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                p.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                p.setNumDoc(rs.getString("NumeroDocumento"));
                p.setTipoDoc(rs.getString("TipoDocumento"));
                p.setTelefono(rs.getString("Telefono"));
                p.setFechaNacimiento(rs.getDate("FechaNacimiento").toLocalDate());
                p.setGenero(rs.getString("Genero"));
                p.setCorreo(rs.getString("Correo"));
                p.setDireccion(rs.getString("Direccion"));
                p.setGrupoSanguineo(rs.getString("GrupoSanguineo"));

                lista.add(p);
            }

        } catch (SQLException e) {
            throw new Exception("Error al mostrar pacientes: " + e.getMessage());
        }

        return lista;
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
    
   public Paciente buscarPorDNI(String dni) throws Exception {
        String sql = "SELECT * FROM Paciente WHERE NumeroDocumento = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Paciente p = new Paciente();
                p.setNombre(rs.getString("Nombre"));
                p.setApellidoPaterno(rs.getString("ApellidoPaterno"));
                p.setApellidoMaterno(rs.getString("ApellidoMaterno"));
                // ... llena el resto de campos
                return p;
            }
            return null;
        }
    }
}
