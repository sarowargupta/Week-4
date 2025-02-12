package com.week4.day2.list;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElementFromEndTest {
    @Test
    void testElement(){
        ElementFromEnd list = new ElementFromEnd();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        assertEquals("D", list.findNthFromEnd(2));
    }
}
