package com.week4.day5.junit;

public class EvenNumberParameterized {
    // Method to check if a number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }


    public static void main(String[] args) {
        //example of testNumbers
        int[] testNumbers = {2, 4, 6, 7, 9};

        for (int number : testNumbers) {
            System.out.println("Is " + number + " even? " + isEven(number));
        }
    }
}
