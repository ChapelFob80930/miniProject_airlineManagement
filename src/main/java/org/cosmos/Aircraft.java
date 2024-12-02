package org.cosmos;

public class Aircraft {
    private final int Registration;
    private final String Model;
    private int Capacity;

    public Aircraft(int registration, String model, int capacity) {
        this.Registration = registration;
        this.Model = model;
        this.Capacity = capacity;
    }

    public static boolean checkAvailability(Flight flight){
        return Flight.assignedFlights.containsKey(flight);
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
