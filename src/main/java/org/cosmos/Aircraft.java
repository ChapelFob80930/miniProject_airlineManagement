package org.cosmos;

public class Aircraft {
    private int Registration;
    private String Model;
    private int Capacity;

    public static boolean checkAvailability(Flight flight){
        if(Flight.assignedFlights.containsKey(flight)){
            return true;
        }
        else{
            return false;
        }
    }

    public void assignFLight(Flight flight){
        if(Aircraft.checkAvailability(flight)){
            Flight.assignedFlights.put(flight,this);
        }
        else{
            System.out.println("Flight already exists or is busy");
        }
    }



}
