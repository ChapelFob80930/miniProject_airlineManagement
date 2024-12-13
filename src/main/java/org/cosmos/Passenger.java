package org.cosmos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Passenger extends Person{
    @JsonProperty("Passport")
    private String Passport;
    protected static Map<Integer,Passenger> existingID= new HashMap<Integer, Passenger>();

    public Passenger(@JsonProperty("id") int id,@JsonProperty("name") String name,@JsonProperty("address") String address,@JsonProperty("contact") String contact, @JsonProperty("Passport") String passport) {
        super(id, name, address, contact);
        Passport = passport;
        existingID.put(id,this);
    }

    public void bookFlight(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your passport number: ");
        String passport = scanner.next();
        this.Passport = passport;
        System.out.println("Enter the place your traveling from: ");
        String departure = scanner.next();

        System.out.println("Enter your destination: ");
        String destination = scanner.next();

        System.out.println("Enter the date of traveling: ");// will adjust the format of the date later;
        String dateofjourney = scanner.next();

        System.out.println("Enter the number of travellers: ");
        int numberoftravellers = scanner.nextInt();

        System.out.println("Booking for flight from "+departure+" to "+destination+" on "+ dateofjourney);
        String bookingDate = dateofjourney;

        Reservations.confirmReservation(bookingDate, this);

        System.out.println("Booking has been successfully made :)\n Thank you");
        // will add a method to modifly directly from here by saying enter xx to modify ur booking;

    }


    public void cancelBook(int BookingNumber){

        Reservations.cancelReservation(BookingNumber,this);
    }

    public void getBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your reservation ID: ");
        int reservationID = scanner.nextInt();
        Reservations.getBookingDetails(reservationID);
    }
}
