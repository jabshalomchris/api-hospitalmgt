/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;

//import static com.mycompany.apihospitalmgt.dao.PatientDAO.con;
import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Patient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.apihospitalmgt.model.User;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;


/**
 *
 * @author ASUS
 */
public class UserDAO {
    
//    Connection con;
//
//    public UserDAO(Connection con) {
//        this.con = con;
//    } 
  //  public static Connection con = dbconnection.getConnection();
    
    //log user
    public User logUser(String username, String password) throws SQLException,
            ClassNotFoundException {
        User user = null;
        try {
//            String query = "select * from user where username=? and password=?";
//            PreparedStatement ps = con.prepareStatement(query);
            Connection con = dbconnection.getConnection();
            CallableStatement cs;
            cs = con.prepareCall("{CALL authenticateUser(?,?)}");
            cs.setString(1,username);
            cs.setString(2, password);
            
            ResultSet rs  = cs.executeQuery();
            if(rs.next()){
                 user = new User();
                 user.setId(rs.getInt("id"));
                 user.setUsername(rs.getString("username"));
                 user.setEmail(rs.getString("email"));
                 user.setUserType(rs.getString("userType"));
             
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
 
        return user;
    }
    
     public List<User> getAllUsers() { 
      List<User> user = new ArrayList<>();
      try {
        Connection con = dbconnection.getConnection();
        CallableStatement cs;
        cs = con.prepareCall("{CALL getAllUsers()}");
        ResultSet rs = cs.executeQuery();
//        String query = "select * from user";
//        PreparedStatement ps = con.prepareStatement(query); 
            
           //ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             User u = new User();
             u.setId(rs.getInt("id"));
             u.setUsername(rs.getString("username"));
             u.setEmail(rs.getString("email"));
             u.setPassword(rs.getString("password"));
             u.setUserType(rs.getString("userType"));
             user.add(u);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      
      return user;
   }
     
     public static User getUser(int id) { 
      User user = null;
      try {
          Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT * FROM user WHERE id=" + id);		      
         while(rs.next()){
             user = new User();
             user.setId(rs.getInt("id"));
             user.setUsername(rs.getString("username"));
             user.setEmail(rs.getString("email"));
             user.setPassword(rs.getString("password"));
             user.setUserType(rs.getString("userType"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return user;
   }
     
     public String getNextUserId() { 

     String nextId="";
     
      try {
        Connection con = dbconnection.getConnection();
        CallableStatement cs;
        cs = con.prepareCall("{CALL getNextUserId()}");
        ResultSet rs = cs.executeQuery();
        //String query = "select * from patient";
        //PreparedStatement ps = this.con.prepareStatement(query); 
            
          // ResultSet rs  = ps.executeQuery();	      
         if(rs.next()){
             nextId = rs.getString("MAX(id) + 1");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return nextId;
   }
    
    public static boolean addUser(User user) { 
      try {
          Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate("insert into user (`username`, `email`, `password`, `userType`, status)  "
                    + "VALUES ('" + user.getUsername()+ "', "
                    + "'" + user.getEmail()+"', "
                    + "'" + user.getPassword()+"', "
                    + "'" + user.getUserType()+"', "
                    + "" + user.getStatus()+ ")");	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }
    
    public static boolean updateUser(User user) { 
      try {
          Connection con = dbconnection.getConnection();
         Statement stmt = con.createStatement();
         stmt.executeUpdate("UPDATE user "
                 + "SET username = '" + user.getUsername()+ "', email='"+user.getEmail()
                 +"', password='"+user.getPassword()+"', userType = '" + user.getUserType()+ "' "
                 + "WHERE (id = '" + user.getId()+ "')");	
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return false;
    }
    
        public List<User> getFilteredUsers( String name, String type) { 
          List<User> users = new ArrayList<>();
          try {
            String query = "SELECT * FROM user WHERE username LIKE '%" + name+"%' AND userType LIKE '%"
                    +type+"%' ;";
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);


               ResultSet rs  = ps.executeQuery();	      
                while(rs.next()){
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setEmail(rs.getString("email"));
                    u.setUserType(rs.getString("userType"));
                    u.setPassword(rs.getString("password"));
                    u.setStatus(rs.getBoolean("status"));
                    
                    users.add(u);
                }
             } catch (SQLException e) {
                e.printStackTrace();
             } 
             return users;
       }
        
        public static boolean updateStatus(Boolean status,String id) { 
                try {
                    Connection con = dbconnection.getConnection();
                   Statement stmt = con.createStatement();
                   stmt.executeUpdate("UPDATE user "
                           + "SET status = " + status
                           + " WHERE (id = '" + id + "')");	
                   return true;
                } catch (SQLException e) {
                   e.printStackTrace();
                } 
                return false;
              }
}

