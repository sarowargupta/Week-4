package com.week4.day5.regex;
import java.util.regex.*;

public class ExtractCapitalizedWords {
        public static void main(String[] args) {

        //text example
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";

        //regex patter
        String regex = "\\b[A-Z][a-z]*\\b";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        //find and print all capitalized words
        while(matcher.find()){
            System.out.println("All Capitalized Words: " + matcher.group());
        }
    }

}
