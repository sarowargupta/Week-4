package com.week4.day2.map;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvertMapTest {
    @Test
    public void testInvertMap() {

        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        Map<Integer, List<String>> expectedMap = new HashMap<>();
        expectedMap.put(1, Arrays.asList("A", "C"));
        expectedMap.put(2, Collections.singletonList("B"));

        Map<Integer, List<String>> actualMap = InvertMap.invertMap(inputMap);

        assertEquals(expectedMap, actualMap);
    }
}
