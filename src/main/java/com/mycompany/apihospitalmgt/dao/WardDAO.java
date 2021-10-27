/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;

import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Ward;
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
public class WardDAO {
    
  
 
    public List<Ward> getAllWards() { 
      List<Ward> ward = new ArrayList<>();
      try {
          Connection con = dbconnection.getConnection();
        CallableStatement cs;
        cs = con.prepareCall("{CALL getAllWards()}");
        ResultSet rs = cs.executeQuery();
        //String query = "select * from patient";
        //PreparedStatement ps = this.con.prepareStatement(query); 
            
          // ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Ward w = new Ward();
             w.setWard_id(rs.getInt("ward_id"));
             w.setWard_name(rs.getString("ward_name"));
             
             ward.add(w);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return ward;
   }
    
}
