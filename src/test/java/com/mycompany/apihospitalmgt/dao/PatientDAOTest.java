///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.apihospitalmgt.dao;
//
//import com.mycompany.apihospitalmgt.model.Patient;
//import java.util.List;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author ASUS
// */
//public class PatientDAOTest {
//    
//    public PatientDAOTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    
//
//    /**
//     * Test of getNextPatientId method, of class PatientDAO.
//     */
////    @Test
////    public void testGetNextPatientId() {
////        System.out.println("getNextPatientId");
////        PatientDAO instance = new PatientDAO();
////        String expResult = "";
////        String result = instance.getNextPatientId();
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
//
//            
////        //getting the next available id
////    PatientDAO instance = new PatientDAO();
////
////        int id=Integer.parseInt(instance.getNextPatientId());
//    
////        //Check the added person
////        System.out.println("getPerson");
////        Patient resultpatient = PatientDAO.getPatient(id);
////        assertEquals(id, resultpatient.getId());
////        assertEquals(patient.getPatientName(), resultpatient.getPatientName());
////        assertEquals(patient.getTitle(), resultpatient.getTitle());
//////        assertEquals(patient.getBloodGroup(), resultpatient.getBloodGroup());
//////        assertEquals(patient.getGender(), resultpatient.getGender());
//////        assertEquals(patient.getCitizenship(), resultpatient.getCitizenship());
//////        assertEquals(patient.getEmail(), resultpatient.getEmail());
//////        assertEquals(patient.getTelephone(), resultpatient.getTelephone());
//////        assertEquals(patient.getAddress(), resultpatient.getAddress());
//////        assertEquals(patient.getNic(), resultpatient.getNic());
//
//    /**
//     * Test of addPatient method, of class PatientDAO.
//     */
//    @Test
//    public void testAddPatient() {
//        System.out.println("addPatient");
//        //arrange
//        Patient patient = new Patient();
//        patient.setTitle("Mr");
//        patient.setPatientName("TestName");
//        patient.setDob("1999-10-20");
//        patient.setGender("Male");
//        patient.setBloodGroup("O+");
//        patient.setCitizenship("Sri Lankan");
//        patient.setEmail("123@gmail.com");
//        patient.setTelephone("12343");
//        patient.setAddress("123");
//        patient.setNic("123333");
//        
//        //Add the person
//        boolean expResult = true;
//        boolean result = PatientDAO.addPatient(patient);
//        //assert
//        assertEquals(expResult, result);
//    }
//    
//    
//    
////
////    /**
////     * Test of updatePatient method, of class PatientDAO.
////     */
////    @Test
////    public void testUpdatePatient() {
////        System.out.println("updatePatient");
////        Patient patient = new Patient();
////        patient.setTitle("Mr");
////        patient.setPatientName("TestName");
////        patient.setDob("1999-10-20");
////        patient.setGender("Female");
////        patient.setBloodGroup("O+");
////        patient.setCitizenship("Sri Lankan");
////        patient.setEmail("123@gmail.com");
////        patient.setTelephone("12343");
////        patient.setAddress("123");
////        patient.setNic("123333");
////        boolean expResult = false;
////        boolean result = PatientDAO.updatePatient(patient);
////        assertEquals(expResult, result);
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    
//////    
//////
//////    /**
//////     * Test of getPatient method, of class PatientDAO.
//////     */
//////    @Test
//////    public void testGetPatient() {
//////        System.out.println("getPatient");
//////        int id = 0;
//////        Patient expResult = null;
//////        Patient result = PatientDAO.getPatient(id);
//////        assertEquals(expResult, result);
//////        // TODO review the generated test code and remove the default call to fail.
//////        fail("The test case is a prototype.");
//////    }
//////    
//////    
//////    /**
//////     * Test of getFilteredPatients method, of class PatientDAO.
//////     */
//////    @Test
//////    public void testGetFilteredPatients() {
//////        System.out.println("getFilteredPatients");
//////        String id = "";
//////        String name = "";
//////        String nic = "";
//////        String gender = "";
//////        PatientDAO instance = new PatientDAO();
//////        List<Patient> expResult = null;
//////        List<Patient> result = instance.getFilteredPatients(id, name, nic, gender);
//////        assertEquals(expResult, result);
//////        // TODO review the generated test code and remove the default call to fail.
//////        fail("The test case is a prototype.");
//////    }
//////    
//////    /**
//////     * Test of getAllPatients method, of class PatientDAO.
//////     */
////////    
////////    @Test
////////    public void testGetAllPatients() {
////////        System.out.println("getAllPatients");
////////        PatientDAO instance = new PatientDAO();
////////        List<Patient> expResult = null;
////////        List<Patient> result = instance.getAllPatients();
////////        assertEquals(expResult, result);
////////        // TODO review the generated test code and remove the default call to fail.
////////        fail("The test case is a prototype.");
////////    }
//    
//}
