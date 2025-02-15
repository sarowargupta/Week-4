package com.week4.day5.regex;
import java.util.regex.*;

public class ExtractEmailAddresses {
    public static void main(String[] args) {

        //text example
        String text = "Contact us at support@example.com and info@company.org";

        //regex patter for email extraction
        String regex = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //find and print email address
        while(matcher.find()){
            System.out.println("Email address: " + matcher.group());
        }
    }
}
