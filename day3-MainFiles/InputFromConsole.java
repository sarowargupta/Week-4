package com.week4.day3;
import java.io.*;

public class InputFromConsole{

    // Method to save data to a file
    public static boolean saveDataToFile(String fileName, String data) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(data);
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + e.getMessage());
            return false;
        }
    }
    // Method to collect user data from console
    public static String collectUserData() {
        StringBuilder userData = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter your name: ");
            String name = reader.readLine();

            System.out.print("Enter your age: ");
            String age = reader.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = reader.readLine();

            userData.append("Name: ").append(name).append("\n");
            userData.append("Age: ").append(age).append("\n");
            userData.append("Favorite Language: ").append(language).append("\n");

        } catch (IOException e) {
            System.out.println("An error occurred while reading input: " + e.getMessage());
        }
        return userData.toString();
    }
    public static void main(String[] args) {
        String fileName = "src/main/resources/Console.txt";
        System.out.println("Collecting user data...");

        //call the method collect user data from console
        String userData = collectUserData();

        //call the method save the to a file
        boolean isSaved = saveDataToFile(fileName, userData);

        if (isSaved) {
            System.out.println("User data saved successfully to " + fileName);
        } else {
            System.out.println("Failed to save user data.");
        }
    }

}

