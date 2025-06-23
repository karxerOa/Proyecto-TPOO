/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Doctor;
import Clases.Usuario;
import Conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author apnil
 */
public class ControladorDoctor {
    
    public Doctor buscarDoctorPorNombre(int idDoc) {
        Doctor doctor = null;
        try {
            Connection con = Conexion.getConexion();
            String consulta = "SELECT d.*, u.UsuarioID, u.NombreUsuario, u.Contraseña, u.Rol FROM Doctor d JOIN Usuario u ON d.UsuarioID = u.UsuarioID WHERE d.DoctorID = ?;";
            PreparedStatement stmt = con.prepareStatement(consulta);
            stmt.setInt(1, idDoc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el doctor: " + e.getMessage());// tengo q cambiar q solo mande error
        }
        return doctor;
}
}
