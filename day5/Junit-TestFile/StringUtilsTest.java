package com.week4.day5.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    public void testReverse() {
        assertEquals("olleh", StringUtils.reverse("hello"));

    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtils.isPalindrome("madam"));

    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtils.toUpperCase("hello"));

    }
}
