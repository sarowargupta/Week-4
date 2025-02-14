package com.week4.day4;
import java.util.*;

public class FinallyBlockExecution {
    public static void main(String[] args) {

        //Create a scanner object
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking two integers from the user
            System.out.print("Enter the first integer: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second integer: ");
            int num2 = scanner.nextInt();

            // Performing division
            int result = num1 / num2;
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            // The finally block always executes
            System.out.println("Operation completed.");
        }

        scanner.close();
    }
}
