package com.week4.day2.map;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.week4.day2.map.WordFrequencyCounter.calculateWordFrequency;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordFrequencyCounterTest {
    @Test
    public void testWordFrequency() {
        String inputText = "Hello world, hello Java!";

        HashMap<String, Integer> expectedWordCount = new HashMap<>();
        expectedWordCount.put("hello", 2);
        expectedWordCount.put("world", 1);
        expectedWordCount.put("java", 1);

        HashMap<String, Integer> actualWordCount = calculateWordFrequency(inputText);

        assertEquals(expectedWordCount, actualWordCount);
    }



}
