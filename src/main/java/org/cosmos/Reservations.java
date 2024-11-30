package org.cosmos;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Reservations{
    Random rand=new Random();
    private int reservationNumber;
    private LocalDate dateReservation;
    private String status;
    protected static Map<Integer, Passenger> BookingList = new HashMap<>();

    public void confirmReservation(){}
    public static void cancelReservation(int bookingNumber){
        BookingList.remove(bookingNumber);
    }
    public void modifyReservation(){}
}
