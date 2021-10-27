/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.dao;

import com.mycompany.apihospitalmgt.dbconnection;
import com.mycompany.apihospitalmgt.model.Department;
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
public class DepartmentDAO {
     
    public static Connection con = dbconnection.getConnection();
 
    public List<Department> getAllPatients() { 
      List<Department> department = new ArrayList<>();
      try {
          
        CallableStatement cs;
        cs = con.prepareCall("{CALL getAllDepartment()}");
        ResultSet rs = cs.executeQuery();
        //String query = "select * from patient";
        //PreparedStatement ps = this.con.prepareStatement(query); 
            
          // ResultSet rs  = ps.executeQuery();	      
         while(rs.next()){
             Department d = new Department();
             d.setDepartmentid(rs.getInt("departmentid"));
             d.setName(rs.getString("name"));
             
             department.add(d);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return department;
   }
}
