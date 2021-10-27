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
public class Admittance {
    private int admittance_id;
    private int patient_id;
    private String patientName;
    private String treatmentName;
    private int room_id;
    private int treatment_code;
    private String start_date;
    private String end_date;
    private Boolean status;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getAdmittance_id() {
        return admittance_id;
    }

    public void setAdmittance_id(int admittance_id) {
        this.admittance_id = admittance_id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }


    public int getTreatment_code() {
        return treatment_code;
    }

    public void setTreatment_code(int treatment_code) {
        this.treatment_code = treatment_code;
    }

    @Override
    public String toString() {
        return "Admittance{" + "admittance_id=" + admittance_id + ", patient_id=" + patient_id + ", patientName=" + patientName + ", treatmentName=" + treatmentName + ", room_id=" + room_id + ", treatment_code=" + treatment_code + ", start_date=" + start_date + ", end_date=" + end_date + ", status=" + status + '}';
    }

    
     
}
