package org.cosmos;

import javax.xml.crypto.Data;

public class Employee extends Person{
    private final int NumberEmp;
    private final String HiringDate;

    public Employee(int id, String name, String address, int contact, int numberEmp, String hiringDate) {
        super(id, name, address, contact);
        this.NumberEmp = numberEmp;
        this.HiringDate = hiringDate;
    }



    public String getRole() {

        return "Employee number: "+NumberEmp+"/n  Hiring date: "+HiringDate;
    }


}
