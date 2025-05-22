/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploejerciciounidad9.logica;

import java.sql.*;
import ejemploejerciciounidad9.modelos.coches;

/**
 *
 * @author Franc
 */
public class bbdd {
    final private String driver = "com.mysql.cj.jdbc.Driver";
    public bbdd(){
    }
    public int altascoches(String matricula, String modelo){
        int contadorAltas = 0;
        try {
            coches coche = new coches(matricula, modelo);
            Class.forName(driver);
            Connection conector = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","curro","");
            String query = "Insert into concesionario values(?,?)";
            PreparedStatement sentencia = conector.prepareStatement(query);
            sentencia.setString(1, coche.getMatricula());
            sentencia.setString(2, coche.getModelo());
            contadorAltas = sentencia.executeUpdate();
            sentencia.close();
            conector.close();
            return contadorAltas;
            
            
        } catch (Exception e) {
            return 0;
        }
    }
    public int bajasCoches(String matricula){
        int contadorBajas = 0;
        try {
            Class.forName(driver);
            Connection conector = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","curro","");
            String query = "delete from concesionario WHERE matricula = ?";
            PreparedStatement sentencia = conector.prepareStatement(query);
            sentencia.setString(1, matricula);
            contadorBajas = sentencia.executeUpdate();
            sentencia.close();
            conector.close();
            return contadorBajas;
            
            
        } catch (Exception e) {
            return 0;
        }
    }
    public String mostrar(){
        String contenidoConsulta = "";
            try {
            Class.forName(driver);
            Connection conector = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","curro","");
            String query = "Select * from concesionario";
            Statement sentencia = conector.createStatement();
            ResultSet resultado = sentencia.executeQuery(query);
            while(resultado.next()){
                contenidoConsulta = contenidoConsulta + (resultado.getString(1) + "\t" + resultado.getString(2) + "\n");
                
            }
            
            sentencia.close();
            conector.close();
            return contenidoConsulta;
            
            
        } catch (Exception e) {
            return e.getMessage();
        }
    
    }
    public String busqueda(String modelo){
        String contenidoBusqueda = "";
        
        try{
            Class.forName(driver);
            Connection conector = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "curro", "");
            String query = "Select * from concesionario where modelo = ?";
            PreparedStatement sentencia  = conector.prepareStatement(query);
            sentencia.setString(1, modelo);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                contenidoBusqueda = contenidoBusqueda +"matricula = " + rs.getString(1)+ "\t" + "modelo = " + rs.getString(2)+  "\n";
                
            }
            sentencia.close();
            conector.close();
            return contenidoBusqueda;
        }
        catch(Exception e){
            return "no se ha encontrado nada" ;
        }
    }
    public int modificar(String matricula, String modelo ){
            int contadorModificar = 0;
            try {
            coches coche = new coches(matricula, modelo);
            Class.forName(driver);
            Connection conector = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","curro","");
                String query = "UPDATE concesionario SET modelo = ? WHERE matricula = ?";
            PreparedStatement sentencia = conector.prepareStatement(query);
            sentencia.setString(1, coche.getModelo());
            sentencia.setString(2, coche.getMatricula());
            contadorModificar = sentencia.executeUpdate();
            sentencia.close();
            conector.close();
            return contadorModificar;
            
            
        } catch (Exception e) {
            return 0;
        }
    }
    
}
