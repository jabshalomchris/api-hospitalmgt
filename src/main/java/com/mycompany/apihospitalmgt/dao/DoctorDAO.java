/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;


import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Doctor;
import com.mycompany.apihospitalmgt.model.Patient;
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
public class DoctorDAO {
    public static Connection con = dbconnection.getConnection();
    
    public List<Doctor> getDoctorbydept(int id) { 
      
      List<Doctor> doctor = new ArrayList<>();
      try {
        String query = "SELECT * FROM doctor d JOIN department a ON d.department=a.departmentid WHERE d.department=" + id;
        PreparedStatement ps = con.prepareStatement(query);

           ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Doctor d = new Doctor(); 
             d.setDoctorid(rs.getInt("doctorid"));
             d.setDoctorname(rs.getString("doctorname"));
             d.setPosition(rs.getString("position")); 
             doctor.add(d);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return doctor;
   }
    
    public static Doctor getDoctorByUserID(String id) { 
      Doctor doctor = null;
      try {
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM doctor WHERE userId=" + id);		      
         while(rs.next()){
             doctor = new Doctor();
             doctor.setDoctorid(rs.getInt("doctorid"));
             doctor.setDoctorname(rs.getString("doctorname"));
             doctor.setPosition(rs.getString("position"));           
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return doctor;
   }
    
    public static Doctor getDoctorByDocID(int id) { 
      Doctor doctor = null;
      try {
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM doctor WHERE doctorid=" + id);		      
         while(rs.next()){
             doctor = new Doctor();
             doctor.setDoctorid(rs.getInt("doctorid"));
             doctor.setDoctorname(rs.getString("doctorname"));
             doctor.setPosition(rs.getString("position"));           
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return doctor;
   }
    
}
