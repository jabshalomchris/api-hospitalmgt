/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.dao.DepartmentDAO;
import com.mycompany.apihospitalmgt.model.Department;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS
 */
@Path("/department")
public class DepartmentService {
    DepartmentDAO departmentdao = new DepartmentDAO();
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllDepartments() {
                Gson gson = new GsonBuilder().create();
                return gson.toJson(departmentdao.getAllPatients());
	}
        
         Department convertJsonToDepartment(String json) {
             return new Gson().fromJson(json, Department.class);
         }
}
