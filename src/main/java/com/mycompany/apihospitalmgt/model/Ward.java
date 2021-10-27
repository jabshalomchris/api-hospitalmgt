/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.model;

/**
 *
 * @author ASUS
 */
public class Ward {
    private int ward_id;
    private String ward_name;

    public int getWard_id() {
        return ward_id;
    }

    public void setWard_id(int ward_id) {
        this.ward_id = ward_id;
    }

    public String getWard_name() {
        return ward_name;
    }

    public void setWard_name(String ward_name) {
        this.ward_name = ward_name;
    }

    @Override
    public String toString() {
        return "Ward{" + "ward_id=" + ward_id + ", ward_name=" + ward_name + '}';
    }
    
    

    
}
