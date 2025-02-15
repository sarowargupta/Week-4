package com.week4.day5.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(15, calculator.add(10, 5));

    }

    @Test
    public void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5));

    }

    @Test
    public void testMultiply() {
        assertEquals(50, calculator.multiply(10, 5));

    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(10, 5), 0.0001);

    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}