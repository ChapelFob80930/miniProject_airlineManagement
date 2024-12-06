package org.cosmos;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private final String name;
    private final String city;
    private final String description;
    private final List<Flight> flightsAssignedToAirport = new ArrayList<>();

    public Airport(String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }

    public void assignFlight(String departureDate) {
        Flight flight = Flight.availableFlights.get(departureDate);
        if (flight == null) {
            System.out.println("No flight available for the given departure date.");
            return;
        }
        if (flight.getOrigin().equalsIgnoreCase(this.city)) {
            flightsAssignedToAirport.add(flight);
            System.out.println("Flight " + flight.getFlightNumber() + " assigned to airport " + this.name);
        } else {
            System.out.println("Flight origin and airport city do not match.");
        }
    }

    public void listFlights() {
        if (flightsAssignedToAirport.isEmpty()) {
            System.out.println("No flights assigned to airport " + this.name);
        } else {
            System.out.println("Flights assigned to airport " + this.name + ":");
            for (Flight flight : flightsAssignedToAirport) {
                System.out.println(flight);
            }
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Name='" + name + '\'' +
                ", City='" + city + '\'' +
                ", Description='" + description + '\'' +
                '}';
    }
}
