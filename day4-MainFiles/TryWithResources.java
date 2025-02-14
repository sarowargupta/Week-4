package com.week4.day4;
import java.io.*;

public class TryWithResources{
    // Method to read the first line of a file
    public static String readFirstLine(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            // return the first line of the file
            return reader.readLine();
        }
    }
    public static void main(String[] args) {
        // File name
        String filePath = "src/main/resources/info.txt";

        try {
            // Call the method to read the first line
            String firstLine = readFirstLine(filePath);
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading File");
        }
    }


}
