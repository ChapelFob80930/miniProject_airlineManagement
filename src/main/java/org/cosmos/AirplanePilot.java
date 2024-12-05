package org.cosmos;

import java.util.Map;

public class AirplanePilot extends Employee{

    private final int Licence;
    private final int flightHours;
    protected static Map<Flight,AirplanePilot> FlightPilot;

    public AirplanePilot(int id, String name, String address, int contact, int numberEmp, String hiringDate, int licence, int flightHours) {
        super(id, name, address, contact, numberEmp, hiringDate);
        this.Licence = licence;
        this.flightHours = flightHours;
    }

    public static void assignFlight(String DepartureDate, AirplanePilot Pilot){
        Flight temp=Flight.availableFlight.get(DepartureDate);
        if(temp!=null){
            FlightPilot.put(temp,Pilot);
            System.out.println(Pilot.getInfos()+" assigned to "+temp.getFlight(temp.flightNumber));
        }
    }

    public static void obtainFlight(){
        for(Flight tempF:AirplanePilot.FlightPilot.keySet()){
            for(AirplanePilot tempAP:AirplanePilot.FlightPilot.values()){
                System.out.println(tempF.getFlight(tempF.flightNumber)+" --> "+tempAP.getInfos());
            }
        }
    }
}
