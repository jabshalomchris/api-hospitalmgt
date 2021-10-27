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
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;    
import org.json.simple.JSONValue;  
/**
 *
 * @author ASUS
 */
@Path("/login")
public class LoginService {
    UserDAO userdao = new UserDAO();
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String checkLogin(@FormParam("username") String username,@FormParam("password") String password)
       { 
           ResponseJSON response = new ResponseJSON();
           User user = null;
           
           try {
            
            user = userdao.logUser(username, password);            
            if (user != null) {
               // res.setMessage("success");
               response.setMessage("success");
               response.setStatus(true);
            } else {
                String message = "Invalid email/password";
               // res.setMessage("unsuccessful");
                response.setMessage("unsuccessful");
                response.setStatus(false);
            }        
        } catch (SQLException | ClassNotFoundException ex) {
            
        }
 
         Gson gson = new GsonBuilder().create();
         return gson.toJson(user);
    }
//    
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public String login(String json) {
//        ResponseJSON res = new ResponseJSON();
//        Object obj=JSONValue.parse(json);  
//        //creating an object of JSONObject class and casting the object into JSONObject type  
//        JSONObject jsonObject = (JSONObject) obj; 
//        String username = (String) jsonObject.get("username");    
//        String password = (String) jsonObject.get("password");
//
////         User user = new Gson().fromJson(json, User.class);
//         
//         try {
//            UserDao userDao = new UserDao(dbconnection.getConnection());
//            User user = userDao.logUser(username, password);            
//            if (user != null) {
//                res.setMessage("success");
//            } else {
//               // String message = "Invalid email/password";
//                res.setMessage("unsuccessful");
//            }
//
//             
//        } catch (SQLException | ClassNotFoundException ex) {
//            
//        }
// 
//         Gson gson = new GsonBuilder().create();
//         return gson.toJson(res);
//    }
//    
   
}
