package org.cosmos;

import javax.xml.crypto.Data;

public class Employee extends Person{
    private int NumberEmp;
    private String HiringDate;

    public Employee(String name, int id, int contact, String address) {
        super(name, id, contact, address);
    }

    public String getRole() {

        return "Employee number: "+NumberEmp+"/n  Hiring date: "+HiringDate;
    }

}
