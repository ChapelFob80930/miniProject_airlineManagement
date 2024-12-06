package org.cosmos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffCabin extends Employee{
    @JsonProperty("qualification")
    private String qualification;
    protected static Map<Flight, List<StaffCabin>> cabinCrew=new HashMap<Flight, List<StaffCabin>>();

    public StaffCabin(@JsonProperty("id") int id,@JsonProperty("name") String name,@JsonProperty("address") String address,@JsonProperty("contact") int contact,@JsonProperty("numberEmp") int numberEmp,@JsonProperty("hiringDate") String hiringDate,@JsonProperty("qualification") String qualification) {
        super(id, name, address, contact, numberEmp, hiringDate);
        this.qualification = qualification;
    }

    public void assignFlight(int flightNumber,StaffCabin staff){
        Flight tempF=Flight.RegisteredFlights.get(flightNumber);
        if(tempF!=null){
            if(cabinCrew.get(tempF).contains(staff)){
                System.out.println("Staff is already assigned to this flight");
                return;
            }
            List<StaffCabin> tempL=new ArrayList<StaffCabin>();
            tempL.add(staff);
            cabinCrew.put(tempF,tempL);
        }
        else{
            System.out.println(flightNumber+" does not exist");
        }
    }

    public static void obtainVol() {
        if(cabinCrew.isEmpty()){
            System.out.println("No flights have a cabin crew");
        }
        for (Map.Entry<Flight, List<StaffCabin>> entry : cabinCrew.entrySet()) {
            Flight tempF = entry.getKey();
            List<StaffCabin> staffList = entry.getValue();
            System.out.println("Flight: " + tempF.getFlight(tempF.flightNumber));
            int i=0;
            System.out.println("Cabin Crew: ");
            for (StaffCabin staff : staffList) {
                System.out.println(i++ + staff.getInfos());
            }
        }
    }

}
