package org.cosmos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airport{
    private final String name;
    private final String city;
    private final String description;
    private List<Flight> flightsAssignedToAirport=new ArrayList<>();



    public Airport(String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }

    private static void assignFlight(String departureDate,Airport airport){
        if(Flight.availableFlight.containsKey(departureDate)){
            Flight temp=Flight.availableFlight.get(departureDate);
            if(temp.origin.equals(airport.city)){
                airport.flightsAssignedToAirport.add(temp);
            }
        }
        else{
            System.out.println("Flight origin and airport city must match");
        }
    }
}
