package com.week4.day3;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class CountWord {
    //method to count word and display Top5
    public static void countWordsAndDisplayTop5(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Sort words by frequency in descending order
        List<Entry<String, Integer>> sortedWordList = new ArrayList<>(wordCountMap.entrySet());
        sortedWordList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        System.out.println("Total unique words: " + wordCountMap.size());
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedWordList.size()); i++) {
            Entry<String, Integer> entry = sortedWordList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " times");
        }
    }
    public static void main(String[] args) {
        String filePath = "src/main/resources/Count.txt";

        //call the method
        countWordsAndDisplayTop5(filePath);
    }
}

