package org.cosmos;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Reservations {
    private int reservationNumber;
    private String dateReservation;
    private String status;
    protected static Map<Integer, Passenger> confirmedPassengerList = new HashMap<>();
    protected static Map<Integer, Reservations> reservationList = new HashMap<>();
    private static final Random rand = new Random();

    public Reservations(int reservationNumber, String dateReservation) {
        this.reservationNumber = reservationNumber;
        this.dateReservation = dateReservation;
        this.status = "Pending";
    }

    public static void confirmReservation(String bookingDate, Passenger passenger) {
        int tempId = rand.nextInt(1000000);
        while (reservationList.containsKey(tempId)) {
            tempId = rand.nextInt(1000000);
        }
        Reservations reservation = new Reservations(tempId, bookingDate);
        reservationList.put(tempId, reservation);
        confirmedPassengerList.put(tempId, passenger);
        Flight.assignPassToFlight(bookingDate, passenger);
        System.out.println("Reservation confirmed with ID: " + tempId);
    }

    public static void modifyReservation(Passenger passenger) {
        System.out.println("Reservation modified for passenger: " + passenger.getName());
    }

    public static void cancelReservation(int reservationNumber, Passenger passenger) {
        reservationList.remove(reservationNumber);
        confirmedPassengerList.remove(reservationNumber);
        System.out.println("Reservation canceled for passenger: " + passenger.getName());
    }

    @Override
    public String toString() {
        return "Reservations{" +
                "Reservation Number=" + reservationNumber +
                ", Date Reservation='" + dateReservation + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }
}
