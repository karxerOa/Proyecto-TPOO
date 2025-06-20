/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ReturnGenerico;
import Clases.Usuario;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class ControladorUsuarios {
    private ArrayList<Usuario> UsuariosRegistrados;

    public ControladorUsuarios() {
        UsuariosRegistrados = new ArrayList<>();
        LlenarLista();
    }
    
    
    private void LlenarLista(){
        try {
            Connection Conect = Conexion.Conexion.getConexion();
            Statement stmt = Conect.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Usuario");
            while (rs.next()) {
                int id = rs.getInt("UsuarioID");
                String usuario = rs.getString("NombreUsuario");
                String contraseña = rs.getString("Contraseña");
                String rol = rs.getString("Rol");
                Usuario user = new Usuario(id, usuario, contraseña, rol);
                UsuariosRegistrados.add(user);
            }
            
        } catch (SQLException  e) {
            throw new RuntimeException("Error al cargar usuarios desde la base de datos", e);
        } 
    }
    public ReturnGenerico login(String nombreUsuario, String contraseña){
        for(Usuario u : UsuariosRegistrados){
            if (u.getNombreUsuario().equals(nombreUsuario) && u.getContraseña().equals(contraseña)) {
                return new ReturnGenerico<>(true, u.getRol());
            }
        }
        return null;
    }
}
