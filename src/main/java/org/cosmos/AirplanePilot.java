package org.cosmos;

import java.util.ArrayList;
import java.util.List;

public class AirplanePilot extends Employee {
    private int licenseNumber;
    private int flightHours;
    private List<Flight> assignedFlights = new ArrayList<>();

    public AirplanePilot(int id, String name, String address, int contact, int employeeNumber, String hiringDate, int licenseNumber, int flightHours) {
        super(id, name, address, contact, employeeNumber, hiringDate);
        this.licenseNumber = licenseNumber;
        this.flightHours = flightHours;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }

    public void assignFlight(Flight flight) {
        if (!assignedFlights.contains(flight)) {
            assignedFlights.add(flight);
            System.out.println("Pilot " + getName() + " assigned to flight " + flight.getFlightNumber());
        } else {
            System.out.println("Flight is already assigned to this pilot.");
        }
    }

    public void obtainFlights() {
        if (assignedFlights.isEmpty()) {
            System.out.println("No flights are currently assigned to pilot " + getName());
        } else {
            System.out.println("Flights assigned to pilot " + getName() + ":");
            for (Flight flight : assignedFlights) {
                System.out.println(flight);
            }
        }
    }

    @Override
    public String toString() {
        return "AirplanePilot{" +
                "License Number=" + licenseNumber +
                ", Flight Hours=" + flightHours +
                ", " + super.toString() +
                '}';
    }
}
