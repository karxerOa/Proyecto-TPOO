/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Usuario;
import DAO.UsuarioDAO;
import DTO.IdentidadUsuarioDTO;
import DTO.UsuarioDTO;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class ControladorUsuarios {

    private final UsuarioDAO usuarioDAO;
    public ControladorUsuarios() {
        usuarioDAO = new UsuarioDAO();
    }
    
    public IdentidadUsuarioDTO validarLogin(UsuarioDTO usuario)throws SQLException{
        return usuarioDAO.validarLogin(usuario);
    }
    
    public int obtenerIdDoctor(int idUsuario)throws SQLException {
        return usuarioDAO.obtenerIdDoctor(idUsuario);
    }
    
// Corregir
    
    public int RegistrarUser(Usuario usuario) throws Exception{
      
        String sql = "INSERT INTO Usuario(NombreUsuario,Contraseña,Rol)VALUES(?,?,?)";
        
        try (Connection conn = Conexion.Conexion.getConexion();
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
                                  
        } catch (SQLException e) 
        {
            e.printStackTrace();
            throw new RuntimeException("Error al validar login", e);
        }
        return -1;
    }
}
