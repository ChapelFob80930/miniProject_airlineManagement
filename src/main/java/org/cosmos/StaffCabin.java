package org.cosmos;

public class StaffCabin extends Employee{
    private String qualification;

    public StaffCabin(String name, int id, int contact, String qualification, String address) {
        super(name, id, contact, address);
        this.qualification = qualification;
    }

    public void assignFlight(){

    }

    public void obtainVol(){
        
    }
}
