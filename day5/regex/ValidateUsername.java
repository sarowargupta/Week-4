package com.week4.day5.regex;
import java.util.regex.*;

public class ValidateUsername {

    //method to check username is valid or not
    public static boolean isValidUserName(String userNames){
        String regex = "^[a-zA-z][a-zA-Z0-9_]{4,14}$";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the userName against the regex pattern
        Matcher matcher = pattern.matcher(userNames);

        //return if username valid or not
        return matcher.matches();
    }
    public static void main(String[] args) {

        //Examples of username
        String[] userName = {"user_123", "123user", "us"};

        //print result
        for(String userNames:userName){
            System.out.println(userNames+ ": " + (isValidUserName(userNames)?"valid":"Invalid"));
        }
    }
}
