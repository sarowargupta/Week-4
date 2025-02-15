package com.week4.day5.junit;
import java.util.*;
public class ExceptionHandling {

    // Method to divide two integers
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    // Main method to test the divide method (optional)
    public static void main(String[] args) {
        //crete a scanner object
        Scanner sc = new Scanner(System.in);
          //enter two number for division operation
        System.out.println("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        try {
            int result = divide(num1,num2);
            System.out.println("Division result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
