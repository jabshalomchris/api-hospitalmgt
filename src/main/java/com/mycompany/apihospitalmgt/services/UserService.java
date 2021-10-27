/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.dao.UserDAO;
import com.mycompany.apihospitalmgt.model.User;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS
 */
@Path("/user")
public class UserService {
    UserDAO userdao = new UserDAO();
    
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getAllUsers() {
//		
//                Gson gson = new GsonBuilder().create();
//                return gson.toJson(userdao.getAllUsers());
//	}
        
        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
         public String getUser(@PathParam("id")int id) {
         Gson gson = new GsonBuilder().create();
         return gson.toJson(userdao.getUser(id));
        }
         
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getNextPatientId() {
                Gson gson = new GsonBuilder().create();
                return gson.toJson(userdao.getNextUserId());
	}
         
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
         public String addUser(String json) {
             User u = convertJsonToUser(json);
             ResponseJSON response = new ResponseJSON();
             try {
                 if(userdao.addUser(u)){
                    response.setMessage("User is added");
                    response.setStatus(true);
                 }
                 else{
                    response.setMessage("User is not added");
                    response.setStatus(false); 
                 }
                 
                 
             } catch(Exception e) {
                 response.setMessage("User is not added");
                 response.setStatus(false); 
             }
             Gson gson = new GsonBuilder().create();
              return gson.toJson(response);
         }
         
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public String updateUser(String json) {
            User u = convertJsonToUser(json);
            ResponseJSON response = new ResponseJSON();
            try {
                userdao.updateUser(u);            
                response.setMessage("Patient is updated");
                response.setStatus(true);
            } catch(Exception e) {
                response.setMessage("Patient is not updated");
                response.setStatus(false); 
            }
            Gson gson = new GsonBuilder().create();
             return gson.toJson(response);
        }

          User convertJsonToUser(String json) {
             return new Gson().fromJson(json, User.class);
         }
          
        @GET
        @Path("/filter")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFilteredUsers(@QueryParam("name") String name, @QueryParam("type") String type) {
		
                Gson gson = new GsonBuilder().create();
                return gson.toJson(userdao.getFilteredUsers(name,type));
	}
        
        @GET
        @Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFilteredUsers(@QueryParam("status") Boolean status, @QueryParam("id") String id) {
		
                Gson gson = new GsonBuilder().create();
                return gson.toJson(userdao.updateStatus(status,id));
	}

    
}
