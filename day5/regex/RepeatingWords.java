package com.week4.day5.regex;

import java.util.*;
import java.util.regex.*;

public class RepeatingWords {
    public static void main(String[] args) {

        //text example
        String text = "This is is a repeated repeated word test.";

        //regex pattern
        String regex = "\\b\\w+\\b";

        //compile regex pattern
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Using a list to store words and find repeats
        List<String> words = new ArrayList<>();
        List<String> repeatedWords = new ArrayList<>();

        //find and print repeated word
        while (matcher.find()) {

            // Convert to lowercase
            String word = matcher.group().toLowerCase();
            if (words.contains(word) && !repeatedWords.contains(word)) {

                // Add to repeated words list if seen before
                repeatedWords.add(word);
            } else {

                // Store unique words
                words.add(word);
            }
        }

        // Print repeated words
        System.out.println("Repeated Words: " + repeatedWords);

    }
}
