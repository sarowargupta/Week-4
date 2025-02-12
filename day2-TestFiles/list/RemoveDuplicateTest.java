package com.week4.day2.list;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateTest {

    @Test
    void testRemoveDuplicatesNormalList() {
        List<Integer> inputList = Arrays.asList(3, 1, 2, 2, 3, 4);
        List<Integer> expected = Arrays.asList(3, 1, 2, 4);

        List<Integer> result = RemoveDuplicate.removeDuplicates(inputList);
        assertEquals(expected, result);
    }
}
