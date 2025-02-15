package com.week4.day5.junit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
    //method to format date
    public String formatDate(String inputDate) {
        if (inputDate == null || inputDate.trim().isEmpty()) {
            throw new IllegalArgumentException("Date cannot be null or empty.");
        }
        try {
            // Define input and output date formats
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            // Parse input date
            LocalDate date = LocalDate.parse(inputDate, inputFormatter);

            // Return formatted date
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd."); // Handle invalid input
        }
    }


    public static void main(String[] args) {
        //create object of date formatter class
       DateFormatter dateFormatter = new DateFormatter();

        try {
            String formattedDate = dateFormatter.formatDate("2024-02-15");
            System.out.println("Formatted Date: " + formattedDate);
        } catch (IllegalArgumentException e) {
            //handle error
            System.out.println("Error: " + e.getMessage());
        }
    }
}
