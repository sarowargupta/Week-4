package com.week4.day5.regex;

public class ReplaceMultiWithSingleSpace {
    public static void main(String[] args) {
        //example text
        String text = "This    is  an     example   with  multiple spaces.";

        // Replace multiple spaces with one space
        String replacedText = text.replaceAll("\\s+", " ");

        //print result
        System.out.println("Original: " + text);
        System.out.println("Formatted: " + replacedText);
    }
}



