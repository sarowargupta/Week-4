package com.week4.day5.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateFormatterTest {
     DateFormatter dateFormatter = new DateFormatter();

    @Test
    void testValidDate() {
        String result = dateFormatter.formatDate("2024-02-15");
        assertEquals("15-02-2024", result);
    }

    @Test
    void testInvalidDateFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                dateFormatter.formatDate("15-02-2024"));
        assertEquals("Invalid date format. Please use yyyy-MM-dd.", exception.getMessage());
    }

}
