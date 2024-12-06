package org.cosmos;

import java.util.*;

public class StaffCabin extends Employee {
    private String qualification;
    protected static Map<Flight, List<StaffCabin>> cabinCrew = new HashMap<>();

    public StaffCabin(int id, String name, String address, int contact, int employeeNumber, String hiringDate, String qualification) {
        super(id, name, address, contact, employeeNumber, hiringDate);
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void assignFlight(int flightNumber, StaffCabin staff) {
        Flight tempFlight = Flight.availableFlights.get(String.valueOf(flightNumber));
        if (tempFlight == null) {
            System.out.println("Flight " + flightNumber + " does not exist.");
            return;
        }
        cabinCrew.computeIfAbsent(tempFlight, k -> new ArrayList<>());
        if (!cabinCrew.get(tempFlight).contains(staff)) {
            cabinCrew.get(tempFlight).add(staff);
            System.out.println("Staff assigned to flight " + flightNumber);
        } else {
            System.out.println("Staff is already assigned to this flight.");
        }
    }

    public static void manageCabinStaff(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Cabin Staff Menu ====");
            System.out.println("1. View Cabin Staff for Flights");
            System.out.println("2. Assign Staff to Flight");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    obtainVol();
                    break;
                case 2:
                    assignStaff(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void obtainVol() {
        if (cabinCrew.isEmpty()) {
            System.out.println("No flights have cabin crew assigned.");
            return;
        }
        for (Map.Entry<Flight, List<StaffCabin>> entry : cabinCrew.entrySet()) {
            Flight flight = entry.getKey();
            List<StaffCabin> staffList = entry.getValue();
            System.out.println("Flight: " + flight.getFlightNumber());
            System.out.println("Cabin Crew:");
            for (StaffCabin staff : staffList) {
                System.out.println(staff.getInfos() + ", Qualification: " + staff.getQualification());
            }
        }
    }

    private static void assignStaff(Scanner scanner) {
        System.out.print("Enter Flight Number: ");
        int flightNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Staff ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Staff Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Staff Contact: ");
        int contact = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Employee Number: ");
        int employeeNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Hiring Date: ");
        String hiringDate = scanner.nextLine();
        System.out.print("Enter Qualification: ");
        String qualification = scanner.nextLine();

        StaffCabin staff = new StaffCabin(id, name, address, contact, employeeNumber, hiringDate, qualification);
        staff.assignFlight(flightNumber, staff);
    }

    @Override
    public String toString() {
        return "StaffCabin{" +
                "ID=" + getId() +
                ", Name='" + getName() + '\'' +
                ", Qualification='" + qualification + '\'' +
                '}';
    }
}
