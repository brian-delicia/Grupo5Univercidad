/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Alumno;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author fatimaalcaraz
 */
public class AlumnoData {
    
    private Connection conn= null;

    public AlumnoData(Conexion conexion) {
        
        this.conn= conexion.buscarConexion();
    }
    
    public void guardarAlumno (Alumno alum){
        
        String query= "INSERT INTO  alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?,?,?,?,?)";
        try {
        PreparedStatement ps = conn.prepareStatement(query);
        LocalDate fechaUtil = alum.getFechaNacimiento();
        java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaUtil);
        ps.setString(1, alum.getDni());
        ps.setString(2, alum.getApellido());
        ps.setString(3, alum.getNombre());
        ps.setDate(4, fechaSQL);
        ps.setBoolean(5, alum.isEstado());
        ps.executeUpdate();
        
        } catch (SQLException e){
            System.out.println("Error... ");
               
        }
       
    }
    
    
    public void actualizarAlumno(Alumno alum1){
    
    
        
        
        
        
    
    String query=" UPDATE alumno set dni=? , apellido=?, nombre=?, fechaNacimiento=?,  estado=? where idAlumno=? "; 
    
    

    
    
    
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
        LocalDate fechaUtil = alum1.getFechaNacimiento();
        java.sql.Date fechaSQL = java.sql.Date.valueOf(fechaUtil);
        ps.setString(1, alum1.getDni());
        ps.setString(2, alum1.getApellido());
        ps.setString(3, alum1.getNombre());
        ps.setDate(4, fechaSQL);
        ps.setBoolean(5, alum1.isEstado());
       ps.setInt(6, alum1.getIdAlumno());
        
        
        ps.executeUpdate();
       
        
        
        
        } catch (SQLException e){
            System.out.println("Error... ");
               
        }
       
    }
    
    
    
    
    
     public void ElimnarBajaLogica(Alumno alum1){
    
    
           
            
    String query=" UPDATE alumno set estado=? where idAlumno=? "; 
    
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
   
                 
        ps.setBoolean(1, alum1.isEstado());
       ps.setInt(2, alum1.getIdAlumno());
          ps.executeUpdate();
       
        
        
        
        } catch (SQLException e){
            System.out.println("Error... ");
               
        }
       
    }
     
     
     public void EliminarTotal(Alumno alum2){
     
         
                 
    String query=" Delete from alumno where idAlumno=? "; 
    
    
    try {
        PreparedStatement ps = conn.prepareStatement(query);
   
                 
       
       ps.setInt(1, alum2.getIdAlumno());
          ps.executeUpdate();
       
        
        
        
        } catch (SQLException e){
            System.out.println("Error... ");
               
        }
       
    }
     
     
     
     
     public void selectTodo() {
     
     
     //obtener todos los empleados
          
          String sql="Select * from alumno";
          
          PreparedStatement ps;
          
            
        try {
            ps = conn.prepareStatement(sql);
            
             ResultSet resultado= ps.executeQuery();
             
             while (resultado.next()){
             
             System.out.println("ID "+resultado.getInt("idAlumno"));
              System.out.println("DNI "+resultado.getString("dni"));
              System.out.println("Apellido "+resultado.getString("apellido"));
              System.out.println("Nombre "+resultado.getString("nombre"));         
             System.out.println("Fecha de Nacimiento "+resultado.getDate("fechaNacimiento"));
              System.out.println("Estado" + resultado.getBoolean("estado"));
                      
             
             
             }            
             
        
        
        } catch (SQLException ex){
         JOptionPane.showMessageDialog(null, "Error de conexion" );
        
        
        }
          
          
          // ESTO DEVUELVE UN RESULSET, es como una matriz con columnas y filas
      
         
         // resulset le pregunta si hay una fila para recorrer con el metodo next
          
         
         
         
     
     
     
     }
     
     
     
     
     public void selectEspecifico(Alumno alumno3) {
     
     
     //obtener todos los empleados
          
          String sql="Select * from alumno where idAlumno=? ";
          
          PreparedStatement ps;
          

            
        try {
            ps = conn.prepareStatement(sql);
            
             ps.setInt(1, alumno3.getIdAlumno());     
            
             ResultSet resultado= ps.executeQuery();
             
             while (resultado.next()){
             
             System.out.println("ID "+resultado.getInt("idAlumno"));
              System.out.println("DNI "+resultado.getString("dni"));
              System.out.println("Apellido "+resultado.getString("apellido"));
              System.out.println("Nombre "+resultado.getString("nombre"));         
             System.out.println("Fecha de Nacimiento "+resultado.getDate("fechaNacimiento"));
              System.out.println("Estado " + resultado.getBoolean("estado"));
           
             
             
             }            
             
        
        
        } catch (SQLException ex){
         JOptionPane.showMessageDialog(null, "Error de conexion" );
        
        
        }
          
          
          // ESTO DEVUELVE UN RESULSET, es como una matriz con columnas y filas
      
         
         // resulset le pregunta si hay una fila para recorrer con el metodo next
          
         
         
         
     
     
     
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
     
     
         
     
     
     
         
   
    
    
    
    
    

