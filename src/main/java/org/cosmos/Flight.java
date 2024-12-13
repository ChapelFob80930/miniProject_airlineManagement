package org.cosmos;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Scanner;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.Random;

public class Flight{
    static Random rand=new Random();
    Scanner scanner=new Scanner(System.in);
    @JsonProperty("flightNumber")
    protected int flightNumber;

    @JsonProperty("origin")
    protected String origin;

    @JsonProperty("destination")
    private String destination;

    @JsonProperty("departureTime")
    private String departureTime;

    @JsonProperty("departureDate")
    private String departureDate;

    @JsonProperty("arrivalDateTime")
    private String arrivalDateTime;

    @JsonProperty("status")
    private String status;

    protected static Map<Integer,Flight> RegisteredFlights=new HashMap<Integer,Flight>();
    protected static Map<String,Flight> availableFlight=new HashMap<String,Flight>();
    protected static Map<Flight,Aircraft> assignedFlights=new HashMap<Flight,Aircraft>();
    private List<Passenger> passengerList=new ArrayList<Passenger>();

    /*public Flight(int flightNumber, String origin, String destination, String departureTime, String departureDate, String arrivalDateTime, String status) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
        availableFlight.put(departureDate,this);
    }*/

    public Flight(){

    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getStatus() {
        return status;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public Flight(@JsonProperty("flightNumber") int flightNumber, @JsonProperty("origin") String origin,
                  @JsonProperty("destination") String destination, @JsonProperty("departureTime") String departureTime,
                  @JsonProperty("departureDate") String departureDate, @JsonProperty("arrivalDateTime") String arrivalDateTime,
                  @JsonProperty("status") String status) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
        availableFlight.put(departureDate, this);
    }

    public Flight planFlight() {
        System.out.println("Enter flightNumber: ");
        int fn=scanner.nextInt();
        System.out.println("Enter origin: ");
        String o=scanner.next();
        System.out.println("Enter destination: ");
        String d=scanner.next();
        System.out.println("Enter departureTime");
        String dt=scanner.next();
        System.out.println("Enter departureDate: ");
        String dd=scanner.next();
        System.out.println("Enter arrivalDateTime: ");
        String atd=scanner.next();
        System.out.println("Enter status: ");
        String st=scanner.next();
        return new Flight(fn,o,d,dt,dd,atd,st);
    }

    public String getFlight(int flightNumber){
        Flight temp=RegisteredFlights.get(flightNumber);
        if(temp!=null){
            return ("Origin: "+temp.origin+"  Destination: "+temp.destination+"  Departure Time: "+temp.departureTime+"  Arrival time: "+temp.arrivalDateTime+"  Status: "+temp.status);
        }
        return "Flight not Found";
    }

    public static void cancelFlightAdmin(String departureDate,int flightNumber){
        if(availableFlight.containsKey(departureDate)){
            for(Flight flight:availableFlight.values())
            {
                if(flight.flightNumber==flightNumber){
                    availableFlight.remove(departureDate);
                    System.out.println("Flight Cancelled");
                }
            }
        }
        else{
            System.out.println("Invalid Flight ID or date or, Flight does not exist");
        }
    }

    public static void cancelFlightPAss(String departureDate,int flightNumber,Passenger pass){
        if(availableFlight.containsKey(departureDate)){
            Flight temp = availableFlight.get(departureDate);
            temp.passengerList.remove(pass);
        }
        else{
            System.out.println("Invalid Flight ID or date or, Flight does not exist");
        }
    }


    public static void modifyFlightForPass(String newBookingdate,String oldBookingdate,Passenger pass){
        Flight flight=Flight.availableFlight.get(oldBookingdate);
        flight.passengerList.remove(pass);
        flight=Flight.availableFlight.get(newBookingdate);
        flight.passengerList.add(pass);
        System.out.println("Flight changed successfully to "+newBookingdate);
    }


// how do we know for what flight the admin is changing like for what flight number or something
//this function is just for design it mostly won't be used
    public void modifyFlightForAdmin(Flight flight){
        int temp=0;
        do{
            System.out.println("What do you want to modify?");
            System.out.println("1.Departure Time\n2. Arrival time\n3. Status\n4. Exit");
            temp=scanner.nextInt();
            switch (temp){
                case 1: System.out.println("Enter new Departure Time: ");
                        flight.departureTime=scanner.next();
                        System.out.println("Updated");
                        break;
                case 2: System.out.println("Enter new Arrival Time: ");
                        flight.arrivalDateTime=scanner.next();
                        System.out.println("Updated");
                        break;
                case 3: System.out.println("Enter new Status: ");
                        flight.status=scanner.next();
                        System.out.println("Updated");
                        break;
                case 4: System.out.println("Exited");
                        break;
                default: System.out.println("Invalid choice");
            }
        }while(temp!=4);
    }


    public static void listingPassenger(Flight flight){
        List<Passenger> temp=flight.passengerList;
        for(Passenger pass:temp){
            pass.getInfos();
        }
    }

    public static void assignPassToFlight(String bookingDate,Passenger pass){
        Flight flight= availableFlight.get(bookingDate);
        flight.passengerList.add(pass);
    }

    @Override
    public String toString() {
        return "\\\u001B[1m Flight number: " + this.getFlightNumber()+ " Origin: " + this.getOrigin() + " Destination: " + this.getDestination() + " Departure Date: " + this.getDepartureDate()+ " Arrival Date and Time: " +this.getArrivalDateTime();
    }
}
