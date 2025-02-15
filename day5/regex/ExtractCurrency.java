package com.week4.day5.regex;
import java.util.regex.*;

public class ExtractCurrency {
    public static void main(String[] args) {

        //text example
        String text = "The price is $45.99, and the discount is 10.50.";

        //regex pattern
        String regex = "\\$?\\d+\\.\\d{2}";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //find and print currency values
        while(matcher.find()){
            System.out.println("Extracted Currency Values: " + matcher.group());
        }
    }
}
