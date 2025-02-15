package com.week4.day5.junit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionHandlingTest {


    @Test public void testDivide_Success() {
        assertEquals(5, ExceptionHandling.divide(10, 2));
        assertEquals(-5, ExceptionHandling.divide(-10, 2));
        assertEquals(0, ExceptionHandling.divide(0, 5));
    }

    @Test
    public void testDivide_ThrowsException() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> ExceptionHandling.divide(10, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

}
