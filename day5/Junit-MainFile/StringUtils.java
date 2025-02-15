package com.week4.day5.junit;
import java.util.*;
public class StringUtils {

    // Method to reverse a string
    public static String reverse(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    // Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //create a scanner object
        Scanner sc = new Scanner(System.in);

        //Enter test String
        System.out.println("Enter test string:");
        String testString = sc.nextLine();

        //call the method and print the result
        System.out.println("Original String: " + testString);
        System.out.println("Reversed String: " + reverse(testString));
        System.out.println("Is Palindrome: " + isPalindrome(testString));
        System.out.println("Uppercase String: " + toUpperCase(testString));
    }
}
