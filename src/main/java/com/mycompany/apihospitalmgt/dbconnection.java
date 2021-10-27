/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
package com.mycompany.apihospitalmgt;
import java.sql.Connection;
import java.sql.DriverManager;
public class dbconnection {

    private dbconnection(){} //private cosntructor
    private static Connection con = null;
    
   static 
   {
        try
        {
          Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalmgtsystem","root","root");
            
        }catch(Exception e){
          e.printStackTrace();
        }
        
    }
    public static Connection getConnection() {
        // This method returns the connection object.
        return con;
    }
    
}
