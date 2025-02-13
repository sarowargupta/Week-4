package com.week4.day2.map;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeTwoMapsTest {
    @Test
    public void testMergeMaps() {
        // Input maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Expected result
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("A", 1);
        expectedMap.put("B", 5);
        expectedMap.put("C", 4);

        // Call the method to merge the maps
        Map<String, Integer> actualMap = MergeTwoMaps.mergeMaps(map1, map2);

        // Assert that the actual map matches the expected map
        assertEquals(expectedMap, actualMap);
    }
}
