package org.cosmos;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    // Paths to CSV files
    private static final String FLIGHT_CSV = "src/main/resources/flights.csv";
    private static final String PASSENGER_CSV = "src/main/resources/passengers.csv";
    private static final String STAFF_CABIN_CSV = "src/main/resources/staffCabin.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        initializeCSV(FLIGHT_CSV, Flight.class);
        initializeCSV(PASSENGER_CSV, Passenger.class);
        initializeCSV(STAFF_CABIN_CSV, StaffCabin.class);

        // Menu loop
        while (true) {
            System.out.println("\n==== Airline Management System ====");
            System.out.println("1. Manage Flights");
            System.out.println("2. Manage Passengers");
            System.out.println("3. Manage Cabin Staff");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageFlights(scanner);
                    break;
                case 2:
                    managePassengers(scanner);
                    break;
                case 3:
                    manageCabinStaff(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeCSV(String filePath, Class<?> clazz) {
        File file = new File(filePath);
        try {
            if (!file.exists() || file.length() == 0) {
                System.out.println("Initializing CSV: " + filePath);
                file.getParentFile().mkdirs();
                CsvMapper mapper = new CsvMapper();
                CsvSchema schema = mapper.schemaFor(clazz).withHeader();
                mapper.writer(schema).writeValue(file, new ArrayList<>());
            }
        } catch (IOException e) {
            System.err.println("Error initializing CSV file: " + e.getMessage());
        }
    }


    private static void manageFlights(Scanner scanner) {
        try {
            List<Flight> flights = readFromCSV(FLIGHT_CSV, Flight.class);
            System.out.println("\n==== Flight Management ====");
            System.out.println("1. View Flights");
            System.out.println("2. Add Flight");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Flights:");
                for (Flight flight: flights) {
                    System.out.println(flight);
                    }
            } else if (choice == 2) {
                System.out.println("Enter Flight Details:");
                System.out.print("Flight Number: ");
                int flightNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Origin: ");
                String origin = scanner.nextLine();
                System.out.print("Destination: ");
                String destination = scanner.nextLine();
                System.out.print("Departure Time: ");
                String departureTime = scanner.nextLine();
                System.out.print("Departure Date: ");
                String departureDate = scanner.nextLine();
                System.out.print("Arrival Date Time: ");
                String arrivalDateTime = scanner.nextLine();
                System.out.print("Status: ");
                String status = scanner.nextLine();

                flights.add(new Flight(flightNumber, origin, destination, departureTime, departureDate, arrivalDateTime, status));
                Flight.RegisteredFlights.put(flightNumber,new Flight(flightNumber, origin, destination, departureTime, departureDate, arrivalDateTime, status));
                Flight.availableFlight.put(departureDate,new Flight(flightNumber, origin, destination, departureTime, departureDate, arrivalDateTime, status));
                writeToCSV(FLIGHT_CSV, flights);
                System.out.println("Flight added successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error managing flights: " + e.getMessage());
        }
    }


    private static void managePassengers(Scanner scanner) {
        try {
            List<Passenger> passengers = readFromCSV(PASSENGER_CSV, Passenger.class);
            System.out.println("\n==== Passenger Management ====");
            System.out.println("1. View Passengers");
            System.out.println("2. Add Passenger");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Passengers:");
                int i=0;
                for (Passenger passenger : passengers) {
                    System.out.println("List of registered passengers: ");
                    System.out.println(i+passenger.getInfos());
                }
            } else if (choice == 2) {
                System.out.println("Enter Passenger Details:");
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Contact: ");
                String contact = scanner.nextLine();
                scanner.nextLine(); // Consume newline
                System.out.print("Passport: ");
                String passport = scanner.nextLine();

                passengers.add(new Passenger(id, name, address, contact, passport));
                writeToCSV(PASSENGER_CSV, passengers);
                System.out.println("Passenger added successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error managing passengers: " + e.getMessage());
        }
    }


    private static void manageCabinStaff(Scanner scanner) {
        try {
            List<StaffCabin> staffCabins = readFromCSV(STAFF_CABIN_CSV, StaffCabin.class);
            System.out.println("\n==== Cabin Staff Management ====");
            System.out.println("1. View Cabin Staff");
            System.out.println("2. Add Cabin Staff");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("Cabin Staff:");
                StaffCabin.obtainVol();
            } else if (choice == 2) {
                System.out.println("Enter Cabin Staff Details:");
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Address: ");
                String address = scanner.nextLine();
                System.out.print("Contact: ");
                String contact = scanner.nextLine();
                scanner.nextLine(); // Consume newline
                System.out.print("Employee Number: ");
                int numberEmp = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Hiring Date: ");
                String hiringDate = scanner.nextLine();
                System.out.print("Qualification: ");
                String qualification = scanner.nextLine();

                staffCabins.add(new StaffCabin(id, name, address, contact, numberEmp, hiringDate, qualification));
                writeToCSV(STAFF_CABIN_CSV, staffCabins);
                System.out.println("Cabin Staff added successfully.");
            }
        } catch (IOException e) {
            System.err.println("Error managing cabin staff: " + e.getMessage());
        }
    }

    private static <T> void writeToCSV(String filePath, List<T> data) throws IOException {
        if (data.isEmpty()) {
            System.out.println("No data to write to CSV.");
            return;
        }
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(data.get(0).getClass()).withHeader();
        mapper.writer(schema).writeValue(new File(filePath), data);
    }


    private static <T> List<T> readFromCSV(String filePath, Class<T> clazz) throws IOException {
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(clazz).withHeader();
        try (MappingIterator<T> iterator = mapper.readerFor(clazz).with(schema).readValues(file)) {
            return iterator.readAll();
        }
    }
}
