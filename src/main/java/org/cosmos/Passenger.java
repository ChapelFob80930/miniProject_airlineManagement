package org.cosmos;

import java.util.Scanner;

public class Passenger extends Person {
    private String passport;

    public Passenger(int id, String name, String address, int contact, String passport) {
        super(id, name, address, contact);
        this.passport = passport;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public static void passengerMenu(Scanner scanner) {
        System.out.println("\n==== Passenger Menu ====");
        System.out.println("1. Book a Flight");
        System.out.println("2. Modify a Flight Booking");
        System.out.println("3. Cancel a Flight Booking");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                bookFlight(scanner);
                break;
            case 2:
                modifyFlight(scanner);
                break;
            case 3:
                cancelFlight(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void bookFlight(Scanner scanner) {
        System.out.print("Enter your ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your Contact Number: ");
        int contact = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter your Passport Number: ");
        String passport = scanner.nextLine();

        Passenger passenger = new Passenger(id, name, address, contact, passport);
        System.out.print("Enter the flight date you want to book (YYYY-MM-DD): ");
        String bookingDate = scanner.nextLine();

        Reservations.confirmReservation(bookingDate, passenger);
        System.out.println("Booking successful for flight on " + bookingDate);
    }

    public static void modifyFlight(Scanner scanner) {
        System.out.print("Enter your old booking date :");
        String oldBookingDate = scanner.nextLine();
        System.out.print("Enter your new booking date :");
        String newBookingDate = scanner.nextLine();

        System.out.print("Enter your ID: ");
        int id = scanner.nextInt();

        Passenger passenger = Reservations.confirmedPassengerList.get(id);
        if (passenger != null) {
            Reservations.modifyReservation(passenger);
            System.out.println("Booking updated successfully.");
        } else {
            System.out.println("No booking found for the provided ID.");
        }
    }

    public static void cancelFlight(Scanner scanner) {
        System.out.print("Enter your reservation ID: ");
        int reservationID = scanner.nextInt();

        Passenger passenger = Reservations.confirmedPassengerList.get(reservationID);
        if (passenger != null) {
            Reservations.cancelReservation(reservationID, passenger);
            System.out.println("Booking canceled successfully.");
        } else {
            System.out.println("No booking found for the provided reservation ID.");
        }
    }
}
