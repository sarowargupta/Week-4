package com.week4.day5.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest{

    PasswordValidator validator = new PasswordValidator();

    @Test
    void testValidPassword() {
        assertTrue(validator.isValidPassword("Password1"));
        assertTrue(validator.isValidPassword("Secure123"));
    }

    @Test
    void testShortPassword() {
        assertFalse(validator.isValidPassword("Pass1"));
    }

    @Test
    void testEmptyPassword() {
        assertFalse(validator.isValidPassword(""));
    }
}
