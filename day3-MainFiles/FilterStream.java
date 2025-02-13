package com.week4.day3;
import java.io.*;

public class FilterStream{
    //method for converting text into Lowercase
    public static void convertFileToLowercase(String inputFile, String outputFile) {
        try (
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(outputFile);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                // Convert the line to lowercase and write to the output file
                bw.write(line.toLowerCase());
                // Ensure proper line breaks
                bw.newLine();
            }
            System.out.println("File conversion completed successfully.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String inputFile = "src/main/resources/input.txt";
        String outputFile = "src/main/resources/output.txt";

        //call the method to convert uppercase to lowercase
        convertFileToLowercase(inputFile, outputFile);
    }

}