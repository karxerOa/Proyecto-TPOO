/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author apnil
 */
public class Conexion {
    private static final String URL = "jdbc:sqlserver://NILBER:1433;databaseName=SisHospitalTecnicas;encrypt=false;trustServerCertificate=true;";
    private static final String USER = "NilberBD";
    private static final String PASSWORD = "Nil123";

    public static Connection getConexion(){
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            if (con != null) {
                return con;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getErrorCode());
        }
        return null;
    }
}

