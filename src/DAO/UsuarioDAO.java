/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

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
        try(Connection con = Conexion.getConexion();
            PreparedStatement pstmt = con.prepareStatement(consulta)){
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContraseña());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new IdentidadUsuarioDTO();
                user.setIdUsuario(rs.getInt("UsuarioID"));
                user.setRol(rs.getString("Rol"));
            }
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
}
