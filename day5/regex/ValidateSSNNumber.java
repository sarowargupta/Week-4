package com.week4.day5.regex;
import java.util.regex.*;

public class ValidateSSNNumber {

    //method to check validation of Social Security Number(SSN)
    public static boolean isValidCode(String securityNumbers){

        //regex pattern
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";

        //Compile regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(securityNumbers);

        return matcher.matches();
    }
    public static void main(String[] args) {

        //Examples Social Security Number
        String[] securityNumber = {"123-45-6789","123456789"};

        //print the result
        for(String securityNumbers:securityNumber){
            System.out.println(securityNumbers+ ": " + (isValidCode(securityNumbers)?"valid":"Invalid"));
        }
    }

}
