package com.week4.day2.list;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateElementTest {
    @Test
    void testRotateListByTwoPositions() {
        List<Integer> inputList = Arrays.asList(10, 20, 30, 40, 50);
        List<Integer> expected = Arrays.asList(30, 40, 50, 10, 20);

        List<Integer> result = RotateElement.rotateList(inputList, 2);
        assertEquals(expected, result, "List should be rotated by 2 positions");
    }

}
