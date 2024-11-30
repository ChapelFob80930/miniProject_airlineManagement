package org.cosmos;

public class Passenger extends Person{
    private int Passport;


    public void bookFlight(){

    }
    public void cancelBook(int BookingNumber){
        Reservations.cancelReservation(BookingNumber);
    }

    public static Passenger getInstance() {
        return null;// prints that he booked or canceled the flight.....
    }
}
