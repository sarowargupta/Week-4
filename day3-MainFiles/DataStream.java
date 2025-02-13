package com.week4.day3;
import java.io.*;

public class DataStream {
    // Method to write student details to a binary file
    public static void writeStudentData(String fileName, int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName, true))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Data written to file successfully for Roll Number: " + rollNumber);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read multiple student details from a binary file
    public static void readStudentData(String fileName) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Reading student details from file:");
            while (dis.available() > 0) {
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                // Display the student details
                System.out.println("Roll Number: " + rollNumber);
                System.out.println("Name: " + name);
                System.out.println("GPA: " + gpa);
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/resources/data.txt";

        // Writing multiple student details
        writeStudentData(fileName, 101, "John ", 8.5);
        writeStudentData(fileName, 102, "Alice ", 7.5);
        writeStudentData(fileName, 103, "Bob ", 9.0);

        // Reading and displaying all student details
        readStudentData(fileName);
    }
}
