package com.week4.day5.regex;
import java.util.regex.*;

public class ExtractLink {
    public static void main(String[] args) {

        //text example
        String text = "Visit https://www.google.com and http://example.org for more info.";

        //regex patter for email extraction
        String regex = "\\bhttps?://(www\\.)?([a-zA-Z0-9.-]+)\\b";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //find and print email address
        while(matcher.find()){
            System.out.print("Dates : " + matcher.group() + " , ");
        }
    }
}
