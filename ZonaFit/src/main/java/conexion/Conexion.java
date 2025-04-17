/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class Conexion {
    public static Connection getConexion(){
        Connection conexion = null;
        var baseDatos = "db_zona_fit";
        var url = "jdbc:mysql://localhost:3306/"+ baseDatos;
        String usuario = "root";
        String contrasenia = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
        } catch (Exception e) {
            System.out.println("Error al conectarse a la base de datos " + e.getMessage());
        }
        return conexion;
    }
    
    
    public static void main(String[] args) {
        var conexion = Conexion.getConexion();
        if(conexion != null){
            System.out.println("Conexion exitosa: " + conexion);
        }else{
            System.out.println("Error al conectarse a la base de atos x.x");
        }
    }
}
