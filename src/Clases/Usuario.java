/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author apnil
 */
public class Usuario{
    private int IdUsuario;
    private String nombreUsuario;
    private String contraseña;
    private String rol;

    public Usuario(String nombreUsuario, String contraseña, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Usuario(int IdUsuario, String nombreUsuario, String contraseña, String rol) {
        this.IdUsuario = IdUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setNombreUsuario(String nombreUsuario) {
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombreUsuario = nombreUsuario;
    }

    public void setRol(String rol) {
        if (rol == null || rol.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.rol = rol;
    }

    public void setContraseña(String contraseña) throws Exception {
        if (contraseña == null || contraseña.isBlank()) {
            throw new Exception("La contraseña no puede estar vacía.");
        }
        if (contraseña.length() < 8) {
            throw new Exception("La contraseña debe tener al menos 6 caracteres.");
        }
        this.contraseña = contraseña;
    }
    public int identificarPropietario(){
        String query = "";
        String columnaID = "";

        if (this.rol.equals("Doctor")) {
            query = "SELECT DoctorID FROM Doctor WHERE UsuarioID = ?";
            columnaID = "DoctorID";
        } else if (this.rol.equals("Recepcionista")) {
            query = "SELECT RecepcionistaID FROM Recepcionista WHERE UsuarioID = ?";
            columnaID = "RecepcionistaID";
        } else if (this.rol.equals("Administrador")) {
            query = "SELECT AdministradorID FROM Administrador WHERE UsuarioID = ?";
            columnaID = "AdministradorID";
        } else {
            throw new IllegalArgumentException("Rol no válido");
        }

        try (Connection conn = Conexion.Conexion.getConexion();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, this.IdUsuario);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(columnaID);
                } else {
                    throw new RuntimeException("No se encontró un propietario para el UsuarioID: " + this.IdUsuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar al propietario", e);
        }
    }
}
