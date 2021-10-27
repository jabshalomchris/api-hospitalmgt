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
public class Treatment {
    private int code;
    private String treatmentName;
    private String price;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Treatment{" + "code=" + code + ", treatmentName=" + treatmentName + ", price=" + price + '}';
    }
    
    

    
}
