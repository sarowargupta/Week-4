package com.week4.day5.regex;
import java.util.regex.*;

public class ExtractDate {
    public static void main(String[] args) {

        //text example
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        //regex patter
        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //find and print the dates
        while(matcher.find()){
            System.out.println("Dates : " + matcher.group());
        }
    }
}
