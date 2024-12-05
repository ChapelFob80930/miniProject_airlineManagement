package org.cosmos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class MainApp {
    Random rand=new Random();

    public static void writeFlightsToCSV(String filePath, List<Flight> flights) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Flight.class).withHeader();

        mapper.writer(schema).writeValue(new File(filePath), flights);
    }

    public static List<Flight> readFlightsFromCSV(String filePath) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(Flight.class).withHeader();

        MappingIterator<Flight> iterator = mapper.readerFor(Flight.class).with(schema).readValues(new File(filePath));
        return iterator.readAll();
    }
    public static void main(String[] args) {
            // Define the CSV file path
            String csvFile = "flights.csv";

            // Create some test flight data
            List<Flight> flights = new ArrayList<>();
            flights.add(new Flight(101, "New York", "Los Angeles", "10:00 AM", "6:00 PM", "On Time", "2024-12-05"));
            flights.add(new Flight(102, "San Francisco", "Chicago", "8:00 AM", "12:00 PM", "Delayed", "2024-12-06"));

            // Write flights to CSV
            try {
                writeFlightsToCSV(csvFile, flights);
                System.out.println("Flights written to CSV successfully.");
            } catch (IOException e) {
                System.err.println("Error writing to CSV: " + e.getMessage());
            }

            // Read flights from CSV
            try {
                List<Flight> readFlights = readFlightsFromCSV(csvFile);
                System.out.println("Flights read from CSV:");
                for (Flight flight : readFlights) {
                    System.out.println(flight);
                }
            } catch (IOException e) {
                System.err.println("Error reading from CSV: " + e.getMessage());
            }
        }



}

