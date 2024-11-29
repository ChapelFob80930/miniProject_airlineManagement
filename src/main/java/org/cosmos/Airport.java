package org.cosmos;

import java.util.HashMap;
import java.util.Map;

public class Airport{
    private String name;
    private String city;
    private String description;

    private Map<Integer,Flight> flightAssignment;

    public Airport(String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
        this.flightAssignment=new HashMap<Integer,Flight>();
    }

    //private void assignFlight(){}
}
