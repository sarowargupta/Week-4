package com.week4.day3;
import java.io.*;

public class ReadLargeFile {
    //method to find line in which there is word error
    public static void printErrorLines(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String filePath = "src/main/resources/error.txt";

        //call the method to print line
        printErrorLines(filePath);
    }
}
