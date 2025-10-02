
package Modelo;

import Persistencia.AlumnoData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.Month;


public class Grupo5Universidad {


    public static void main(String[] args) {
        // Conectando con la base de datos
      Conexion con = new Conexion("jdbc:mariadb://localhost:3306/grupogp5universidad", "root","");
      
   
      
      
      con.buscarConexion();
     
 
    LocalDate fecha1=LocalDate.of(2000,8,8);
    
    Alumno alumnito=new Alumno(3,"37845223","Alcaraz", "Fatima",fecha1,false );
        
    AlumnoData alumno1=new AlumnoData(con);

   
           /*
    alumno1.guardarAlumno(alumnito);
     
     */
    
   
/*
   
    LocalDate fecha2=LocalDate.of(1900,9,15);
    
    Alumno alumnito2=new Alumno(4,"37845223","Deli", "Brian",fecha2,true );
        
    AlumnoData alumno2=new AlumnoData(con);
               
    
    alumno2.actualizarAlumno(alumnito2);
    */



// alumno1.ElimnarBajaLogica(alumnito);


// alumno1.EliminarTotal(alumnito);


// alumno1.select();

alumno1.selectEspecifico(alumnito);




   
    
    
}
}