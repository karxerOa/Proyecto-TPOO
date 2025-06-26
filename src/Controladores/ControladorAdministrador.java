/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.Doctor;
import Clases.Especialidad;
import Clases.Recepcionista;
import Conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.FocusManager;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class ControladorAdministrador {
    
    
    public int Agregar_Doctor(Doctor doctor) throws Exception{
        String sql = "INSERT INTO Doctor(Nombre,ApellidoPaterno,ApellidoMaterno,NumeroDocumento,TipoDocumento,FechaNacimiento,Genero,Telefono,Correo,Direccion,CodigoColegiatura,UsuarioID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {Connection conn = Conexion.getConexion();
        PreparedStatement Dstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        Dstmt.setString(1, doctor.getNombre());
        Dstmt.setString(2, doctor.getApellidoPaterno());
        Dstmt.setString(3, doctor.getApellidoMaterno());
        Dstmt.setInt(4, doctor.getNumDoc());
        Dstmt.setString(5, doctor.getTipoDoc());
        Dstmt.setDate(6, java.sql.Date.valueOf(doctor.getFechaNacimiento()));
        Dstmt.setString(7, doctor.getGenero());
        Dstmt.setString(8, doctor.getTelefono());
        Dstmt.setString(9, doctor.getCorreo());
        Dstmt.setString(10, doctor.getDireccion());
        Dstmt.setString(11, doctor.getCodigoColegiatura());                
        Dstmt.setInt(12, doctor.getUser().getIdUsuario());
        
        
        int filas = Dstmt.executeUpdate();    
            if(filas>0){
                ResultSet rs = Dstmt.getGeneratedKeys();
                if(rs.next()){
                    return rs.getInt(1);
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            throw new Exception("Error al registrar doctor: "+e.getMessage());      
        }    
        return -1;
    }
    
    
    
    
    
    
    
    //Agregar Recepcionsita
    public void Agregar_Repcionista(Recepcionista recepcionista) throws Exception{
        String sql = "INSERT INTO Recepcionista(Nombre,ApellidoPaterno,ApellidoMaterno,NumeroDocumento,TipoDocumento,FechaNacimiento,Genero,Telefono,Correo,UsuarioID) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {Connection conn = Conexion.getConexion();
        PreparedStatement Dstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        Dstmt.setString(1, recepcionista.getNombre());
        Dstmt.setString(2, recepcionista.getApellidoPaterno());
        Dstmt.setString(3, recepcionista.getApellidoMaterno());
        Dstmt.setInt(4, recepcionista.getNumDoc());
        Dstmt.setString(5, recepcionista.getTipoDoc());
        Dstmt.setDate(6, java.sql.Date.valueOf(recepcionista.getFechaNacimiento()));
        Dstmt.setString(7, recepcionista.getGenero());
        Dstmt.setString(8, recepcionista.getTelefono());
        Dstmt.setString(9, recepcionista.getCorreo());
        Dstmt.setString(10, recepcionista.getDireccion());                    
        Dstmt.setInt(11, recepcionista.getUser().getIdUsuario()); 
        Dstmt.executeUpdate();    
     
        }
        catch(SQLException e){
            e.printStackTrace();
            throw new Exception("Error al registrar doctor: "+e.getMessage());      
        }    
       
    }
    //Gestionar Turnos
    public void Gestionar_Turnos(){
    
    }
    //Agregar Especialiada
    public void Agregar_Especialidades(Especialidad Especialidades)throws Exception{
        String sql = "INSERT INTO Especialidad(nombre,descripcion) VALUES(?,?)";
        try {Connection conn = Conexion.getConexion();
            PreparedStatement Estmt = conn.prepareStatement(sql);
            Estmt.setString(1, Especialidades.getNombre());
            Estmt.setString(2, Especialidades.getDescripcion());
            Estmt.executeUpdate();       
        
        }
        catch(SQLException e){
            throw new Exception("Error la insertar datos: "+e.getMessage());      
        }      
    }
    
    public ArrayList<Especialidad> Obtener_Especilidad(){
        ArrayList<Especialidad> ListaEspecialidad = new ArrayList();
        
        String sql = "SELECT EspecialidadID, nombre,descripcion From Especialidad";
        
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement Astmt = conn.prepareStatement(sql);
            ResultSet rs = Astmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("EspecialidadID");
                String Nombre = rs.getString("nombre");
                Especialidad esp = new Especialidad(id,Nombre);
                ListaEspecialidad.add(new Especialidad(id, Nombre));               
            }                                                                               
        }
        catch(SQLException e){
            System.out.println("Error al cargar especialidad: "+e.getMessage());       
        }     
        return ListaEspecialidad;
    
    }
    public ArrayList<Especialidad> Obtener_Especilidad_Completo(){
        ArrayList<Especialidad> ListaEspecialidad = new ArrayList();
        
        String sql = "SELECT EspecialidadID, nombre,descripcion From Especialidad";
        
        try {
            Connection conn = Conexion.getConexion();
            PreparedStatement Astmt = conn.prepareStatement(sql);
            ResultSet rs = Astmt.executeQuery();

            while(rs.next()){              
                String Nombre = rs.getString("nombre");
                String Descripcion = rs.getString("descripcion");
                
                Especialidad esp = new Especialidad(Nombre,Descripcion);                
                ListaEspecialidad.add(new Especialidad(Nombre, Descripcion));               
            }                                                                               
        }
        catch(SQLException e){
            System.out.println("Error al cargar especialidad: "+e.getMessage());       
        }     
        return ListaEspecialidad;
    
    }
    
    
    public static String determinarTipoDocumento(int numeroDocumento) throws Exception {
        String numero = String.valueOf(numeroDocumento);
        try{
            int longitud = numero.trim().length();

            switch (longitud) {
                case 8:
                    return "DNI";
                case 12:
                    return "Carné de extranjería";
                default:
                    return "Desconocido";
                }
        }
        catch (Exception e) {
            throw new Exception("Error al validar tipo de documento: "+e.getMessage());    
        }
        
    }


    
}
