/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apihospitalmgt.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@XmlRootElement (name="department")
public class Department {
    private int departmentid;
    private String name;

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int departmentid) {
        this.departmentid = departmentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentid=" + departmentid + ", name=" + name + '}';
    }
    
    
}
