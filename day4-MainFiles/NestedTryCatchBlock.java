package com.week4.day4;
import java.util.*;

public class NestedTryCatchBlock {

    // Method to perform division with nested try-catch
    public static void performDivision(int[] array, int index, int divisor) {
        try {
            // Outer try-catch to handle ArrayIndexOutOfBoundsException
            int element = array[index];

            try {
                // Inner try-catch to handle ArithmeticException
                int result = element / divisor;
                System.out.println("Division Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }
    }

    public static void main(String[] args) {
        //create a scanner object
        Scanner scanner = new Scanner(System.in);

        // Taking array input from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter elements for the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Taking index and divisor input
        System.out.print("Enter the index of the array element to access: ");
        int index = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Call the method to perform division with nested try-catch
        performDivision(array, index, divisor);

        scanner.close();
    }


}
