/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.MailUtil;
import com.mycompany.apihospitalmgt.dao.AppointmentDAO;
import com.mycompany.apihospitalmgt.dao.DoctorDAO;
import com.mycompany.apihospitalmgt.dao.PatientDAO;
import com.mycompany.apihospitalmgt.model.Admittance;
import com.mycompany.apihospitalmgt.model.Appointment;
import com.mycompany.apihospitalmgt.model.Doctor;
import com.mycompany.apihospitalmgt.model.Patient;
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
@Path("/appointment")
public class AppointmentService {
    AppointmentDAO appointmentdao = new AppointmentDAO();
    PatientDAO patientdao = new PatientDAO();
    DoctorDAO doctordao = new DoctorDAO();
    MailUtil mailutil= new MailUtil();
    
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
         public String addAppointment(String json) {
             Appointment a = convertJsonToAppointment(json);
             ResponseJSON response = new ResponseJSON();
             try {  
                 if(appointmentdao.addAppointment(a)){
                     
                 String id=appointmentdao.getAppointmentId();
                 Patient p = patientdao.getPatient(a.getPatientid());
                 Doctor d = doctordao.getDoctorByDocID(a.getDoctorid());
                 
                 String body="";
                    body +="<h2>Appointment No : "+appointmentdao.getAppointmentId()+",</h2>";
                    body +="<h3>Dear "+p.getPatientName()+",</h3>";
                    body +="<h3>Your appointment is confirmed with " +d.getDoctorname()+ ", Please Head to OPD Room A</h3>";
                    body +="<h4>Thank you!</h4>";
                    body +="<h4>from the heart of your healthcare!!</h4>";
                    body+="";
                    
                 mailutil.sendMail(p.getEmail(), p.getPatientName(),body);
                 response.setMessage("Appointment placed!");
                 response.setStatus(true);
                 }
                 else{
                 response.setMessage("Appointment not placed");
                 response.setStatus(false); 
                 }
                 
             } catch(Exception e) {
                 response.setMessage("Error while adding records");
             }
             Gson gson = new GsonBuilder().create();
              return gson.toJson(response);
         }
         
        @GET
        @Path("/bydoctor")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAppointments(@QueryParam("id") String id,@QueryParam("status") Boolean status) {
		
                Gson gson = new GsonBuilder().create();
                return gson.toJson(appointmentdao.getAppointments(id,status));
	}
        
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public String updatePerson(String json) {
            Appointment a = convertJsonToAppointment(json);
            ResponseJSON response = new ResponseJSON();
            try {
                if(appointmentdao.updateAppointment(a)){
                    response.setMessage("Appointment completed");
                    response.setStatus(true);
                } 
                else{
                response.setMessage("Appointment could not be completed");
                response.setStatus(false); 
                
                }
            } catch(Exception e) {
                response.setMessage("Appointment could not be completed");
                response.setStatus(false); 
            }
            Gson gson = new GsonBuilder().create();
             return gson.toJson(response);
        }
         
         
         
         
         Appointment convertJsonToAppointment(String json) {
             return new Gson().fromJson(json, Appointment.class);
         }
    
    
    
    
}
