package org.cosmos;

import java.util.Scanner;

public class Employee extends Person {
    private final int employeeNumber;
    private final String hiringDate;

    public Employee(int id, String name, String address, int contact, int employeeNumber, String hiringDate) {
        super(id, name, address, contact);
        this.employeeNumber = employeeNumber;
        this.hiringDate = hiringDate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public static void employeeMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n==== Employee Menu ====");
            System.out.println("1. Manage Flights");
            System.out.println("2. Manage Passengers");
            System.out.println("3. Manage Cabin Staff");
            System.out.println("4. Back");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Flight.manageFlights(scanner);
                    break;
                case 2:
                    Passenger.passengerMenu(scanner);
                    break;
                case 3:
                    StaffCabin.manageCabinStaff(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public String getRole() {
        return "Employee Number: " + employeeNumber + "\nHiring Date: " + hiringDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Employee Number=" + employeeNumber +
                ", Hiring Date='" + hiringDate + '\'' +
                ", " + super.toString() +
                '}';
    }
}
