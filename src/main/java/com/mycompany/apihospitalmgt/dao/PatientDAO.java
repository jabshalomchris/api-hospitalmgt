/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;

import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Patient;
import java.sql.CallableStatement;
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
public class PatientDAO {

    public List<Patient> getAllPatients() { 
      List<Patient> patients = new ArrayList<>();
      try 
      {
        Connection con = dbconnection.getConnection();
        CallableStatement cs;
        cs = con.prepareCall("{CALL getAllPatients()}");
        ResultSet rs = cs.executeQuery();
             
         while(rs.next()){
             Patient p = new Patient();
             p.setId(rs.getInt("patientId"));
             p.setTitle(rs.getString("title"));
             p.setPatientName(rs.getString("patientName"));
             p.setDob(rs.getString("dob"));
             p.setGender(rs.getString("gender"));
             p.setBloodGroup(rs.getString("BloodGroup"));
             p.setNic(rs.getString("nic"));
             p.setEmail(rs.getString("email"));
             p.setAddress(rs.getString("address"));
             p.setTelephone(rs.getString("telephone"));
             p.setCitizenship(rs.getString("citizenship"));
             patients.add(p);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return patients;
   }
    
    public String getNextPatientId() { 

     String nextId="";
     
      try {
        Connection con = dbconnection.getConnection(); 
        CallableStatement cs;
        cs = con.prepareCall("{CALL getNextPatientId()}");
        ResultSet rs = cs.executeQuery();
        	      
         if(rs.next()){
             nextId = rs.getString("MAX(patientId) + 1");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return nextId;
   }
    
    
     public List<Patient> getFilteredPatients(String id, String name, String nic, String gender) { 
      List<Patient> patients = new ArrayList<>();
      try {
          Connection con = dbconnection.getConnection();
        String query = "SELECT * FROM patient WHERE patientId LIKE '%" + id+"%' AND patientName LIKE '%"
                +name+"%' AND nic LIKE '%"+nic+"%' AND gender LIKE '%"+gender+"%';";
        PreparedStatement ps = con.prepareStatement(query);
        
            
           ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Patient p = new Patient();
             p.setId(rs.getInt("patientId"));
             p.setTitle(rs.getString("title"));
             p.setPatientName(rs.getString("patientName"));
             p.setDob(rs.getString("dob"));
             p.setGender(rs.getString("gender"));
             p.setBloodGroup(rs.getString("BloodGroup"));
             p.setNic(rs.getString("nic"));
             p.setEmail(rs.getString("email"));
             p.setAddress(rs.getString("address"));
             p.setTelephone(rs.getString("telephone"));
             p.setCitizenship(rs.getString("citizenship"));
             patients.add(p);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return patients;
   }
    
    
    
     public static Patient getPatient(int id) { 
      Patient patient = null;
      try {
          Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM patient WHERE patientId=" + id);		      
         while(rs.next()){
             patient = new Patient();
             patient.setId(rs.getInt("patientId"));
             patient.setPatientName(rs.getString("patientName"));
             patient.setDob(rs.getString("dob"));
             patient.setGender(rs.getString("gender"));
             patient.setBloodGroup(rs.getString("BloodGroup"));
             patient.setNic(rs.getString("nic"));
             patient.setEmail(rs.getString("email"));
             patient.setAddress(rs.getString("address"));
             patient.setTelephone(rs.getString("telephone"));
             patient.setCitizenship(rs.getString("citizenship"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return patient;
   }
   
    public static boolean checkforexistance(String nic) { 
      boolean status=false;
      try 
      {
          Connection con = dbconnection.getConnection();
        String query = " Select * from patient where nic ='"+nic+"'";
        PreparedStatement ps = con.prepareStatement(query); 
        ResultSet rs  = ps.executeQuery();
        if(rs.next()){
            status=true;
        } 
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return status;
   }
    
    public static boolean addPatient(Patient patient) { 
      boolean status = false;
      try {
         Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate(" INSERT INTO `patient` (`title`,`patientName`,"
         +" `dob`, `gender`, `BloodGroup`, `nic`, `email`, `address`,"
         +" `telephone`, `citizenship`)"
         +" VALUES ('"+patient.getTitle()+"', '"+patient.getPatientName()+"', '"+patient.getDob()
         +"', '"+patient.getGender()+"', '"+patient.getBloodGroup()+"', '"
         +patient.getNic()+"', '"+patient.getEmail()+"', '"+patient.getAddress()
         +"', '"+patient.getTelephone()+"', '"+patient.getCitizenship()+"');");	
         status = true;
      } 
      catch (SQLException e) {
         e.printStackTrace();
      }
      return status;
   }
    
    public static boolean updatePatient(Patient patient) { 
      
        
      try {
          Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate("UPDATE patient "
                 + "SET title = '" + patient.getTitle() + "', patientName = '" + patient.getPatientName()
                 + "', dob = '" + patient.getDob()
                 + "', gender = '" + patient.getGender()
                 + "', BloodGroup = '" + patient.getBloodGroup()
                 + "', nic = '" + patient.getNic()
                 + "', email = '" + patient.getEmail()
                 + "', address = '" + patient.getAddress()
                 + "', telephone = '" + patient.getTelephone()
                 + "', citizenship = '" + patient.getCitizenship()+"' "
                 + "WHERE (patientId = '" + patient.getId()+ "')");	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return false;
    }
    
    public static boolean admitPatient() { 
      try {
          Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate(" INSERT INTO `patient` (`title`,`patientName`,"
         +" `dob`, `gender`, `BloodGroup`, `nic`");	
        

         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }
   
    
}
