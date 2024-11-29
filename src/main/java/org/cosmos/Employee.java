package org.cosmos;

import javax.xml.crypto.Data;

public class Employee extends Person{
    private int NumberEmp;
    private String HiringDate;

    public String getRole() {
        return "Employee number: "+NumberEmp+"  Hiring date: "+HiringDate;
    }

}
