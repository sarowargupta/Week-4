package com.week4.day2.map;
import java.util.*;
public class HighestValue {
    // Method to find the key with the highest value
    public static String findKeyWithMaxValue(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }
        public static void main(String[] args) {
            // Input map
            Map<String, Integer> inputMap = new HashMap<>();
            inputMap.put("A", 10);
            inputMap.put("B", 20);
            inputMap.put("C", 15);

            // Find the key with the maximum value
            String maxKey = findKeyWithMaxValue(inputMap);

            // Print the result
            System.out.println("Key with the maximum value: " + maxKey);
        }

}
