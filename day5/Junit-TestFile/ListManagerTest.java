package com.week4.day5.junit;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {
    List<Integer> list = new ArrayList<>();

    @Test
    public void testAddElement() {

        ListManager.addElement(list, 10);
        ListManager.addElement(list, 20);
        assertEquals(2, list.size());
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    @Test
    public void testRemoveElement() {

        list.add(10);
        list.add(20);
        list.add(30);
        ListManager.removeElement(list, 20);
        assertEquals(2, list.size());
        assertFalse(list.contains(20));

        // Element not in the list
        ListManager.removeElement(list, 40);

        // Size remains unchanged
        assertEquals(2, list.size());
    }

    @Test
    public void testGetSize() {
        assertEquals(0, ListManager.getSize(list));
        list.add(10);
        list.add(20);
        assertEquals(2, ListManager.getSize(list));
    }
}