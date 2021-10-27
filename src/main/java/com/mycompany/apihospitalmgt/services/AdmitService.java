/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.dao.AdmitDAO;
import com.mycompany.apihospitalmgt.model.Admittance;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS
 */
@Path("/admit")
public class AdmitService {
    AdmitDAO admitdao = new AdmitDAO();
    
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
         public String addAdmission(String json) {
             Admittance a = convertJsonToAdmission(json);
             ResponseJSON response = new ResponseJSON();
             try {  
                 
                 if(admitdao.admitPatient(a)){
                 
                 //mailutil.sendMail(p.getEmail(), p.getPatientName());
                 response.setMessage("Patient has been admitted!");
                 response.setStatus(true);
                 }
                 else{
                 response.setMessage("Patient is not admitted");
                 response.setStatus(false); 
                 }
                 
             } catch(Exception e) {
                 response.setMessage("Error while adding records");
             }
             Gson gson = new GsonBuilder().create();
              return gson.toJson(response);
         }
         
         
            @GET
            @Path("/filter")
            @Produces(MediaType.APPLICATION_JSON)
            public String getFilteredAdmissionDetails(@QueryParam("id") String id, @QueryParam("name") String name
                    , @QueryParam("treatment") String treatment) {
                    Gson gson = new GsonBuilder().create();
                    return gson.toJson(admitdao.getFilteredAdmissionDetails(id,name,treatment));
            }
            
            
            @PUT
            @Consumes(MediaType.APPLICATION_JSON)
            @Produces(MediaType.APPLICATION_JSON)
            public String updateAdmission(String json) {
                Admittance a = convertJsonToAdmission(json);
                ResponseJSON response = new ResponseJSON();
                try {
                    admitdao.updateAdmittance(a);            
                    response.setMessage("Admission status updated!!");
                    response.setStatus(true);
                } catch(Exception e) {
                    response.setStatus(false); 
                }
                Gson gson = new GsonBuilder().create();
                 return gson.toJson(response);
            }

              Admittance convertJsonToAdmission(String json) {
                 return new Gson().fromJson(json, Admittance.class);
             }
 
}
