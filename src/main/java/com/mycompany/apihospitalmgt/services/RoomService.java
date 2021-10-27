/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.apihospitalmgt.dao.RoomDAO;
import com.mycompany.apihospitalmgt.model.Room;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
@Path("/room")
public class RoomService {
    
    RoomDAO roomdao = new RoomDAO();
    
        @GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAvailableRooms(@QueryParam("id") String id) {
                Gson gson = new GsonBuilder().create();
                return gson.toJson(roomdao.getAvailableRoomWithWardID(id));
	}
        
        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public String changeRoomStatus(String json) {
            Room r = convertJsonToRoom(json);
            ResponseJSON response = new ResponseJSON();
            try 
            {
                if(roomdao.changeRoomStatus(r)){
                    response.setMessage("Room is allocated");
                    response.setStatus(true);
                }
                else{
                response.setMessage("Room is not allocated");
                response.setStatus(false); 
                }
                          
                
            } catch(Exception e) {
                response.setMessage("Room is not allocated");
                response.setStatus(false); 
            }
            Gson gson = new GsonBuilder().create();
             return gson.toJson(response);
        }
        
        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
         public String getRoomByWard(@PathParam("id")String id) {
         Gson gson = new GsonBuilder().create();
         return gson.toJson(roomdao.getRoomByWard(id));
        }
        
         Room convertJsonToRoom(String json) {
             return new Gson().fromJson(json, Room.class);
         }
    
}
