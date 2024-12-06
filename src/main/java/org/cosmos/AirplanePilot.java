package org.cosmos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class AirplanePilot extends Employee {

    @JsonProperty("License")
    private int Licence;
    @JsonProperty("flightHours")
    private int flightHours;
    private List<Flight> assignedFlights = new ArrayList<>();

    public AirplanePilot(int Licence, int flightHours, int id, String name, String address, int contact, int numberEmp, String hiringDate) {
        super(id, name, address, contact, numberEmp, hiringDate);
        this.Licence = Licence;
        this.flightHours = flightHours;
    }

    public int getLicence() {
        return Licence;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void assignFlight(Flight flight) {
        if (!assignedFlights.contains(flight)) {
            assignedFlights.add(flight);
            System.out.println("Pilot " + getName() + " assigned to flight " + flight);
        } else {
            System.out.println("Flight is already assigned to this pilot.");
        }
    }

    public void obtainFlight() {
        if (assignedFlights.isEmpty()) {
            System.out.println("No flights are currently assigned to pilot " + getName());
        } else {
            System.out.println("Flights assigned to pilot " + getName() + ":");
            for (Flight flight : assignedFlights) {
                System.out.println("Flight Number: " + flight.getFlightNumber()
                        + ", Origin: " + flight.getOrigin()
                        + ", Destination: " + flight.getDestination()
                        + ", Departure: " + flight.getDepartureTime());
            }
        }
    }
}
