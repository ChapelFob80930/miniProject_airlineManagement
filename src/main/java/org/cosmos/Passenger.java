package org.cosmos;

import java.util.Scanner;

public class Passenger extends Person{
    private String Passport;


    public static void bookFlight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your passport number: ");
        String passport = scanner.next();
        System.out.println("Enter the place your traveling from: ");
        String departure = scanner.next();
        System.out.println("Enter your destination: ");
        String destination = scanner.next();
        System.out.println("Enter the date of traveling: ");// will adjust the format of the date later;
        String dateofjourney = scanner.next();
        System.out.println("Enter the number of travellers: ");
        int numberoftravellers = scanner.nextInt();




    }


    public void cancelBook(int BookingNumber){

        Reservations.cancelReservation(BookingNumber);
    }

    public String getBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your reservation ID: ");
        int ID = scanner.nextInt();
        // if id in the regID return booking details;
        return null;
    }
}
