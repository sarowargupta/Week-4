package com.week4.day2.map;
import java.util.*;

public class InvertMap {
    // Method to invert a map
    public static Map<Integer, List<String>> invertMap(Map<String, Integer> inputMap) {
        Map<Integer, List<String>> invertedMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : inputMap.entrySet()) {
            Integer value = entry.getValue();
            String key = entry.getKey();

            // Add the key to the list for the given value
            if (!invertedMap.containsKey(value)) {
                invertedMap.put(value, new ArrayList<>());
            }
            invertedMap.get(value).add(key);
        }

        return invertedMap;
    }
    public static void main(String[] args) {
        // Input map
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        // Call the method to invert the map
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);

        // Print the inverted map
        System.out.println("Inverted Map: " + invertedMap);
    }


}
