/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conexion;
import DTO.EspecialidadBasicoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class EspecialidadDAO {
    public ArrayList<EspecialidadBasicoDTO> obtnerEspecialides()throws SQLException{
        ArrayList<EspecialidadBasicoDTO> especialidades = new ArrayList();
        String consulta = """
                          SELECT EspecialidadID, nombre
                          FROM Especialidad E
                          """;
        try(Connection con = Conexion.getConexion();
        PreparedStatement pstmt = con.prepareStatement(consulta)){
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                EspecialidadBasicoDTO esp = new EspecialidadBasicoDTO(rs.getInt("EspecialidadID"), rs.getString("nombre"));
                especialidades.add(esp);
            }
        }
        return especialidades;
    }
}
