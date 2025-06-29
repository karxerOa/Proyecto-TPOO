/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import DAO.EspecialidadDAO;
import DTO.EspecialidadBasicoDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author apnil
 */
public class ControladorEspecialidades {
    public ArrayList<EspecialidadBasicoDTO> especialidadBasicoDTOs = new ArrayList();
    private final EspecialidadDAO especialidadDAO;

    public ControladorEspecialidades() {
        especialidadDAO = new EspecialidadDAO();
    }
    
    public void ObtenerEspecialidadesBasicas()throws SQLException {
        especialidadBasicoDTOs = especialidadDAO.obtnerEspecialides();
    }
}
