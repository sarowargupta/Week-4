package com.week4.day5.regex;
import java.util.regex.*;

public class ExtractProgrammingLanguage {
    public static void main(String[] args) {

        // Example input text
        String inputText = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        // Regex pattern
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher to find the matches
        Matcher matcher = pattern.matcher(inputText);

        // Find and print all matching Text to the list
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
