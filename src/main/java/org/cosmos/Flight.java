package org.cosmos;
import java.util.Scanner;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.Random;

public class Flight{
    static Random rand=new Random();
    Scanner scanner=new Scanner(System.in);
    private int flightNumber;
    protected String origin;
    private String destination;
    private String departureTime;
    private String departureDate;
    private String arrivalDateTime;
    private String status;
    protected static Map<String,Flight> availableFlight=new HashMap<String,Flight>();
    protected static Map<Flight,Aircraft> assignedFlights=new HashMap<Flight,Aircraft>();
    private List<Passenger> passengerList=new ArrayList<Passenger>();


    public void planFlight(int flightNumber, String origin, String destination, String departureTime, String arrivalDateTime, String status, String departureDate) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDate=departureDate;
        this.departureTime = departureTime;
        this.arrivalDateTime = arrivalDateTime;
        this.status = status;
        availableFlight.put(departureDate,this);
    }

    public void getFlight(String flightNumber){
        Flight temp=availableFlight.get(flightNumber);
        if(temp!=null){
            System.out.println("Origin: "+temp.origin+"  Destination: "+temp.destination+"  Departure Time: "+temp.departureTime+"  Arrival time: "+temp.arrivalDateTime+"  Status: "+temp.status);
        }
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

}
