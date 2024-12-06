package org.cosmos;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;

public class Employee extends Person{
    @JsonProperty("NumberEmp")
    private final int NumberEmp;
    @JsonProperty("HiringDate")
    private final String HiringDate;

    public Employee(int id, String name, String address, String contact, int numberEmp, String hiringDate) {
        super(id, name, address, contact);
        this.NumberEmp = numberEmp;
        this.HiringDate = hiringDate;
    }



    public String getRole() {

        return "Employee number: "+NumberEmp+"/n  Hiring date: "+HiringDate;
    }


}
