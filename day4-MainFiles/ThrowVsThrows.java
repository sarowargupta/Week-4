package com.week4.day4;
import java.util.*;
public class ThrowVsThrows {

    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        //create a scanner object
        Scanner scanner = new Scanner(System.in);
        try {
            // Taking input from the user
            System.out.print("Enter the principal amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Enter the interest rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter the number of years: ");
            int years = scanner.nextInt();

            // Calculating interest
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        }catch (IllegalArgumentException e) {
        System.out.println("Invalid input: Amount and rate must be positive");
        } catch (Exception e) {
        System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
        scanner.close();

        }
    }

}
