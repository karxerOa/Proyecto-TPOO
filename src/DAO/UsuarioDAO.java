/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Clases.Usuario;
import Conexion.Conexion;
import DTO.IdentidadUsuarioDTO;
import DTO.UsuarioDTO;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class UsuarioDAO {
    
    public IdentidadUsuarioDTO validarLogin(UsuarioDTO usuario)throws SQLException {
        IdentidadUsuarioDTO user = null;
        String consulta = """
                          EXEC ObtenerRol @NombreUsuario = ?, @Contraseña = ?
                          """;
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta);
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContraseña());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new IdentidadUsuarioDTO();
                user.setIdUsuario(rs.getInt("UsuarioID"));
                user.setRol(rs.getString("Rol"));
            }
        } catch (SQLException e) {
            throw new SQLException("Error durante la validacion: " + e.getMessage());
        }
        return user;
    }
    
    public int obtenerIdDoctor(int idUsuario)throws SQLException{
        int idDoc = 0;
        String consulta = """
                          SELECT DoctorID FROM Doctor
                          WHERE UsuarioId = ?
                          """;
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)){
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                idDoc = rs.getInt("DoctorID");
            }
        }
        return idDoc;
    }
    public int RegistrarUser(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO Usuario(NombreUsuario,Contraseña,Rol)VALUES(?,?,?)";
        try (Connection conn = Conexion.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContraseña());
            pstmt.setString(3, usuario.getRol());
            
            int filas = pstmt.executeUpdate();
            
            if(filas > 0){
                ResultSet rs = pstmt.getGeneratedKeys();
                
                if(rs.next()){
                    return rs.getInt(1);
                }           
            }                             
        } catch (SQLException e) {
            throw new SQLException("Error al validar login", e);
        }
        return -1;
    }

}
