package org.cosmos;

public class StaffCabin extends Employee{
    private String qualification;

    public StaffCabin(int id, String name, String address, int contact, int numberEmp, String hiringDate, String qualification) {
        super(id, name, address, contact, numberEmp, hiringDate);
        this.qualification = qualification;
    }

    public void assignFlight(){

    }

    public void obtainVol(){
        
    }
}
