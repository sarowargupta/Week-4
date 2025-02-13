package com.week4.day2.map;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighestValueTest {
    @Test
    public void testFindKeyWithMaxValue() {

        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 10);
        inputMap.put("B", 20);
        inputMap.put("C", 15);

        String expectedKey = "B";

        String actualKey = HighestValue.findKeyWithMaxValue(inputMap);

        assertEquals(expectedKey, actualKey);
    }

}
