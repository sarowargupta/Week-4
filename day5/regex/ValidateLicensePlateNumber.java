package com.week4.day5.regex;
import java.util.regex.*;

public class ValidateLicensePlateNumber {

    //method to check LicensePlateNumber is valid or not
    public static boolean isValidNumber(String numbers){

        //regex pattern
        String regex = "^[A-Z]{2}\\d{4}$";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the number against the regex pattern
        Matcher matcher = pattern.matcher(numbers);

        //return if LicensePlateNumber valid or not
        return matcher.matches();
    }
    public static void main(String[] args) {

        //Examples of License plate number
        String[] number = {"AB1234", "A12345"};

        //print result number is valid or invalid
        for(String numbers:number){
            System.out.println(numbers+ ": " + (isValidNumber(numbers)?"valid":"Invalid"));
        }
    }
}

