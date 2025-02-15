package com.week4.day5.junit;
import java.util.*;

//Calculator class
public class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two integers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two integers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two integers
    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //create an object of calculator class
        Calculator calculator = new Calculator();

        //Enter two numbers
        System.out.println("Enter two number for operation: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        //call the methods for calculation and print result
        System.out.println("Addition: " + calculator.add(num1, num2));
        System.out.println("Subtraction: " + calculator.subtract(num1, num2));
        System.out.println("Multiplication: " + calculator.multiply(num1, num2));

        try {
            System.out.println("Division: " + calculator.divide(num1, num2));
        } catch (ArithmeticException e) {
            //Handle the exception
            System.out.println(e.getMessage());
        }
    }
}
