package com.week4.day2.list;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrequencyOfElementTest {
    @Test
    void testCountFrequencyNormalList() {
        List<String> inputList = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("apple", 2);
        expected.put("banana", 1);
        expected.put("orange", 1);

        Map<String, Integer> result = FrequencyOfElement.countFrequency(inputList);
        assertEquals(expected, result);
    }
}
