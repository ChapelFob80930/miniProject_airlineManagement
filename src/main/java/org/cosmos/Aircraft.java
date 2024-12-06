package org.cosmos;

import java.util.HashMap;
import java.util.Map;

public class Aircraft {
    private final int registrationNumber;
    private final String model;
    private int capacity;
    private static Map<Flight, Aircraft> assignedFlights = new HashMap<>();

    public Aircraft(int registrationNumber, String model, int capacity) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.capacity = capacity;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public static boolean checkAvailability(Flight flight) {
        return !assignedFlights.containsKey(flight);
    }

    public void assignFlight(Flight flight) {
        if (checkAvailability(flight)) {
            assignedFlights.put(flight, this);
            System.out.println("Flight " + flight.getFlightNumber() + " assigned to aircraft " + registrationNumber);
        } else {
            System.out.println("Flight is already assigned or aircraft is busy.");
        }
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "Registration Number=" + registrationNumber +
                ", Model='" + model + '\'' +
                ", Capacity=" + capacity +
                '}';
    }
}
