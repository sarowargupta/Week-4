package com.week4.day5.regex;
import java.util.regex.*;

public class IPAddressValidator {

    //method to check IP address is valid or not
    public static boolean isValidIPAddress(String securityNumbers){

        // Regex pattern to validate IPv4 address
        String regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Match the IP address against the regex pattern
        Matcher matcher = pattern.matcher(securityNumbers);

        return matcher.matches();
    }
    public static void main(String[] args) {
        // Test cases
        String[] testIPs = {
                "192.168.1.1",
                "255.255.255.255",
                "0.0.0.0",
                "256.100.50.25"
        };

        //print result
        for (String test : testIPs) {
            System.out.println(test + " : " + (isValidIPAddress(test)?"valid":"invalid"));
        }

    }
}

