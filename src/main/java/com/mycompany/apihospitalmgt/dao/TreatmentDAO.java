/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;

import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Treatment;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TreatmentDAO {
    
    
     public static Connection con = dbconnection.getConnection();
 
    public List<Treatment> getAllTreatment() { 
      List<Treatment> treatment = new ArrayList<>();
      try {
          
        CallableStatement cs;
        cs = con.prepareCall("{CALL getAllTreatment()}");
        ResultSet rs = cs.executeQuery();
        //String query = "select * from patient";
        //PreparedStatement ps = this.con.prepareStatement(query); 
            
          // ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Treatment t = new Treatment();
             t.setCode(rs.getInt("code"));
             t.setTreatmentName(rs.getString("treatmentName"));
             t.setPrice(rs.getString("price"));
             
             treatment.add(t);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return treatment;
   }
}
