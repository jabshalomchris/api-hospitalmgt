/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.MailUtil;
import com.mycompany.apihospitalmgt.dao.PatientDAO;
import com.mycompany.apihospitalmgt.model.Patient;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
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
@Path("/patient")
public class PatientService {
    
    PatientDAO patientdao = new PatientDAO();
    MailUtil mailutil= new MailUtil();
    
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getAllPatients() {
//                Gson gson = new GsonBuilder().create();
//                return gson.toJson(patientdao.getAllPatients());
//	}
        
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getNextPatientId() {
                Gson gson = new GsonBuilder().create();
                return gson.toJson(patientdao.getNextPatientId());
	}
        
        @GET
        @Path("/filter")
	@Produces(MediaType.APPLICATION_JSON)
	public String getFilteredPatients(@QueryParam("id") String id, @QueryParam("name") String name
                , @QueryParam("nic") String nic,@QueryParam("gender") String gender) {
		
                Gson gson = new GsonBuilder().create();
                return gson.toJson(patientdao.getFilteredPatients(id,name,nic,gender));
	}
        
//        @POST
//        @Path("/filter")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String admitPatient(@QueryParam("pid") int id, @QueryParam("roomId") int name
//                , @QueryParam("treatmentId") int treatmentId,@QueryParam("date") String date) {
//		
//                Gson gson = new GsonBuilder().create();
//                return gson.toJson(patientdao.getFilteredPatients(id,name,nic,gender));
//	}
        
        
        
        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
         public String getPatient(@PathParam("id")int id) {
         Gson gson = new GsonBuilder().create();
         return gson.toJson(patientdao.getPatient(id));
        }
        
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
         public String addPatient(String json) {
             Patient p = convertJsonToPatient(json);
             ResponseJSON response = new ResponseJSON();
             try {  
                 
                 if(PatientDAO.addPatient(p)){
                 String body="";
                    body +="<h2>Hello "+p.getPatientName()+",</h2>";
                    body +="<h4>Welcome to the ABC Healthcare Family.. Thank you for registering!!!.</h4>";
                    body+="";
                 mailutil.sendMail(p.getEmail(), p.getPatientName(),body);
                 response.setMessage("Patient is added");
                 response.setStatus(true);
                 }
                 else{
                 response.setMessage("Patient is not added");
                 response.setStatus(false); 
                 }
                 
             } catch(Exception e) {
                 response.setMessage("Error while adding records");
             }
             Gson gson = new GsonBuilder().create();
              return gson.toJson(response);
         }
         
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public String updatePerson(String json) {
            Patient p = convertJsonToPatient(json);
            ResponseJSON response = new ResponseJSON();
            try {
                PatientDAO.updatePatient(p);            
                response.setMessage("Patient is updated");
                response.setStatus(true);
            } catch(Exception e) {
                response.setMessage("Patient is not updated");
                response.setStatus(false); 
            }
            Gson gson = new GsonBuilder().create();
             return gson.toJson(response);
        }

          Patient convertJsonToPatient(String json) {
             return new Gson().fromJson(json, Patient.class);
         }
}
