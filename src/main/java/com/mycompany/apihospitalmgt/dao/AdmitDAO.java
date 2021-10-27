/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;

import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Admittance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AdmitDAO {
    
    
    public static boolean admitPatient(Admittance admittance) { 
      try {
         Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate(" INSERT INTO `admittance` (`patient_id`,"
         +" `room_id`, `start_date`, `end_date`,`treatment_code`,`status`)"
         +" VALUES ("+admittance.getPatient_id()+", "+admittance.getRoom_id()
         +", '"+admittance.getStart_date()+"', '"+admittance.getStart_date()+"', "+admittance.getTreatment_code()+", "+admittance.getStatus()+");");	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }
    public List<Admittance> getFilteredAdmissionDetails(String id, String name, String treatment) { 
      List<Admittance> admittance = new ArrayList<>();
      try {
          Connection con = dbconnection.getConnection();
        String query = "SELECT * FROM admittance a \n" +
                "JOIN patient p ON a.patient_id=p.patientId JOIN treatment t ON a.treatment_code=t.code \n" +
                " WHERE a.patient_id LIKE '%"+id+"%' AND p.patientName LIKE '%"+name+"%' AND a.treatment_code LIKE '%"+treatment+"%';";
        
        PreparedStatement ps = con.prepareStatement(query);
        
            
           ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Admittance a = new Admittance();
             a.setAdmittance_id(rs.getInt("admittance_id"));
             a.setPatient_id(rs.getInt("patient_id"));
             a.setPatientName(rs.getString("patientName"));
             a.setTreatment_code(rs.getInt("treatment_code"));
             a.setTreatmentName(rs.getString("treatmentName"));
             a.setStart_date(rs.getString("start_date"));
             a.setRoom_id(rs.getInt("room_id"));
            
             admittance.add(a);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return admittance;
   }
    
    public static boolean updateAdmittance(Admittance admittance) { 
      try 
      {
          Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate("UPDATE `hospitalmgtsystem`.`admittance` SET `end_date` = '"+admittance.getEnd_date()+"', `status` = '1' "
                 +" WHERE (`admittance_id` = "+admittance.getAdmittance_id()+");");	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return false;
    }
    
}
