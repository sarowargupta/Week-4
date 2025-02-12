package com.week4.day2.list;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseListTest {
    @Test
    void testReverseArrayList() {
        List<Integer> arrayList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> expected = new ArrayList<>(List.of(5, 4, 3, 2, 1));

        ReverseList.reverseList(arrayList);
        assertEquals(expected, arrayList);
    }
    @Test
    void testReverseLinkedList() {
        List<Integer> linkedList = new LinkedList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> expected = new LinkedList<>(List.of(5, 4, 3, 2, 1));

        ReverseList.reverseList(linkedList);
        assertEquals(expected, linkedList);
    }
}
