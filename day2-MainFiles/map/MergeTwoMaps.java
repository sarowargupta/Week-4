package com.week4.day2.map;
import java.util.*;

public class MergeTwoMaps {
    // Method to merge two maps and sum values for common keys
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> mergedMap = new HashMap<>(map1);

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }
    public static void main(String[] args) {
        // Input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the two maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Print the merged map
        System.out.println("Merged Map: " + mergedMap);
    }

}

