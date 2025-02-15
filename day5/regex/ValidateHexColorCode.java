package com.week4.day5.regex;
import java.util.regex.*;

public class ValidateHexColorCode {

    //method to check hexColor is valid or not
    public static boolean isValidCode(String code){

        //regex pattern
        String regex = "^#[0-9A-Fa-f]{6}$";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the code against the regex pattern
        Matcher matcher = pattern.matcher(code);

        //return if hexColor valid or not
        return matcher.matches();
    }
    public static void main(String[] args) {

        //Examples of hexColor
        String[] hexColor = {"#FFA500", "#ff4500", "#123"};

        //print result
        for(String hexColors:hexColor){
            System.out.println(hexColors+ ": " + (isValidCode(hexColors)?"valid":"Invalid"));
        }
    }


}
