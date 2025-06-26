/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ContenedorGenerico;
import Clases.Usuario;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class ControladorUsuarios {

    public ControladorUsuarios() {

//        LlenarLista();
    }
    
    
//    private void LlenarLista() {
//        String sql = "SELECT UsuarioID, NombreUsuario, Contraseña, Rol FROM Usuario";
//        UsuariosRegistrados.clear();
//        try (Connection conn = Conexion.Conexion.getConexion();
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//
//            while (rs.next()) {
//                int id = rs.getInt("UsuarioID");
//                String usuario = rs.getString("NombreUsuario");
//                String contraseña = rs.getString("Contraseña");
//                String rol = rs.getString("Rol");
//                Usuario user = new Usuario(id, usuario, contraseña, rol);
//                UsuariosRegistrados.add(user);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException("Error al cargar usuarios desde la base de datos", e);
//        }
//    }
    
    public ContenedorGenerico login(String nombreUsuario, String contraseña) {
        String sql = "SELECT * FROM Usuario WHERE NombreUsuario = ? AND Contraseña = ?";
        try (Connection conn = Conexion.Conexion.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            pstmt.setString(2, contraseña);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("UsuarioID");
                String rol = rs.getString("Rol");
                Usuario user = new Usuario(id, nombreUsuario, contraseña, rol);
                return new ContenedorGenerico(true, user);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al validar login");
        }
        return new ContenedorGenerico(false, null);
    }
    
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
