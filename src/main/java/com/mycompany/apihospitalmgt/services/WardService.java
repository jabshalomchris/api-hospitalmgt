/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.model.Ward;
import com.mycompany.apihospitalmgt.dao.WardDAO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ASUS
 */
@Path("/ward")
public class WardService {
    
    WardDAO wardDao = new WardDAO();
    
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllTreatment() {
                Gson gson = new GsonBuilder().create();
                return gson.toJson(wardDao.getAllWards());
	}
        
         Ward convertJsonToWard(String json) {
             return new Gson().fromJson(json, Ward.class);
         }
    
}
