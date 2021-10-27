/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.dao.DoctorDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS
 */
@Path("/doctor")
public class DoctorService {
    DoctorDAO doctordao = new DoctorDAO();
    
        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
         public String getDoctorbydept(@PathParam("id")int id) {
         Gson gson = new GsonBuilder().create();
         return gson.toJson(doctordao.getDoctorbydept(id));
         
        }
         
//        @GET
//        @Path("/filter")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getFilteredPatients(@QueryParam("id") String id, @QueryParam("name") String name
//                , @QueryParam("nic") String nic,@QueryParam("gender") String gender) {
//		
//                Gson gson = new GsonBuilder().create();
//                return gson.toJson(patientdao.getFilteredPatients(id,name,nic,gender));
//	}
        
        @GET
        @Path("/finddoc")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDocbyUserId(@QueryParam("id") String id) {
		
                Gson gson = new GsonBuilder().create();
                return gson.toJson(doctordao.getDoctorByUserID(id));
	}
    
}
