package com.week4.day5.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseConnectionTest {
    private DatabaseConnection databaseConnection;

    @BeforeEach
    public void setUp() {
        databaseConnection = new DatabaseConnection();
        databaseConnection.connect();
        System.out.println("Database connection initialized.");
    }

    @AfterEach
    public void tearDown() {
        databaseConnection.disconnect();
        System.out.println("Database connection closed.");
    }

    @Test
    public void testConnectionEstablished() {
        assertTrue(databaseConnection.isConnected());
    }

    @Test
    public void testConnectionClosed() {
        databaseConnection.disconnect();
        assertFalse(databaseConnection.isConnected());
    }
}
