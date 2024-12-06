package org.cosmos;

import java.util.*;

public class Flight {
    protected int flightNumber;
    protected String origin;
    private String destination;
    private String departureTime;
    private String departureDate;
    private String arrivalDateTime;
    private String status;
    protected static Map<String, Flight> availableFlights = new HashMap<>();
    private final List<Passenger> passengerList = new ArrayList<>();

    public Flight(int flightNumber, String origin, String destination, String departureTime,
                  String departureDate, String arrivalDateTime, String status) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
        availableFlights.put(departureDate, this);
    }

    public static void manageFlights(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Flight Management Menu ====");
            System.out.println("1. View All Flights");
            System.out.println("2. Add a Flight");
            System.out.println("3. Remove a Flight");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllFlights();
                    break;
                case 2:
                    addFlight(scanner);
                    break;
                case 3:
                    removeFlight(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewAllFlights() {
        if (availableFlights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }
        System.out.println("Available Flights:");
        for (Flight flight : availableFlights.values()) {
            System.out.println(flight);
        }
    }

    private static void addFlight(Scanner scanner) {
        System.out.print("Enter Flight Number: ");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Origin: ");
        String origin = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Departure Time: ");
        String departureTime = scanner.nextLine();
        System.out.print("Enter Departure Date: ");
        String departureDate = scanner.nextLine();
        System.out.print("Enter Arrival DateTime: ");
        String arrivalDateTime = scanner.nextLine();
        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Flight newFlight = new Flight(flightNumber, origin, destination, departureTime, departureDate, arrivalDateTime, status);
        System.out.println("Flight added successfully.");
    }

    private static void removeFlight(Scanner scanner) {
        System.out.print("Enter Departure Date of the Flight to Remove: ");
        String departureDate = scanner.nextLine();
        Flight flight = availableFlights.get(departureDate);

        if (flight != null) {
            availableFlights.remove(departureDate);
            System.out.println("Flight removed successfully.");
        } else {
            System.out.println("No flight found with the given departure date.");
        }
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }
    public static void assignPassToFlight(String bookingDate, Passenger passenger) {
        Flight flight = availableFlights.get(bookingDate);
        if (flight == null) {
            System.out.println("No flight available for the given date: " + bookingDate);
            return;
        }
        if (!flight.passengerList.contains(passenger)) {
            flight.passengerList.add(passenger);
            System.out.println("Passenger added to flight on " + bookingDate);
        } else {
            System.out.println("Passenger is already assigned to this flight.");
        }
    }

    @Override
    public String toString() {
        return "Flight Number: " + flightNumber +
                ", Origin: " + origin +
                ", Destination: " + destination +
                ", Departure Time: " + departureTime +
                ", Departure Date: " + departureDate +
                ", Arrival DateTime: " + arrivalDateTime +
                ", Status: " + status;
    }
}
