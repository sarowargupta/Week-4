package com.week4.day3;
import java.io.*;
import java.util.*;

// Employee class representing a serializable object
class Employee implements Serializable {
    // Ensures version compatibility during deserialization
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    // Constructor to initialize employee details
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Overriding toString() to provide a readable format for employee details
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Serialization {

    private static final String fileName = "src/main/resources/serialFile.txt";

    // Method to save a list of employees to a file using ObjectOutputStream
    public static void saveEmployees(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Serialize the list of employees
            oos.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            // Handle any IO exceptions that may occur
            System.out.println("Error saving employees: " + e.getMessage());
        }
    }

    // Method to load a list of employees from a file using ObjectInputStream:Deserialize
    public static List<Employee> loadEmployees() {
         List<Employee> employees ;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {

            // Deserialize and return the list of employees
            employees = (List<Employee>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

            // Handle exceptions and return an empty list if an error occurs
            System.out.println("Error loading employees: " + e.getMessage());
            return new ArrayList<>();
        }
        return employees;
    }

    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 75000));
        employees.add(new Employee(2, "Jane Smith", "HR", 68000));
        employees.add(new Employee(3, "Mike Johnson", "Finance", 72000));

        // Save the list of employees to the file
        saveEmployees(employees);

        // Load the list of employees from the file and display them
        List<Employee> retrievedEmployees = loadEmployees();
        for (Employee employee : retrievedEmployees) {
            // Print each employee
            System.out.println(employee);
        }

    }
}
