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
import java.time.LocalDate;
import java.util.Date;
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
    
}
