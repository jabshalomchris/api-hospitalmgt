/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;

//import static com.mycompany.apihospitalmgt.dao.AdmitDAO.con;
//import static com.mycompany.apihospitalmgt.dao.PatientDAO.con;
import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Admittance;
import com.mycompany.apihospitalmgt.model.Appointment;
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
public class AppointmentDAO {
    
    public static boolean addAppointment(Appointment appointment) { 
      try {
         Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate(" INSERT INTO `appointment` (`patientid`,"
         +" `doctorid`, `remarks`, `status`,`date`)"
         +" VALUES ("+appointment.getPatientid()+", "+appointment.getDoctorid()
         +", '"+appointment.getRemarks()+"', "+appointment.getStatus()+", '"+appointment.getDate()+"');");	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }
    
    public String getAppointmentId() { 

     String nextId="";
     
      try {
          Connection con = dbconnection.getConnection();
        CallableStatement cs;
        cs = con.prepareCall("{CALL getAppointmentId()}");
        ResultSet rs = cs.executeQuery();      
         if(rs.next()){
             nextId = rs.getString("MAX(appointmentId)");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return nextId;
   }
    
   public static boolean updateAppointment(Appointment appointment) { 
      try {
         Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate("UPDATE `appointment` SET `status` = "+appointment.getStatus()
                 +", `diagnosis` = '"+appointment.getDiagnosis()+"' WHERE (`appointmentId` = '"+appointment.getAppointmentid()+"');");	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return false;
   }
    
    public List<Appointment> getAppointments(String id, Boolean status) { 
      List<Appointment> appointments = new ArrayList<>();
      try {
          Connection con = dbconnection.getConnection();
        String query = "SELECT * FROM appointment WHERE doctorid =" + id+" AND status ="+status;
        PreparedStatement ps = con.prepareStatement(query);
      
           ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Appointment a = new Appointment();
             a.setAppointmentid(rs.getInt("appointmentId"));
             a.setPatientid(rs.getInt("patientid"));
             a.setDoctorid(rs.getInt("doctorid"));
             a.setDate(rs.getString("date"));
             a.setRemarks(rs.getString("remarks"));
             a.setStatus(rs.getBoolean("status"));
             a.setDiagnosis(rs.getString("diagnosis"));
      
             appointments.add(a);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return appointments;
   }
    
}
