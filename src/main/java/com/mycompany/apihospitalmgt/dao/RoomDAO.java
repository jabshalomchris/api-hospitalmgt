/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;



import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Room;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class RoomDAO {
    public static Connection con = dbconnection.getConnection();
    
    public List<Room> getAvailableRoomWithWardID(String id) { 
      List<Room> room = new ArrayList<>();
      try {
          
        CallableStatement cs;
            cs = con.prepareCall("{CALL getRoomByWard(?)}");
            cs.setString(1,id);
            //cs.setInt(2, 1);
        ResultSet rs = cs.executeQuery();
        
        //String query = "select * from patient";
        //PreparedStatement ps = this.con.prepareStatement(query); 
            
          // ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Room r = new Room();
             r.setRoom_id(rs.getInt("room_id"));
             r.setWard_id(rs.getInt("ward_id"));
             r.setAvailable(rs.getBoolean("available"));
             r.setRoomName(rs.getString("roomName"));
             
             room.add(r);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return room;
   }
    
    public static boolean changeRoomStatus(Room room) { 
      try {
         Statement stmt = con.createStatement();
         stmt.executeUpdate("UPDATE `room` SET `available` = "+room.getAvailable()+" WHERE (`room_id` = '"+room.getRoom_id()+"')" );	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return false;
    }
    
    public List<Room> getRoomByWard(String id) { 
       List<Room> room = new ArrayList<>();
      try {
          
        CallableStatement cs;
            cs = con.prepareCall("{CALL getAllroomsByWard(?)}");
            cs.setString(1,id);
            //cs.setInt(2, 1);
        ResultSet rs = cs.executeQuery();
        
        //String query = "select * from patient";
        //PreparedStatement ps = this.con.prepareStatement(query); 
            
          // ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Room r = new Room();
             r.setRoom_id(rs.getInt("room_id"));
             r.setWard_id(rs.getInt("ward_id"));
             r.setAvailable(rs.getBoolean("available"));
             r.setRoomName(rs.getString("roomName"));
             
             room.add(r);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return room;
   }
    
    
}
