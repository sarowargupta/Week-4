package com.week4.day2.map;
import java.util.HashMap;

public class WordFrequencyCounter {
    // Method to calculate the word frequency
    public static HashMap<String, Integer> calculateWordFrequency(String inputText) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();

        // Remove punctuation and convert to lowercase
        inputText = inputText.replaceAll("[^a-zA-Z ]", "").toLowerCase();

        // Split the input into words
        String[] words = inputText.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        return wordCountMap;
    }
    public static void main(String[] args) {
        // Input string to analyze
        String inputText = "Hello world, hello Java!";

        // Call the method to get the word frequency map
        HashMap<String, Integer> wordCountMap = calculateWordFrequency(inputText);

        // Print the word frequency
        System.out.println("Word Frequency Count:");
        for (HashMap.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

}

