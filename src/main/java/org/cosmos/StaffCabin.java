package org.cosmos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffCabin extends Employee{
    private String qualification;
    protected static Map<Flight, List<StaffCabin>> cabinCrew=new HashMap<Flight, List<StaffCabin>>();

    public StaffCabin(int id, String name, String address, int contact, int numberEmp, String hiringDate, String qualification) {
        super(id, name, address, contact, numberEmp, hiringDate);
        this.qualification = qualification;
    }

    public void assignFlight(int flightNumber,StaffCabin staff){
        Flight tempF=Flight.RegisteredFlights.get(flightNumber);
        List<StaffCabin> tempL=new ArrayList<StaffCabin>();
        tempL.add(staff);
        cabinCrew.put(tempF,tempL);
    }

    public static void obtainVol() {
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
