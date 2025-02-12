package com.week4.day2.queue;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryNumberUsingQueueTest {
    @Test
    void testGenerateBinaryNumbers_N5() {
        int N = 5;
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");
        List<String> result = BinaryNumberUsingQueue.generateBinaryNumbers(N);
        assertEquals(expected, result);
    }
}
