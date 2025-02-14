package com.week4.day4;

import java.util.InputMismatchException;
import java.util.*;

public class RunTimeException {

    //method for performing division operation between two number
    public static void performDivision(int numerator, int denominator) {
        try {
                int result = numerator / denominator;
                System.out.println("Result of the division: " + result);

        } catch (ArithmeticException e) {

            //Handle Arithmetic exception
            System.out.println("Arithmetic exception occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        //create a scanner object
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter two number:");
            int number1 = sc.nextInt();
            int number2 = sc.nextInt();

            //call the method to perform division operation
            performDivision(number1, number2);

        } catch (InputMismatchException e) {
            System.out.println("error: enter valid numbers ");
        } finally {
            sc.close();
        }
    }
}
