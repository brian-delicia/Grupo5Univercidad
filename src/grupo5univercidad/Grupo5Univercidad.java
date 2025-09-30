/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo5univercidad;

import java.sql.Connection;

/**
 *
 * @author Brian D
 */
public class Grupo5Univercidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Conectando con la base de datos
      Conexion con = new Conexion("jdbc:mariadb://localhost:3306/grupogp5universidad", "root","");
      con.buscarConexion();
     }
    
}
