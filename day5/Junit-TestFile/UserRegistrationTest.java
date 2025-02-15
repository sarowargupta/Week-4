package com.week4.day5.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("Alice", "Alice@example.com", "secure123"));
    }

    @Test
    void testEmptyUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistration.registerUser("", "johndoe@example.com", "secure123"));
        assertEquals("Username cannot be empty.", exception.getMessage());
    }

    @Test
    void testInvalidEmailFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> userRegistration.registerUser("JohnDoe", "invalidemail.com", "secure123"));
        assertEquals("Invalid email format.", exception.getMessage());
    }

}
