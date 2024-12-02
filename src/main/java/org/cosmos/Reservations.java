package org.cosmos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Reservations{
    static Scanner scanner= new Scanner(System.in);
    static Random rand=new Random();
    private int reservationNumber;
    private String dateReservation;
    private String status;
    protected static Map<Integer, Passenger> confirmedPassengerList = new HashMap<>();
    protected static Map<Integer, Reservations> reservationList = new HashMap<>();

    public Reservations(int reservationNumber, String dateReservation) {
        this.reservationNumber = reservationNumber;
        this.dateReservation = dateReservation;
        this.status = "status pending";
    }

    public static void confirmReservation(String bookingDate,Passenger pass){
        int tempId=rand.nextInt(0,1000000);
        while(!Reservations.reservationList.containsKey(tempId)){
            tempId=rand.nextInt(0,1000000);
        }
        Reservations reservation=new Reservations(tempId,bookingDate);
        reservationList.put(tempId,reservation);
        confirmedPassengerList.put(tempId,pass);
        Flight.assignPassToFlight(bookingDate,pass);
    }

    public static void cancelReservation(int bookingNumber,Passenger pass){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the departureDate and Flight Number");
        String departureDate=scanner.next();
        int flightNumber=scanner.nextInt();
        confirmedPassengerList.remove(bookingNumber);
        Flight.cancelFlightPAss(departureDate,flightNumber,pass);
    }

    public static void modifyReservation(Passenger pass){
        System.out.println("Enter your old booking date: ");
        String oldBookingDate= scanner.next();
        System.out.println("Enter your new booking date: ");
        String newBookingDate= scanner.next();
        Flight.modifyFlightForPass(newBookingDate,oldBookingDate,pass);
    }

    public static void getBookingDetails(int reservationNumber){
        Reservations temp=reservationList.get(reservationNumber);
        temp.displayReservationDetails();
    }

    public void displayReservationDetails(){
        System.out.println("Date: "+dateReservation+" Status: "+this.status);
    }
}
