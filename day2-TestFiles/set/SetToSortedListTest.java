package com.week4.day2.set;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetToSortedListTest {
    @Test
    public void testConvertSetToSortedList() {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        List<Integer> expectedSortedList = Arrays.asList(1, 3, 5, 9);

        List<Integer> actualSortedList = SetToSortedList.convertSetToSortedList(inputSet);
        assertEquals(expectedSortedList, actualSortedList);
    }
}
