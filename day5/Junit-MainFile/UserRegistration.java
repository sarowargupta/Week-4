package com.week4.day5.junit;

public class UserRegistration {

    // Method to register a user
    public void registerUser(String username, String email, String password) {
        // Validate username
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }

        // Validate email format
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$") ) {
            throw new IllegalArgumentException("Invalid email format.");
        }

        // Validate password length
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }

        System.out.println("User registered successfully: " + username);
    }

    public static void main(String[] args) {
        //create ab object of user registration class
        UserRegistration registration = new UserRegistration();

        try {
            registration.registerUser("Alice", "Alice@example.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }
}
